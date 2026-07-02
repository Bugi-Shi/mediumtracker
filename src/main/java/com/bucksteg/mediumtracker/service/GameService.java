package com.bucksteg.mediumtracker.service;

import org.springframework.stereotype.Service;

import com.bucksteg.mediumtracker.dto.game_dtos.GameCreateDto;
import com.bucksteg.mediumtracker.dto.game_dtos.GameResponseDto;
import com.bucksteg.mediumtracker.dto.game_dtos.GameUpdateDto;
import com.bucksteg.mediumtracker.entity.Game;
import com.bucksteg.mediumtracker.exception.GameNotFoundException;
import com.bucksteg.mediumtracker.repository.GameRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j      //Logger for info
@Service
public class GameService {

    private final GameRepository gameRepository;

    private GameResponseDto toResponseDto(Game game) {
        return new GameResponseDto(
            game.getId(),
            game.getTitle(),
            game.getReleaseYear(),
            game.getRating(),
            game.getStatus(),
            game.getFinishedYear(),
            game.getPlatform(),
            game.getPlayTime()
    );
}

    public GameService(GameRepository gameRepository) { //Dependency Injection
        this.gameRepository = gameRepository;
    }

    public Game getGame(Long id) {
        return gameRepository
        .findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));
    }

    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void printGame(Long id) {
        Game game = getGame(id);

        log.info("Found game: {}", game.getTitle());            //Logger setzt den Wert in {} ein, wenn dieser existiert
    }

    public GameResponseDto createGame(GameCreateDto gameDto) {
        Game game = new Game(
            gameDto.getTitle(),
            gameDto.getReleaseYear(),
            gameDto.getRating(),
            gameDto.getStatus(),
            gameDto.getFinishedYear(),
            gameDto.getPlatform(),
            gameDto.getPlayTime()
        );

        Game savedGame = gameRepository.save(game);
        return toResponseDto(savedGame);
    }

    public GameResponseDto updateGame(Long id, GameUpdateDto gameDto) {
        Game game = gameRepository.findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));

        game.setTitle(gameDto.getTitle());
        game.setReleaseYear(gameDto.getReleaseYear());
        game.setRating(gameDto.getRating());
        game.setStatus(gameDto.getStatus());
        game.setFinishedYear(gameDto.getFinishedYear());
        game.setPlatform(gameDto.getPlatform());
        game.setPlayTime(gameDto.getPlayTime());

        Game savedGame = gameRepository.save(game);

        return toResponseDto(savedGame);
    }

    public void deleteGame(Long id) {
        if(!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id);
    }
}
