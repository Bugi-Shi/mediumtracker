package com.bucksteg.mediumtracker.entity;

import com.bucksteg.mediumtracker.enums.MediumStatus;
import com.bucksteg.mediumtracker.enums.MediumType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*
SINGLE_TABLE → Alle Objekte liegen in einer Tabelle.
JOINED → Gemeinsame Daten in der Oberklasse, spezielle Daten in eigenen Tabellen.
TABLE_PER_CLASS → Jede Unterklasse bekommt ihre eigene vollständige Tabelle.
*/
public abstract class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;
    private int rating;
    private MediumStatus status;

    protected Medium(String title, int year, int rating, MediumStatus status) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.status = status;
    }

    public abstract MediumType getType();
}
