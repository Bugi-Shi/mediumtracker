package com.bucksteg.mediumtracker.entity;

import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.MediumType;
import com.bucksteg.mediumtracker.enums.Platform;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Game extends Medium {
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private Double playTime;            //Double kann null sein

    public Game(
        String title,
        int year,
        int rating,
        MediumStatus status,
        Platform platform, 
        Double playTime) {
            super(title, year, rating, status);
            this.platform = platform;
            this.playTime = playTime;
    }

    @Override
    public MediumType getType() {
        return MediumType.GAME;
    }
}
