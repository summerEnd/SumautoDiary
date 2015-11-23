package com.sumauto.support;

import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sumauto.support.config.SumautoConfig;
import com.sumauto.support.utils.SLog;

/**
 * Created by user1 on 2015/9/14.
 * Sumauto库初始化
 */
public class Initializer
{
    public static void init(Context context,boolean showDebugLog)
    {
        ImageLoader.getInstance().init(buildConfiguration(context));
        SumautoConfig.init(showDebugLog);
    }

    private static ImageLoaderConfiguration buildConfiguration(Context context){
        ImageLoaderConfiguration.Builder configuration=new ImageLoaderConfiguration.Builder(context);

        return configuration.build();
    }
}
