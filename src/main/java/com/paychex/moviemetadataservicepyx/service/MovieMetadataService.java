package com.paychex.moviemetadataservicepyx.service;

import java.util.List;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;

public interface MovieMetadataService {
    List<MovieMetadata> getByMovieTitle(String title);
    List<MovieMetadata> getByYear(int year);
    List<MovieMetadata> getByDecade(int year);
    List<MovieMetadata> getByCast(String cast);
    List<MovieMetadata> create(MovieMetadata movie);
}
