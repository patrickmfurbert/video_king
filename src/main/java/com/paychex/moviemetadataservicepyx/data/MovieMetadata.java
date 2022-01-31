package com.paychex.moviemetadataservicepyx.data;

import java.util.List;

public class MovieMetadata {
    
    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;

    public MovieMetadata() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getCast() {
        return this.cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    
}
