package com.lab11.Laborator11.Repository;

import com.lab11.Laborator11.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
