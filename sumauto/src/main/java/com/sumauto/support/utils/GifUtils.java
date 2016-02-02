package com.sumauto.support.utils;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;

import com.sumauto.support.utils.GifHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class GifUtils {

    public static AnimationDrawable decodeRes(Resources res, int id) {
        return decodeRes(res, id, null);
    }

    public static AnimationDrawable decodeRes(Resources res, int id, Callback callback) {
        InputStream is = null;

        try {
            final TypedValue value = new TypedValue();
            is = res.openRawResource(id, value);

            return decodeGif(is, callback);
        } catch (Exception e) {
            /*  do nothing.
                If the exception happened on open, bm will be null.
                If it happened on close, bm is still valid.
            */
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                // Ignore
            }
        }
        return null;
    }

    public static AnimationDrawable decodeFile(File file, Callback callback) {
        AnimationDrawable animationDrawable = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            animationDrawable = decodeGif(fileInputStream, callback);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return animationDrawable;
    }


    public static AnimationDrawable decodeGif(InputStream inputStream, Callback callback) {
        GifHelper gifHelper = new GifHelper();
        if (GifHelper.STATUS_OK != gifHelper.read(inputStream)) {
            return null;
        }
        if (gifHelper.getFrameCount() <= 0) {
            return null;
        }

        AnimationDrawable animationDrawable = new AnimationDrawable();
        int frameCount = gifHelper.getFrameCount();
        Bitmap tempFrame = gifHelper.getImage();
        Resources resources = null;

        if (callback != null) {
            tempFrame = callback.onCreateFrame(tempFrame);
            resources = callback.getResources();
        }
        animationDrawable.addFrame(new BitmapDrawable(resources, tempFrame), gifHelper.getDelay(0));
        for (int i = 1; i < frameCount; i++) {
            tempFrame = gifHelper.getFrame(i);
            int delay = gifHelper.getDelay(i);
            if (delay == 0) delay = 150;
            if (callback != null) {
                tempFrame = callback.onCreateFrame(tempFrame);
            }
            animationDrawable.addFrame(new BitmapDrawable(resources, tempFrame), delay);
        }
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    public interface Callback {
        /**
         * 在这里可以处理每一帧的图片
         */
        Bitmap onCreateFrame(Bitmap frame);

        /**
         * 用来构造BitmapDrawable可以为null
         */
        Resources getResources();
    }
}
