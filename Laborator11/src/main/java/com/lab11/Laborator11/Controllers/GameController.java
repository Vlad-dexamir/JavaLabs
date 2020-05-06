package com.lab11.Laborator11.Controllers;

import com.lab11.Laborator11.Models.Game;
import com.lab11.Laborator11.Services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class GameController {

    @Autowired
    private GameServices service;

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getGames() {
        List<Game> games = service.getAllGames();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<List<Game>>(games, headers, HttpStatus.OK);
    }

    @RequestMapping(path = "/game/create", method = RequestMethod.POST)
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game newGame = service.createGame(game.getContent(), game.getDate());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Game>(newGame, headers, HttpStatus.OK);
    }

    @RequestMapping(path = "/game/id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getPlayerById(@RequestParam Integer id) {

        Optional<Game> game = service.getGameById(id);
        HttpHeaders headers = new HttpHeaders();

        if (game == null) {
            return new ResponseEntity<Error>(new Error("Game does not exist"), headers, HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<Optional<Game>>(game, headers, HttpStatus.OK);
    }
}




