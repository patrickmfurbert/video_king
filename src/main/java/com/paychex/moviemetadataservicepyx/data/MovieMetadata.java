package com.paychex.moviemetadataservicepyx.data;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class MovieMetadata {
    
    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;

    public MovieMetadata() {
    }

    public MovieMetadata(String title, int year, List<String> cast, List<String> genres) {
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
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
