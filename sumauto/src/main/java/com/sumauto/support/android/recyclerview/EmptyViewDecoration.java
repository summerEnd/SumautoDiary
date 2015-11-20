package com.sumauto.support.android.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sumauto.support.utils.TextPainUtil;

/**
 * Created by Lincoln on 2015/9/15.
 */
public class EmptyViewDecoration extends RecyclerView.ItemDecoration
{
    private View mEmptyView;

    public EmptyViewDecoration(View view)
    {
        this.mEmptyView = view;
    }

    public View getEmptyView()
    {
        return mEmptyView;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state)
    {
        super.onDrawOver(c, parent, state);
        if (mEmptyView != null)
        {
            parent.drawChild(c, mEmptyView, parent.getDrawingTime());
        }
    }
}
