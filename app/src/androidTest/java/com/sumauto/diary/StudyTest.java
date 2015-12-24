package com.sumauto.diary;

import android.test.AndroidTestCase;

import com.sumauto.diary.http.HttpInterface;
import com.sumauto.diary.http.HttpManager;
import com.sumauto.diary.http.HttpParams;
import com.sumauto.diary.http.HttpTask;
import com.sumauto.support.utils.SLog;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class StudyTest extends AndroidTestCase{
    private String TAG=getClass().getSimpleName()+">>";
    public void testIndexInfo(){
        long time=System.currentTimeMillis();
        HttpParams params=HttpInterface.indexInfo(1,15,1);
        HttpTask task=new HttpTask(params){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                SLog.debug(TAG,response);
            }
        };
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.postSync(task);
        params.put("type", 2);
        httpManager.postSync(task);
        params.put("type", 3);
        httpManager.postSync(task);
        SLog.debug(TAG, "" + (System.currentTimeMillis() - time));
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
