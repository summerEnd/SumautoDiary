package com.sumauto.support.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Lincoln on 2015/10/13.
 */
public class NavigationUtil
{
    public static void goTo(Context context,Class<? extends Activity> activity){
        context.startActivity(new Intent(context,activity));
    }
}
