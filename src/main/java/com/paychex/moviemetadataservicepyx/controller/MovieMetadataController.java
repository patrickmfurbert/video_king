package com.paychex.moviemetadataservicepyx.controller;

import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieMetadataController {

    @Autowired
    private MovieMetadataService movieMetadataService;
    
    @GetMapping("/moviemetadata")
    @ResponseBody
    public MovieMetadata getMoviesByTitle(@RequestParam String title){
        MovieMetadata movieMetadata = movieMetadataService.getByMovieTitle(title);
        return movieMetadata; 
    }
}
