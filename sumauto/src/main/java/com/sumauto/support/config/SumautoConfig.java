package com.sumauto.support.config;

/**
 * Created by Lincoln on 2015/9/14.
 * 全局参数
 */
public class SumautoConfig
{
    public static boolean DEBUG;

    public static boolean isDebug()
    {
        return DEBUG;
    }

    public static void init(boolean isDebug)
    {
        DEBUG = isDebug;
    }
}
