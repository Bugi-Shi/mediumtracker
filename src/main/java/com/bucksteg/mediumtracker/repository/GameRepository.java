package com.bucksteg.mediumtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bucksteg.mediumtracker.entity.Game;
import java.util.List;
import com.bucksteg.mediumtracker.enums.MediumStatus;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByStatus(MediumStatus status);
}
