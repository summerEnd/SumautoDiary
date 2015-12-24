package com.sumauto.diary.utils;

import android.support.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Lincoln on 2015/11/23.
 * 统一的日期处理
 */
public class DateUtils {
    public static final String FULL_DATE_FORMATTER = "yyyy-MM-dd hh:mm:ss";

    public static String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_DATE_FORMATTER, Locale.getDefault());
        return simpleDateFormat.format(new Date());
    }

    public static String getFormattedDate(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        Date date = parse(dateStr);
        if (date==null){
            return "date error";
        }
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @return 可能返回null
     */
    @Nullable
    public static Date parse(String dateStr) {
        try {
            return new SimpleDateFormat(FULL_DATE_FORMATTER, Locale.getDefault()).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
