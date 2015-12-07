package com.sumauto.sumautodiary.activity;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.sumauto.sumautodiary.R;

public class TestActivity extends Activity {

    private FloatingActionButton tintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        AppCompatSpinner foreground_spinner = (AppCompatSpinner) findViewById(R.id.foreground_spinner);
        AppCompatSpinner background_spinner = (AppCompatSpinner) findViewById(R.id.background_spinner);
        foreground_spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getMode()));
        background_spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getMode()));
        tintButton = (FloatingActionButton) findViewById(R.id.tintButton);
        foreground_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tintButton.setForegroundTintMode(PorterDuff.Mode.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        background_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tintButton.setBackgroundTintMode(PorterDuff.Mode.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    String[] getMode() {
        return new String[]{
                "CLEAR",
                "SRC",
                "DST",
                "SRC_OVER",
                "DST_OVER",
                "SRC_IN",
                "DST_IN",
                "SRC_OUT",
                "DST_OUT",
                "SRC_ATOP",
                "DST_ATOP",
                "XOR",
                "DARKEN",
                "LIGHTEN",
                "MULTIPLY",
                "SCREEN",
                "ADD",
                "OVERLAY"
        };
    }
}
