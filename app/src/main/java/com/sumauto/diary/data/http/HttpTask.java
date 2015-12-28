package com.sumauto.diary.data.http;

import android.support.annotation.NonNull;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.sumauto.diary.BuildConfig;
import com.sumauto.support.utils.SLog;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class HttpTask extends JsonHttpResponseHandler {
    private final String TAG = getClass().getSimpleName();
    @NonNull
    HttpParams requestParams;

    public HttpTask(@NonNull HttpParams requestParams) {
        this.requestParams = requestParams;
    }


    @Override
    public void onStart() {
        super.onStart();
        log("onStart" + ":" + getRequest());
    }

    @Override
    public void onFinish() {
        super.onFinish();
        log("onFinish" + ":" + getRequest());
    }

    @Override
    public void onCancel() {
        super.onCancel();
        log("onCancel" + ":" + getRequest());
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
        log(getRequest() + "-->" + response);
    }

    void log(String msg) {
        if (BuildConfig.DEBUG) {
            SLog.debug(TAG, msg);
        }
    }

    private String getRequest() {
        return requestParams.getUrl() + "?" + requestParams.toString();
    }

    public void setRequestParams(@NonNull HttpParams requestParams) {
        this.requestParams = requestParams;
    }

    @NonNull
    public HttpParams getRequestParams() {
        return requestParams;
    }

}
