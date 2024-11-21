package com.example.games_service.dataAccessLayer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="t_games")
@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor

public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descriptionGame;
    private String developer;
    private String publisher;
    private LocalDate releaseDate;
    private BigDecimal price;
    private Integer rating;
    @ManyToMany
    @JoinTable(
            name = "t_categoryGame",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}
