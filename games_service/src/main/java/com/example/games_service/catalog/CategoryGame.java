package com.example.games_service.catalog;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_categoryGame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="game_id", nullable = false)
    private Games games;
}
