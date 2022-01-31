package com.paychex.moviemetadataservicepyx.service;

import com.paychex.moviemetadataservicepyx.data.MovieMetadata;

public interface MovieMetadataService {
    MovieMetadata getByMovieTitle(String title);
    MovieMetadata getByYear(int year);
    MovieMetadata getByDecade(int year);
    MovieMetadata getByCast(String cast);
}
