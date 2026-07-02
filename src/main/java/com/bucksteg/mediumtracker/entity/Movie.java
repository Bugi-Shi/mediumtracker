package com.bucksteg.mediumtracker.entity;

import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.MediumType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie extends Medium {
    private int durationMinutes;

    public Movie(String title,
        int year,
        int rating,
        MediumStatus status,
        int durationMinutes) {
            super(title, year, rating, status);
            this.durationMinutes = durationMinutes;
    }

    @Override
    public MediumType getType() {
        return MediumType.MOVIE;
    }
}
