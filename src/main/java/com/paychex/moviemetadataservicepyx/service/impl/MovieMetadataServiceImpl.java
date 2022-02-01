package com.paychex.moviemetadataservicepyx.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.paychex.moviemetadataservicepyx.dao.MovieMetadataRepository;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import com.paychex.moviemetadataservicepyx.utils.ConvertToDecade;
import com.paychex.moviemetadataservicepyx.utils.ConvertToTitleCase;
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

        // Convert to TitleCase
        movies = ConvertToTitleCase.processMovies(movies);

        return movies;
    }

    @Override
    public List<MovieMetadata> getByYear(int year) {
        //Call to Datalayer
        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByYear(year);

        if(movies == null){
            throw new RuntimeException("Invalid year: " + year);
        }

        // Convert to TitleCase
        movies = ConvertToTitleCase.processMovies(movies);

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

        // Convert to TitleCase
        movies = ConvertToTitleCase.processMovies(movies);

        return movies;
    }

    @Override
    public List<MovieMetadata> getByCast(String cast) {
        List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByCast(cast);

        if(movies == null){
            throw new RuntimeException("Invalid cast: " + cast);
        }

        // Convert to TitleCase
        movies = ConvertToTitleCase.processMovies(movies);

        return movies;
    }

    @Override
    public List<MovieMetadata> create(MovieMetadata movie) {
        // Check if moviemetadata is already in the database
        if(movie.getTitle() != null || movie.getTitle().length() != 0){
            List<MovieMetadata> movies = movieMetadataRepository.findMovieMetadataByTitle(movie.getTitle());
            if(!movies.isEmpty() && movies.get(0).getTitle().compareTo(movie.getTitle()) == 0 && movies.get(0).getYear() == movie.getYear()){
                //duplicate entry found
                throw new RuntimeException("Error Movie already in database: " + movie.getTitle());
            }else{
                movieMetadataRepository.insert(movie);
                List<MovieMetadata> new_entry = new ArrayList<MovieMetadata>();
                new_entry.add(movie);
                return new_entry;
            }
        }
        return null;
    }
    
}
