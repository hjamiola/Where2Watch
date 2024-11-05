package com.example.where2watch.ui.model;

public class Movie {
    private String title;
    private String genre;
    private String[] platform;
    private float rating;
    private int imageResId;

    public Movie(String title, String genre, String[] platform, float rating, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }

    public String[] getPlatform() {
        return platform;
    }

    public float getRating() { return rating; }
    public int getImageResId() { return imageResId; }
}
