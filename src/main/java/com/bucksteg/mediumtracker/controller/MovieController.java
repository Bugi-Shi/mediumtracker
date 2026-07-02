package com.bucksteg.mediumtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    
    @GetMapping("/Movie")
    public String index() {
        return "MovieController";
    }
}
