package com.sumauto.support.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.view.Window;

/**
 * Created by Lincoln on 2015/10/13.
 * 处理一些由SDK版本不同的问题
 */
@SuppressWarnings("deprecation")
public class SDKUtils
{
    public static int getColor(Context context, @ColorRes int res)
    {
        int color;
        if (isSDKAbove(23)){
            color = context.getResources().getColor(res, null);
        }else {
            color=context.getResources().getColor(res);
        }
        return color;
    }

    public static void setStatusBarColor(Window window,int color){
        if (isSDKAbove(21)){
            window.setStatusBarColor(color);
        }
    }

    private static boolean isSDKAbove(int version){
        return Build.VERSION.SDK_INT>=version;
    }
}
