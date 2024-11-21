package com.example.games_service.dataAccessLayer.repositories;

import com.example.games_service.dataAccessLayer.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
}
