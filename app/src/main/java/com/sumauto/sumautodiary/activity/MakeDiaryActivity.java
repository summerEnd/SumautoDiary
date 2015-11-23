package com.sumauto.sumautodiary.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.sumauto.sumautodiary.R;
import com.sumauto.sumautodiary.db.DBManager;
import com.sumauto.sumautodiary.utils.ViewUtils;

import org.json.JSONObject;

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
            String string = ViewUtils.getString(input_title);
            if (!"title".equals(string)) {
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
