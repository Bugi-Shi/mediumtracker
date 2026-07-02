package com.bucksteg.mediumtracker.enums;

public enum MediumType { 
    GAME("Game"),
    MOVIE("Movie");   
    
    private final String type;
    
    MediumType(String mediumType) {
        this.type = mediumType;
    }

    public String getMediumType() {
        return type;
    }
}