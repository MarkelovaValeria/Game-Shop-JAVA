package com.example.games_service.businessLogicalLayer.controllers;

import com.example.games_service.businessLogicalLayer.dto.request.GameRequest;
import com.example.games_service.businessLogicalLayer.services.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor

public class CatalogController {
    private final CatalogService catalogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeGame(@RequestBody GameRequest gameRequest){
        catalogService.placeGame(gameRequest);
        return "Game Placed Successfully";
    }

    @GetMapping
    public boolean isGame(@RequestParam Long id){
        return catalogService.getGame(id);
    }
}
