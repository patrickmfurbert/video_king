package com.paychex.moviemetadataservicepyx.controller;

import java.util.List;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieMetadataController {

    // TODO setup validation on parameters

    @Autowired
    private MovieMetadataService movieMetadataService;
    
    @GetMapping(value = "/moviemetadata", params = "title")
    @ResponseBody
    public List<MovieMetadata> getMoviesByTitle(@RequestParam String title){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByMovieTitle(title);
        return movieMetadata; 
    }

    @GetMapping(value = "/moviemetadata", params = "year")
    @ResponseBody
    public List<MovieMetadata> getMoviesByYear(@RequestParam int year){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByYear(year);
        return movieMetadata;
    }

}
