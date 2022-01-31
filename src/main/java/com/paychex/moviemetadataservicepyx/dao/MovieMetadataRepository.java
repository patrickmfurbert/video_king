package com.paychex.moviemetadataservicepyx.dao;

import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMetadataRepository extends MongoRepository<MovieMetadata, String> {
    MovieMetadata findMovieMetadataByTitle(String title);
}
