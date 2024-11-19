package com.example.shoppingCart_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_userRole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
}
