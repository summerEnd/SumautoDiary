package com.sumauto.diary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.sumauto.diary.R;
import com.sumauto.diary.data.db.DBManager;
import com.sumauto.diary.data.entity.Diary;
import com.sumauto.diary.utils.DateUtils;
import com.sumauto.diary.utils.ViewUtils;

public class MakeDiaryActivity extends BaseActivity {

    private DBManager dbManager;
    TextInputLayout input_title;
    TextInputLayout input_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_diary);
        showUpIndicator();
        input_title = (TextInputLayout) findViewById(R.id.input_title);
        input_content = (TextInputLayout) findViewById(R.id.input_content);
        dbManager = new DBManager(this);
        ActionBar supportActionBar = getSupportActionBar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_make_diary, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menu_item_done: {
                boolean isStatusOk = true;
                String title = ViewUtils.getString(input_title);
                if (TextUtils.isEmpty(title)) {
                    input_title.setErrorEnabled(true);
                    input_title.setError(getString(R.string.empty_title));
                    isStatusOk = false;
                } else {
                    input_title.setErrorEnabled(false);
                }

                String content = ViewUtils.getString(input_content);
                if (TextUtils.isEmpty(content)) {
                    input_content.setErrorEnabled(true);
                    input_content.setError(getString(R.string.empty_content));
                    isStatusOk = false;
                } else {
                    input_content.setErrorEnabled(false);
                }
                if (!isStatusOk) return true;
                Diary diary = new Diary();
                diary.setDate(DateUtils.getNowDate());
                diary.setTitle(title);
                diary.setContent(content);
                DBManager dbManager=new DBManager(MakeDiaryActivity.this);
                dbManager.save(diary);
                finish();
                return true;
            }
            case android.R.id.home: {
                NavUtils.navigateUpFromSameTask(this);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent parentActivityIntent = NavUtils.getParentActivityIntent(this);
        startActivity(parentActivityIntent);
    }
}
