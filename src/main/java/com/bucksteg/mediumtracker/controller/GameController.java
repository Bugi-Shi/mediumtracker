package com.bucksteg.mediumtracker.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bucksteg.mediumtracker.dto.game_dtos.GameCreateDto;
import com.bucksteg.mediumtracker.dto.game_dtos.GameResponseDto;
import com.bucksteg.mediumtracker.dto.game_dtos.GameUpdateDto;
import com.bucksteg.mediumtracker.entity.Game;
import com.bucksteg.mediumtracker.service.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping()
    public Iterable<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PostMapping
    public GameResponseDto createGame(@RequestBody GameCreateDto gameDto) {
        return gameService.createGame(gameDto);
    }

    @PutMapping("/{id}")
    public GameResponseDto updateGame(@PathVariable Long id, @RequestBody GameUpdateDto gameUpdateDto) {        
        return gameService.updateGame(id, gameUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
