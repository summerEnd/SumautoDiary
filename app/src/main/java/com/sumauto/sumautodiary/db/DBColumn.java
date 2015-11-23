package com.sumauto.sumautodiary.db;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Lincoln on 2015/11/20.
 */
@Retention(RUNTIME)
@Target({METHOD, PARAMETER, FIELD})
public @interface DBColumn
{
    String TEXT ="TEXT";
    String NOT_COLUMN="not column";
    String value();
}
