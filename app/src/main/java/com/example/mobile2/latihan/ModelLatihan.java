package com.example.mobile2.latihan;

public class ModelLatihan {
    private String title;
    private String subtitle;
    private Class<?> activityClass;

    public ModelLatihan(String title, String subtitle, Class<?> activityClass) {
        this.title = title;
        this.subtitle = subtitle;
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
