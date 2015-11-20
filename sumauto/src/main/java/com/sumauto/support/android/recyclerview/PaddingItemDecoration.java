package com.sumauto.support.android.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Lincoln on 2015/9/14.
 * 可以设置item间距
 */
public class PaddingItemDecoration extends RecyclerView.ItemDecoration
{
    private int mTop, mBottom, mLeft, mRight;

    public PaddingItemDecoration(int mTop, int mBottom, int mLeft, int mRight)
    {
        this.mTop = mTop;
        this.mBottom = mBottom;
        this.mLeft = mLeft;
        this.mRight = mRight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        outRect.set(mLeft, mTop, mRight, mTop);
    }
}
