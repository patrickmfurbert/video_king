package com.paychex.moviemetadataservicepyx.service.impl;

import java.util.List;

import com.paychex.moviemetadataservicepyx.dao.MovieMetadataRepository;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* Business Layer Implementation of the MovieMetadata Service
*/

@Service
public class MovieMetadataServiceImpl implements MovieMetadataService{

    @Autowired
    private MovieMetadataRepository movieMetadataRepository;

    @Override
    public MovieMetadata getByMovieTitle(String title) {
        // Call to Datalayer
        MovieMetadata movies = movieMetadataRepository.findMovieMetadataByTitle(title);

        if(movies == null){
            throw new RuntimeException("Invalid movie: " + title);
        }

        return movies;
    }

    @Override
    public List<MovieMetadata> getByYear(int year) {
        //Call to Datalayer
        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByYear(year);

        if(movies == null){
            throw new RuntimeException("Invalid year: " + year);
        }

        return movies;
    }

    @Override
    public MovieMetadata getByDecade(int year) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MovieMetadata getByCast(String cast) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
