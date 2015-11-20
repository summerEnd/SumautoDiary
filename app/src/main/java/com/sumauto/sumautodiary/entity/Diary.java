package com.sumauto.sumautodiary.entity;

import com.sumauto.sumautodiary.db.DBColumn;

/**
 * Created by Lincoln on 2015/11/20.
 * diary
 */
public class Diary
{
    @DBColumn(value = DBColumn.text)
    private String title;

    @DBColumn(value = DBColumn.text)
    private String content;

    @DBColumn(value = DBColumn.text)
    private String date;
}
