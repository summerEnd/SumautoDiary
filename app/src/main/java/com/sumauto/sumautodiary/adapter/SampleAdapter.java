package com.sumauto.sumautodiary.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sumauto.sumautodiary.entity.Dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lincoln on 2015/12/8.
 * 示范
 */
public class SampleAdapter extends BaseAdapter<Dummy,BaseHolder<Dummy>> {

    private static List<Dummy> createTempData(int count){
        ArrayList<Dummy> dataList=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Dummy dummy=new Dummy();
            dummy.text1="I'm Dummy"+i;
            dataList.add(dummy);
        }
        return dataList;
    }

    public SampleAdapter(@NonNull Context context,int sampleCount) {
        super(context,createTempData(sampleCount));
    }

    public SampleAdapter(Context context, List<Dummy> data) {
        super(context, data);
    }

    @Override
    public BaseHolder<Dummy> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleHolder(parent);
    }
}
