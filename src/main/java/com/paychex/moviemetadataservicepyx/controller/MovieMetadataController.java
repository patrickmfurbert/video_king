package com.paychex.moviemetadataservicepyx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieMetadataController {
    
    @GetMapping("/hello")
    public String getHello(){
        return "Hi there";
    }
}
