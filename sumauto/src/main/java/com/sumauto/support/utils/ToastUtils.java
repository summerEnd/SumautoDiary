package com.sumauto.support.utils;

import android.content.Context;
import android.widget.Toast;

import com.sumauto.support.config.SumautoConfig;

/**
 * Created by Lincoln on 2015/9/14.
 * Toast
 */
public class ToastUtils
{

    public static void toast_debug(Context context, Object obj)
    {
        if (SumautoConfig.isDebug())
        {
            toast(context, String.valueOf(obj));
        }
    }

    public static void toast(Context context, CharSequence msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
