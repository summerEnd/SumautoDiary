package com.sumauto.sumautodiary.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.widget.EditText;

/**
 * Created by Lincoln on 2015/11/23.
 * 一些针对View的工具类
 */
public class ViewUtils {
    @Nullable
    public static Editable getEditable(TextInputLayout inputLayout) {
        EditText editText = inputLayout.getEditText();
        return editText == null ? null : editText.getText();
    }

    @NonNull
    public static String getString(TextInputLayout inputLayout) {
        EditText editText = inputLayout.getEditText();
        return editText == null ? "" : editText.getText().toString();
    }
}
