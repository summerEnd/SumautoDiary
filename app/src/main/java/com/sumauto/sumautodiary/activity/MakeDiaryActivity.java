package com.sumauto.sumautodiary.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.sumauto.sumautodiary.R;
import com.sumauto.sumautodiary.db.DBManager;
import com.sumauto.sumautodiary.utils.ViewUtils;
import com.sumauto.support.utils.SLog;

public class MakeDiaryActivity extends BaseActivity {

    private DBManager dbManager;
    TextInputLayout input_title;
    TextInputLayout input_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_diary);
        input_title = (TextInputLayout) findViewById(R.id.input_title);
        input_content = (TextInputLayout) findViewById(R.id.input_content);
        dbManager = new DBManager(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_make_diary,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.menu_item_done){
            if (!"title".equals(ViewUtils.getString(input_title))) {
                input_title.setErrorEnabled(true);
                input_title.setError("must be title");
            }else{
                input_title.setErrorEnabled(false);
            }

            if (!"content".equals(ViewUtils.getString(input_content))){
                input_content.setErrorEnabled(true);
                input_content.setError("must be content");
            }else{
                input_content.setErrorEnabled(false);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
