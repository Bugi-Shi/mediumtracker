package com.bucksteg.mediumtracker.service;

import org.springframework.stereotype.Service;

import com.bucksteg.mediumtracker.entity.Game;
import com.bucksteg.mediumtracker.exception.GameNotFoundException;
import com.bucksteg.mediumtracker.repository.GameRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j      //Logger for info
@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) { //Dependency Injection
        this.gameRepository = gameRepository;
    }

    public Game getGame(Long id) {
        return gameRepository
        .findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));
    }

    public void printGame(Long id) {
        Game game = getGame(id);

        log.info("Found game: {}", game.getTitle());            //Logger setzt den Wert in {} ein, wenn dieser existiert
    }
}
