package com.paychex.moviemetadataservicepyx.dao;

import java.util.List;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMetadataRepository extends MongoRepository<MovieMetadata, String> {

    List<MovieMetadata> findMovieMetadataByTitle(String title);

    List<MovieMetadata> findMovieMetadataByYear(int year);

    @Query(value = "{'cast': {$all:['?0']}}")
    List<MovieMetadata> findMovieMetadataByCast(String cast);
    
    @Query(value = "{year: {$gte: ?0, $lt: ?1}}")
    List<MovieMetadata> findMovieMetadataByDecade(int start, int end);
}
