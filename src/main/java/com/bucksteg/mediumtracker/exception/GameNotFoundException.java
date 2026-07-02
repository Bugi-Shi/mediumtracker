package com.bucksteg.mediumtracker.exception;

public class GameNotFoundException extends MediumException {
    
    public GameNotFoundException(Long id) {
        super("Game ID " + id + " not found");
    }
}
