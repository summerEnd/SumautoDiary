package com.sumauto.sumautodiary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseHolder<ET> extends RecyclerView.ViewHolder implements View.OnClickListener{
    ET data;
    public BaseHolder(ViewGroup container) {
        this(container,0);
    }

    public BaseHolder (ViewGroup container,int layoutID){
        super(LayoutInflater.from(container.getContext()).inflate(layoutID,container,false));
        itemView.setOnClickListener(this);
    }

    public final View findViewById(int id){
        return itemView.findViewById(id);
    }

    @Override
    public void onClick(View v) {

    }

    public final ET getData()
    {
        return data;
    }

    public final void setData(ET data)
    {
        this.data = data;
        onInit(data);
    }

    /**
     * 调用setData后悔触发这个方法，在这里进行初始化
     * @param data
     */
    protected void onInit(ET data){

    }

}
