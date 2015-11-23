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
    @DBColumn(value = DBColumn.text)
    private String title;

    /**
     * 日记的内容
     */
    @DBColumn(value = DBColumn.text)
    private String content;

    /**
     * 日记的日期
     */
    @DBColumn(value = DBColumn.text)
    private String date;

    /**
     * 日记的图片
     */
    @DBColumn(value = DBColumn.text)
    private String images;

    /**
     * 天气
     */
    @DBColumn(value = DBColumn.text)
    private String weather;

    /**
     * 心情
     */
    @DBColumn(value = DBColumn.text)
    private String mood;
}
