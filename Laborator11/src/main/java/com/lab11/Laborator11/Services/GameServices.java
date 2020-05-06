package com.lab11.Laborator11.Services;


import com.lab11.Laborator11.Models.Game;
import com.lab11.Laborator11.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GameServices {

    @Autowired
    private GameRepository repository;

    public List<Game> getAllGames() {
        List<Game> games = repository.findAll();

        return games.size() > 0 ? games : new ArrayList<>();
    }

    public Game createGame(String content, Date date) {
        Game game = new Game();
        game.setContent(content);
        game.setDate(date);

        game = repository.save(game);

        return game;
    }

    public Optional<Game> getGameById(Integer id) {
        Optional<Game> game = repository.findById(id);

        if (!game.isPresent()) {
            return null;
        }

        return game;
    }
}
