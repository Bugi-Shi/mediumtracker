package com.bucksteg.mediumtracker.exception;

public abstract class MediumException extends RuntimeException {
    
    protected MediumException(String message) {
        super(message);
    }
}