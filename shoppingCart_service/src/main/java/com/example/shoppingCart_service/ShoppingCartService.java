package com.example.shoppingCart_service;


import com.example.shoppingCart_service.entity.ShoppingCart;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final GamesClient gamesClient;

    public void placeOrder(ShoppingCartRequest shoppingCartRequest){
        boolean isGame = gamesClient.isGame(shoppingCartRequest.gameId());
        if(isGame) {
            var item = mapToItem(shoppingCartRequest);
            shoppingCartRepository.save(item);
        }
        else{
            throw new NoSuchElementException("Game is not found");
        }
    }

    private static ShoppingCart mapToItem(ShoppingCartRequest shoppingCartRequest){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(shoppingCartRequest.usersId());
        shoppingCart.setGameId(shoppingCartRequest.gameId());
        return shoppingCart;
    }
}
