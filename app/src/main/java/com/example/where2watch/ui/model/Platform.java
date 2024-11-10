package com.example.where2watch.ui.model;

public class Platform {

    private String platform;
    private String price;
    private String url;
    private int imageResId;

    public Platform(String platform, String price, String url, int imageResId) {
        this.platform = platform;
        this.price = price;
        this.url = url;
        this.imageResId = imageResId;
    }

    public String getPlatform() {
        return platform;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }
}
