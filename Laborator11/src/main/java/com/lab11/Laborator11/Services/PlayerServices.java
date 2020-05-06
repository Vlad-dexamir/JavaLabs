package com.lab11.Laborator11.Services;


import com.lab11.Laborator11.Models.Player;
import com.lab11.Laborator11.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServices {

    @Autowired
    private PlayerRepository repository;

    public List<Player> getAllPlayers() {
        List<Player> players = repository.findAll();

        return players.size() > 0 ? players : new ArrayList<>();
    }

    public Player createPlayer(String name, Integer age) {
        Player player = new Player();
        player.setName(name);
        player.setAge(age);

        player = repository.save(player);

        return player;
    }

    public Player updatePlayer(Integer id, String name) {

        Optional<Player> existingPlayer = repository.findById(id);

        if (existingPlayer.isPresent()) {

            Player player = existingPlayer.get();
            player.setName(name.toString());
            player = repository.save(player);
            return player;
        }

        return null;
    }

    public String deletePlayer(Integer id) {
        Optional<Player> existingPlayer = repository.findById(id);

        if (!existingPlayer.isPresent()) {
            return "Player does not exist";
        }

        repository.deleteById(id);
        return "Player deleted successfully";
    }

    public Optional<Player> getPlayerById(Integer id) {
        Optional<Player> player = repository.findById(id);


        if(!player.isPresent()) {
            return null;
        }

        return player;
    }

}