package com.sumauto.diary;

import android.app.Application;
import android.database.Cursor;

import com.sumauto.diary.data.entity.Configs;
import com.sumauto.diary.data.db.DBManager;
import com.sumauto.support.*;
import com.sumauto.support.utils.JsonUtil;
import com.umeng.onlineconfig.OnlineConfigAgent;
import com.umeng.onlineconfig.UmengOnlineConfigureListener;

import org.json.JSONObject;

/**
 * Created by Lincoln on 2015/11/19.
 * app
 */
public class DiaryApp extends Application implements UmengOnlineConfigureListener {
    private static DiaryApp INSTANCE;
    private Configs configs = new Configs();

    public static DiaryApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Initializer.init(this, BuildConfig.DEBUG);
        initConfigs();
    }

    private void initConfigs() {
        OnlineConfigAgent.getInstance().setDebugMode(BuildConfig.DEBUG);
        OnlineConfigAgent.getInstance().setOnlineConfigListener(this);
        OnlineConfigAgent.getInstance().updateOnlineConfig(this);
        refreshConfigs();
    }

    public Configs getAppConfigs() {
        return configs;
    }


    @Override
    public void onDataReceived(JSONObject jsonObject) {
        DBManager dbManager = new DBManager(this);
        Configs appConfigs = JsonUtil.get(jsonObject, Configs.class);
        dbManager.save(appConfigs);
        this.configs = appConfigs;

    }

    private void refreshConfigs() {
        DBManager dbManager = new DBManager(this);
        Cursor cursor = dbManager.query(Configs.class.getSimpleName().toLowerCase());
        cursor.moveToNext();
        dbManager.get(cursor, configs);
        cursor.close();
    }
}
