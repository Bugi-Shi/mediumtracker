package com.bucksteg.mediumtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    @GetMapping("/Game")
    public String index() {
        return "GameController";
    }
}
