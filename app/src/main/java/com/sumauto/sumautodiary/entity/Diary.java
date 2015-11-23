package com.sumauto.sumautodiary.entity;

import com.sumauto.sumautodiary.db.DBColumn;

/**
 * Created by Lincoln on 2015/11/20.
 * diary
 */
public class Diary {
    /**
     * 日记标题
     */
    private String title;

    /**
     * 日记的内容
     */
    private String content;

    /**
     * 日记的日期
     */
    private String date;

    /**
     * 日记的图片
     */
    private String images;

    /**
     * 天气
     */
    private String weather;

    /**
     * 心情
     */
    private String mood;

    /**
     * 密码
     */
    private String secret;

    /**
     * 密码提示
     */
    private String secret_tips;
}
