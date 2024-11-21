package com.example.shoppingCart_service.dataAccessLayer.repositories;

import com.example.shoppingCart_service.dataAccessLayer.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
