package com.paychex.moviemetadataservicepyx.controller;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.paychex.moviemetadataservicepyx.data.MovieMetadata;
import com.paychex.moviemetadataservicepyx.service.MovieMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MovieMetadataController {

    // Get Mapping
    @Autowired
    private MovieMetadataService movieMetadataService;
    
    @GetMapping(value = "/moviemetadata", params = "title")
    @ResponseBody
    public List<MovieMetadata> getMoviesByTitle(@RequestParam @NotBlank(message="Need to add a movie title") String title){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByMovieTitle(title);
        return movieMetadata; 
    }

    @GetMapping(value = "/moviemetadata", params = "year")
    @ResponseBody
    public List<MovieMetadata> getMoviesByYear(@RequestParam @Min(value = 0, message="Must be greater than 0") int year){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByYear(year);
        return movieMetadata;
    }

    @GetMapping(value = "/moviemetadata", params = "decade")
    @ResponseBody
    public List<MovieMetadata> getMoviesByDecade(@RequestParam @Min(value = 0, message="Must be greater than 0") int decade){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByDecade(decade);
        return movieMetadata;
    }

    @GetMapping(value = "/moviemetadata", params ="cast_member")
    @ResponseBody
    public List<MovieMetadata> getMoviesByYear(@RequestParam @NotBlank(message="Need to add a cast member") String cast_member){
        List<MovieMetadata> movieMetadata = movieMetadataService.getByCast(cast_member);
        return movieMetadata;
    }

    // Post Mapping
    
}