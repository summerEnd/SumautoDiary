package com.sumauto.diary.data.db;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({METHOD, PARAMETER, FIELD})
public @interface DBColumn
{
    String TEXT ="TEXT";
    String NOT_COLUMN="not column";
    String value();
}
