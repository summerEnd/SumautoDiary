package com.sumauto.diary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sumauto.diary.entity.Configs;
import com.sumauto.diary.entity.Diary;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Lincoln on 2015/11/20.
 * data base
 */
@SuppressWarnings("TryWithIdenticalCatches")
public class DBManager extends SQLiteOpenHelper {

    private static final String DB_NAME = "diary.db";
    private static final int DATABASE_VERSION = 54;

    public DBManager(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO: 2015/11/20 add new table here
        createTableWith(db, Diary.class);
        createTableWith(db, Configs.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ");
        updateTableTotally(db, Diary.class);
        updateTableTotally(db, Configs.class);
    }

    private void updateTableTotally(SQLiteDatabase db, Class entity) {
        final String table = entity.getSimpleName();
        db.execSQL("DROP TABLE IF EXISTS " + table);
    }

    private void updateTable(SQLiteDatabase db, Class entity) {
        final String table = entity.getSimpleName();
        final String tempTable = table + "_backup";

        Cursor query = db.query(table, null, null, null, null, null, null, "1");
        final String oldColumns[] = query.getColumnNames();//老的表名称
        ArrayList<String> tempArray = new ArrayList<>();
        Field[] declaredFields = entity.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DBColumn.class)) {
                DBColumn dbColumn = field.getAnnotation(DBColumn.class);
                String column = field.getName();
                String define = dbColumn.value();
                tempArray.add(column);
            }
        }
        query.close();
        final String[] newColumns = new String[tempArray.size()];
        tempArray.toArray(newColumns);

        StringBuilder sql = new StringBuilder();
        sql.append("BEGIN TRANSACTION;");
        sql.append("CREATE TEMPORARY TABLE ").append(tempTable).append("(").append(buildTable(oldColumns)).append(");");
        sql.append("INSERT INTO ").append(tempTable).append("SELECT * FROM ").append(table).append(";");
        sql.append("DROP TABLE ").append(table).append(";");
        sql.append("CREATE TABLE ").append(table).append(buildTable(newColumns)).append(");");
        sql.append("BEGIN TRANSACTION;");
        sql.append("INSERT INTO ").append(table).append("SELECT * FROM ").append(tempTable).append(";");
        sql.append("DROP TABLE ").append(tempTable).append(";");
        sql.append("COMMIT;");
        db.execSQL(sql.toString());

    }

    private String buildTable(String columns[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(columns[i]);
        }
        return sb.toString();
    }

    private void addNewColumn(String table, String column, String define) {
        new StringBuilder().append("ALTER TABLE ").append(table).append(" ADD ").append(column).append(" ").append(define);
    }

    private void alertColumn(String table, String column, String define) {

    }

    /**
     * 用class创建一个表
     */
    private void createTableWith(SQLiteDatabase db, Class entity) {
        String table = entity.getSimpleName().toLowerCase();

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

    private void insertColumn(ContentValues values, String key, Object data) {
        if (data instanceof Boolean) {
            values.put(key, (Boolean) data);
        } else {
            values.put(key, String.valueOf(data));
        }
    }

    public void insert(Object obj) {
        Class clazz = obj.getClass();
        String table = clazz.getSimpleName().toLowerCase();
        Field[] declaredFields = clazz.getDeclaredFields();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            try {
                insertColumn(contentValues, f.getName(), f.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        db.insert(table, null, contentValues);
        db.close();
    }

    public void getObject(Cursor cursor, Object obj) {
        String[] columnNames = cursor.getColumnNames();
        for (String column :
                columnNames) {
            try {
                Field field = obj.getClass().getDeclaredField(column);
                field.setAccessible(true);
                field.set(obj, cursor.getString(cursor.getColumnIndex(column)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Cursor queryAll(String table) {
        return getReadableDatabase().query(table, null, null, null, null, null, null);
    }

}
