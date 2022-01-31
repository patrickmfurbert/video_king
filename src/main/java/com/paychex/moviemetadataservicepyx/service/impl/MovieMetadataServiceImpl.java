package com.paychex.moviemetadataservicepyx.service.impl;

import java.util.List;

import com.paychex.moviemetadataservicepyx.dao.MovieMetadataRepository;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import com.paychex.moviemetadataservicepyx.utils.ConvertToDecade;

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
    public List<MovieMetadata> getByMovieTitle(String title) {
        // Call to Datalayer
        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByTitle(title);

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
    public List<MovieMetadata> getByDecade(int year) {
        // ConvertToDecade
        int decade = ConvertToDecade.LastDigitToZero(year);

        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByDecade(decade, decade+9);

        if(movies == null){
            throw new RuntimeException("Invalid decade: " + year);
        }

        return movies;
    }

    @Override
    public List<MovieMetadata> getByCast(String cast) {
        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByCast(cast);

        if(movies == null){
            throw new RuntimeException("Invalid cast: " + cast);
        }

        return movies;
    }
    
}
