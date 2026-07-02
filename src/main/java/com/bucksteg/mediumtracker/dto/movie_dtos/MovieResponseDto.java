package com.bucksteg.mediumtracker.dto.movie_dtos;

import com.bucksteg.mediumtracker.enums.MediumStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieResponseDto {

    //Medium
    private Long id;
    private String title;
    private int releaseYear;
    private int rating;
    private MediumStatus status;
    private Integer finishedYear;

    //Movie
    private int durationMinutes;
}
