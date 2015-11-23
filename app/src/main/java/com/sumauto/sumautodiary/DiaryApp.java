package com.sumauto.sumautodiary;

import android.app.Application;

import com.sumauto.support.*;

/**
 * Created by Lincoln on 2015/11/19.
 * app
 */
public class DiaryApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Initializer.init(this, BuildConfig.DEBUG);
    }
}
