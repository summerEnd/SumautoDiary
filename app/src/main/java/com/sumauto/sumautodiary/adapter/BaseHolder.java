package com.sumauto.sumautodiary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseHolder<ET> extends RecyclerView.ViewHolder implements View.OnClickListener{
    OnItemListener listener;
    ET data;
    public BaseHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }


    public View findViewById(int id){
        if (itemView==null){
            return null;
        }
        return itemView.findViewById(id);
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(itemView,getAdapterPosition());
        }
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
    public void setListener(OnItemListener listener) {
        this.listener = listener;
    }

    public OnItemListener getListener() {
        return listener;
    }

    public interface OnItemListener{
        void onClick(View itemView, int position);
    }
}
