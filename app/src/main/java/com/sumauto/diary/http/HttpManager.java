package com.sumauto.diary.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.SyncHttpClient;

public class HttpManager {

    private static HttpManager INSTANCE;

    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HttpManager();
        }
        return INSTANCE;
    }

    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private SyncHttpClient syncHttpClient = new SyncHttpClient();

    private HttpManager() {
        asyncHttpClient.setTimeout(15 * 1000);
        syncHttpClient.setTimeout(15*1000);
    }

    public AsyncHttpClient getHttpClient() {
        return asyncHttpClient;
    }

    public void postAsync(HttpTask httpTask){
        asyncHttpClient.post(httpTask.requestParams.url,httpTask.requestParams,httpTask);
    }
    public void postSync(HttpTask httpTask){
        syncHttpClient.post(httpTask.requestParams.url,httpTask.requestParams,httpTask);
    }
}
