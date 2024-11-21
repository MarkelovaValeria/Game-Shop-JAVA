package com.example.games_service.businessLogicalLayer.dto.request;

import com.example.games_service.dataAccessLayer.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record GameRequest(Long id, String title, String descriptionGame, String developer, String publisher, LocalDate releaseDate, BigDecimal price, Integer rating, Set<Category> categories) {
    public GameRequest{
        if(rating != null && (rating < 1 || rating > 5)){
            throw new IllegalArgumentException("Rating must be between 1 and 10");
        }
    }
}
