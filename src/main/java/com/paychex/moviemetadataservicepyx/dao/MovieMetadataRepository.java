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

    // Queries the collection to match on the cast with 
    //the subarray that contains the specified cast member
    @Query(value = "{'cast': {$all:['?0']}}")
    List<MovieMetadata> findMovieMetadataByCast(String cast);

    // Queries the collection to match on a years
    // between specified values
    @Query(value = "{year: {$gte: ?0, $lt: ?1}}")
    List<MovieMetadata> findMovieMetadataByDecade(int start, int end);
}
