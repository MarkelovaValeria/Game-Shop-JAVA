package com.example.games_service.catalog;

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

    public boolean GetGame(Long Id){
        var isGame = gamesRepository.findById(Id);
        return isGame.isPresent();
    }

    private static  Games mapToGame(GameRequest gameRequest){
        Games games = new Games();
        games.setTitle(gameRequest.title());
        games.setDescription_game(gameRequest.description_game());
        games.setDeveloper(gameRequest.developer());
        games.setPublisher(gameRequest.publisher());
        games.setRelease_date(gameRequest.release_date());
        games.setPrice(gameRequest.price());
        games.setRating(gameRequest.rating());
        games.setCategories(gameRequest.categories());
        return games;
    }
}
