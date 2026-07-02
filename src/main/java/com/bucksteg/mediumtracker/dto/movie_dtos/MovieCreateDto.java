package com.bucksteg.mediumtracker.dto.movie_dtos;

import com.bucksteg.mediumtracker.enums.MediumStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieCreateDto {
    
    //Medium
    private String title;
    private int releaseYear;
    private int rating;
    private MediumStatus status;
    private Integer finishedYear;

    //Movie
    private int durationMinutes;
}
