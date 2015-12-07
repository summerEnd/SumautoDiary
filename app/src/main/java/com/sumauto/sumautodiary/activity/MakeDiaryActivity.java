package com.sumauto.sumautodiary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sumauto.sumautodiary.R;
import com.sumauto.sumautodiary.db.DBManager;
import com.sumauto.sumautodiary.utils.ViewUtils;
import com.sumauto.support.utils.NavigationUtil;

import org.json.JSONObject;

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
        if (supportActionBar!=null){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_make_diary,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId){
            case R.id.menu_item_done:{
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
            case android.R.id.home:{
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
