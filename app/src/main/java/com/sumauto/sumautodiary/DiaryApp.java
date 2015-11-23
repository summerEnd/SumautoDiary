package com.sumauto.sumautodiary;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sumauto.sumautodiary.config.AppConfigs;
import com.sumauto.sumautodiary.db.DBManager;
import com.sumauto.sumautodiary.entity.Configs;
import com.sumauto.support.*;
import com.sumauto.support.utils.JsonUtil;
import com.sumauto.support.utils.SLog;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.onlineconfig.OnlineConfigAgent;
import com.umeng.onlineconfig.UmengOnlineConfigureListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lincoln on 2015/11/19.
 * app
 */
public class DiaryApp extends Application implements UmengOnlineConfigureListener {
    private static DiaryApp INSTANCE;
    private AppConfigs configs = new AppConfigs();

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

    public AppConfigs getAppConfigs() {
        return configs;
    }


    @Override
    public void onDataReceived(JSONObject jsonObject) {
        DBManager dbManager = new DBManager(this);
        AppConfigs appConfigs = JsonUtil.get(jsonObject, AppConfigs.class);
        dbManager.insert(appConfigs);
        this.configs = appConfigs;

    }

    private void refreshConfigs() {
        DBManager dbManager = new DBManager(this);
        Cursor cursor = dbManager.queryAll(Configs.class.getSimpleName().toLowerCase());
        cursor.moveToNext();
        dbManager.getObject(cursor, configs);
        cursor.close();
    }
}
