package com.sumauto.support.android.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 简单的PagerAdapter
 */
public class SimplePagerAdapter extends PagerAdapter
{
    private List<View> views;

    public SimplePagerAdapter(List<View> views)
    {
        this.views = views;
    }

    @Override
    public int getCount()
    {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {

        View v = views.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        View v = views.get(position);
        container.removeView(v);
    }
}
