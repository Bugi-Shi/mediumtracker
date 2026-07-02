package com.bucksteg.mediumtracker.dto.game_dtos;

import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.Platform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResponseDto {
    
    //Medium
    private Long id;
    private String title;
    private int releaseYear;
    private int rating;
    private MediumStatus status;
    private Integer finishedYear;

    //Game
    private Platform platform;
    private Double playTime;
}
