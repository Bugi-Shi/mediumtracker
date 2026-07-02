package com.bucksteg.mediumtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bucksteg.mediumtracker.entity.Movie;
import java.util.List;
import com.bucksteg.mediumtracker.enums.MediumStatus;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByStatus(MediumStatus status);
}
