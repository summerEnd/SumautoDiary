package com.sumauto.sumautodiary.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sumauto.sumautodiary.R;
import com.sumauto.sumautodiary.db.DBManager;
import com.sumauto.support.utils.SLog;

public class MakeDiaryActivity extends BaseActivity
{

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_diary);
        dbManager = new DBManager(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SQLiteDatabase db = dbManager.getReadableDatabase();
                Cursor cursor = db.query("diary", null, null, null, null, null, null);
                String[] columnNames = cursor.getColumnNames();
                for (String str : columnNames)
                {
                    SLog.debug("dbManager", str);
                }
                cursor.close();
            }
        });
    }
}
