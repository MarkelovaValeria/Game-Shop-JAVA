package com.example.games_service.businessLogicalLayer.services;

import com.example.games_service.businessLogicalLayer.dto.request.GameRequest;
import com.example.games_service.dataAccessLayer.repositories.GamesRepository;
import com.example.games_service.dataAccessLayer.entity.Games;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CatalogService {
    private final GamesRepository gamesRepository;

    public void placeGame(GameRequest gameRequest){
        var game = mapToGame(gameRequest);
        gamesRepository.save(game);
    }

    public boolean getGame(Long id){
        return gamesRepository.findById(id).isPresent();
        //або return gameRepository.existsById(Id);
    }

    private static Games mapToGame(GameRequest gameRequest){
        Games games = new Games();
        games.setTitle(gameRequest.title());
        games.setDescriptionGame(gameRequest.descriptionGame());
        games.setDeveloper(gameRequest.developer());
        games.setPublisher(gameRequest.publisher());
        games.setReleaseDate(gameRequest.releaseDate());
        games.setPrice(gameRequest.price());
        games.setRating(gameRequest.rating());
        games.setCategories(gameRequest.categories());
        return games;
    }
}
