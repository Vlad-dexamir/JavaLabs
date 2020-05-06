package com.lab11.Laborator11.Controllers;

import com.lab11.Laborator11.Models.Player;
import com.lab11.Laborator11.Services.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlayerController {

    @Autowired
    private PlayerServices service;

    @RequestMapping(path = "/players", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = service.getAllPlayers();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<List<Player>>(players, headers, HttpStatus.OK);
    }

    @RequestMapping(path = "/player/create", method = RequestMethod.POST)
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player newPlayer = service.createPlayer(player.getName(), player.getAge());

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Player>(newPlayer, headers, HttpStatus.OK);
    }

    @RequestMapping(path = "player/id", method = RequestMethod.PUT)
    public ResponseEntity<? extends Object> updatePlayer(@RequestParam("id") Integer id, @RequestBody String name) {
        Player player = service.updatePlayer(id, name);
        HttpHeaders headers = new HttpHeaders();

        if (player == null) {
            return new ResponseEntity<Error>(new Error("Player does not exist"), headers, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Player>(player, headers, HttpStatus.OK);

    }

    @RequestMapping(path = "player/id", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlayer(@RequestParam Integer id) {
        String result = service.deletePlayer(id);
        HttpHeaders headers = new HttpHeaders();

        if (result.equals("Player does not exist")) {
            return new ResponseEntity<String>("Player does not exist", headers, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("Player deleted successfully", headers, HttpStatus.OK);

    }

    @RequestMapping(path = "player/id", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getPlayerById(@RequestParam Integer id) {

        Optional<Player> player = service.getPlayerById(id);
        HttpHeaders headers = new HttpHeaders();

        if (player == null) {
            return new ResponseEntity<Error>(new Error("Player does not exist"), headers, HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<Optional<Player>>(player, headers, HttpStatus.OK);
    }
}
