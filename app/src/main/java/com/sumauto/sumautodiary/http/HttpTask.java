package com.sumauto.sumautodiary.http;

import android.support.annotation.NonNull;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sumauto.sumautodiary.BuildConfig;
import com.sumauto.support.utils.SLog;

public class HttpTask extends JsonHttpResponseHandler {
    private final String TAG = getClass().getSimpleName();
    @NonNull
    RequestParams requestParams;
    String url;

    public HttpTask(String url) {
        this(url, new RequestParams());
    }

    public HttpTask(String url, @NonNull RequestParams requestParams) {
        this.url = url;
        this.requestParams = requestParams;
    }


    @Override
    public void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    public void onFinish() {
        super.onFinish();
        log("onFinish");
    }

    @Override
    public void onCancel() {
        super.onCancel();
        log("onCancel");
    }

    void log(String msg) {
        if (BuildConfig.DEBUG) {
            SLog.debug(TAG, msg+":" + url + "?" + requestParams.toString());
        }
    }

    public void setRequestParams(@NonNull RequestParams requestParams) {
        this.requestParams = requestParams;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    public RequestParams getRequestParams() {
        return requestParams;
    }

    public String getUrl() {
        return url;
    }
}
