package com.sumauto.diary.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sumauto.diary.data.entity.Configs;
import com.sumauto.diary.data.entity.Diary;

import java.lang.reflect.Field;

/**
 * Created by Lincoln on 2015/11/20.
 * data base
 */
@SuppressWarnings("TryWithIdenticalCatches")
public class DBManager extends SQLiteOpenHelper {

    private static final String DB_NAME = "diary.db";

    public DBManager(Context context) {
        super(context, DB_NAME, null, DBVersion.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableWith(db, Diary.class);
        createTableWith(db, Configs.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==DBVersion.VERSION_1){

        }
    }

    private String tableName(Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase();
    }

    /**
     * 用class创建一个表
     */
    private void createTableWith(SQLiteDatabase db, Class entity) {
        String table = tableName(entity);
        Field[] declaredFields = entity.getDeclaredFields();
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ").append(table).append(" (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT");
        for (Field f : declaredFields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(DBColumn.class)) {
                sql.append(",");
                DBColumn column = f.getAnnotation(DBColumn.class);
                sql.append(f.getName()).append(" ").append(column.value());
            } else {
                sql.append(",");
                sql.append(f.getName()).append(" ").append(DBColumn.TEXT);

            }
        }
        sql.append(" );");
        db.execSQL(sql.toString());
    }

    public void save(Object obj) {
        Class clazz = obj.getClass();
        String table = clazz.getSimpleName().toLowerCase();
        Field[] declaredFields = clazz.getDeclaredFields();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            try {
                Object data=f.get(obj);
                String key=f.getName();
                if (data instanceof Boolean) {
                    contentValues.put(key, (Boolean) data);
                } else {
                    contentValues.put(key, String.valueOf(data));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        db.insert(table, null, contentValues);
        db.close();
    }

    public void get(Cursor cursor, Object obj) {
        String[] columnNames = cursor.getColumnNames();
        for (String column : columnNames) {
            try {
                Field field = obj.getClass().getDeclaredField(column);
                field.setAccessible(true);
                field.set(obj, cursor.getString(cursor.getColumnIndex(column)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public Cursor query(String table) {
        return getReadableDatabase().query(table, null, null, null, null, null, null);
    }

}
