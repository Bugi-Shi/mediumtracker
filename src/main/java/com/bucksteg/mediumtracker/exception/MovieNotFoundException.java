package com.bucksteg.mediumtracker.exception;

public class MovieNotFoundException extends MediumException {
    
    public MovieNotFoundException(Long id) {
        super("Movie ID " + id + " not found");
    }
}
