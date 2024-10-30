package com.example.where2watch.ui.model;

public class Movie {
    private String title;
    private String genre;
    private float rating;
    private int imageResId;

    public Movie(String title, String genre, float rating, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public float getRating() { return rating; }
    public int getImageResId() { return imageResId; }
}
