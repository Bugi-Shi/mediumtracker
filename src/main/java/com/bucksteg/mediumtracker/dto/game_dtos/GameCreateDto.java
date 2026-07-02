package com.bucksteg.mediumtracker.dto.game_dtos;

import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.Platform;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateDto {

    //Medium
    private String title;
    private int releaseYear;
    private int rating;
    private MediumStatus status;
    private Integer finishedYear;

    //Game
    private Platform platform;
    private Double playTime;
}
