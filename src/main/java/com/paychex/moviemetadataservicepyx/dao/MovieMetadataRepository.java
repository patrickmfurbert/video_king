package com.paychex.moviemetadataservicepyx.dao;

import java.util.List;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMetadataRepository extends MongoRepository<MovieMetadata, String> {
    List<MovieMetadata> findMovieMetadataByTitle(String title);
    List<MovieMetadata> findMovieMetadataByYear(int year);
}
