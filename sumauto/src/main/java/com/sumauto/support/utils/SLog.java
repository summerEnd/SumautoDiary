package com.sumauto.support.utils;

import android.text.TextUtils;
import android.util.Log;

import com.sumauto.support.config.SumautoConfig;

public class SLog
{

    private static String TAG = "SLog";

    public static void debug(String tag, String pattern, Object... args)
    {
        debug(tag, String.format(pattern, args));
    }

    public static void debug(String tag, Object value)
    {
        if (TextUtils.isEmpty(tag))
        {
            tag = TAG;
        }
        if (SumautoConfig.DEBUG)
        {
            Log.d(tag, String.valueOf(value));
        }
    }

    public static void error(String msg)
    {
        error("", msg);
    }

    public static void error(String tag, String msg)
    {
        if (SumautoConfig.DEBUG)
        {
            if (TextUtils.isEmpty(tag))
            {
                tag = TAG;
            }
            Log.e(tag, msg);
        }
    }
}
