package com.sumauto.diary.data.entity;

/**
 * Created by Lincoln on 2015/11/20.
 * diary
 */
public class Diary {
    /**
     * 日记标题
     */
    private String title;

    /**
     * 日记的内容
     */
    private String content;

    /**
     * 日记的日期
     */
    private String date;

    /**
     * 日记的图片
     */
    private String images;

    /**
     * 天气
     */
    private String weather;

    /**
     * 心情
     */
    private String mood;

    /**
     * 密码
     */
    private String secret;

    /**
     * 密码提示
     */
    private String secret_tips;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret_tips() {
        return secret_tips;
    }

    public void setSecret_tips(String secret_tips) {
        this.secret_tips = secret_tips;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", images='" + images + '\'' +
                ", weather='" + weather + '\'' +
                ", mood='" + mood + '\'' +
                ", secret='" + secret + '\'' +
                ", secret_tips='" + secret_tips + '\'' +
                '}';
    }
}
