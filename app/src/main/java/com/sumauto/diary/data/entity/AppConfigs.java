package com.sumauto.diary.data.entity;

/**
 * Created by Lincoln on 2015/11/23.
 * app的一些基本参数
 */
public class AppConfigs {

    /**
     * new_feature : update sod daf
     * show_notice : 0
     * force_update : 1
     * apk_url : http://www.baidu.com
     * notice : _notice_
     * latest_version : 2
     */

    private String new_feature;
    private String show_notice;
    private String force_update;
    private String apk_url;
    private String notice;
    private String latest_version;

    public String getNew_feature() {
        return new_feature;
    }

    public String getShow_notice() {
        return show_notice;
    }

    public String getForce_update() {
        return force_update;
    }

    public String getApk_url() {
        return apk_url;
    }

    public String getNotice() {
        return notice;
    }

    public String getLatest_version() {
        return latest_version;
    }

    @Override
    public String toString() {
        return "AppConfigs{" +
                "new_feature='" + new_feature + '\'' +
                ", show_notice='" + show_notice + '\'' +
                ", force_update='" + force_update + '\'' +
                ", apk_url='" + apk_url + '\'' +
                ", notice='" + notice + '\'' +
                ", latest_version='" + latest_version + '\'' +
                '}';
    }
}
