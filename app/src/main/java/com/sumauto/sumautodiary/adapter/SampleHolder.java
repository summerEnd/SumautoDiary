package com.sumauto.sumautodiary.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sumauto.sumautodiary.entity.Dummy;
import com.sumauto.support.utils.ToastUtils;

/**
 * Created by Lincoln on 2015/12/8.
 * 示范
 */
public class SampleHolder extends BaseHolder<Dummy>{
    TextView text1;
    public SampleHolder(ViewGroup container) {
        super(container,android.R.layout.simple_list_item_1);
        text1= (TextView) findViewById(android.R.id.text1);    }

    @Override
    protected void onInit(Dummy data) {
        super.onInit(data);
        text1.setText(data.text1);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ToastUtils.toast(v.getContext(),getData().text1+" is clicked");
    }
}
