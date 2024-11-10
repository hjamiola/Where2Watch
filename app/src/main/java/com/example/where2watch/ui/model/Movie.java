package com.example.where2watch.ui.model;

public class Movie {
    private String title;
    private String genre;
    private String[] platform;
    private String[] price;
    private float rating;
    private int imageResId;

    public Movie(String title, String genre, String[] platform, String[] price, float rating, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }

    public String[] getPlatform() {
        return platform;
    }

    public String[] getPrice() { return price; }

    public float getRating() { return rating; }
    public int getImageResId() { return imageResId; }
}
