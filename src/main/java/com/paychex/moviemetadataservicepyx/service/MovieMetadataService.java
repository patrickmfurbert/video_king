package com.paychex.moviemetadataservicepyx.service;

import java.util.List;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;

public interface MovieMetadataService {
    MovieMetadata getByMovieTitle(String title);
    List<MovieMetadata> getByYear(int year);
    MovieMetadata getByDecade(int year);
    MovieMetadata getByCast(String cast);
}
