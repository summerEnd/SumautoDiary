package com.sumauto.diary.data.http;

import java.util.Map;

/**
 * Created by Lincoln on 2015/12/8.
 */
public class HttpParams extends com.loopj.android.http.RequestParams {
    String url;
    public HttpParams() {
    }

    public HttpParams(Map<String, String> source) {
        super(source);
    }

    public HttpParams(String key, String value) {
        super(key, value);
    }

    public HttpParams(Object... keysAndValues) {
        super(keysAndValues);
    }

    public String getUrl() {
        return url;
    }

    public HttpParams setUrl(String url) {
        this.url = url;
        return this;
    }
}
