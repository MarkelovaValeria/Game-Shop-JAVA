package com.example.shoppingCart_service.businessLogicalLayer.controllers;

import com.example.shoppingCart_service.businessLogicalLayer.dto.requests.ShoppingCartRequest;
import com.example.shoppingCart_service.businessLogicalLayer.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shoppingCart")
@RequiredArgsConstructor

public class ShoppingCartController {


    private final ShoppingCartService shoppingCartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody ShoppingCartRequest shoppingCartRequest){
        shoppingCartService.placeOrder(shoppingCartRequest);
        return "Order Placed Successfully";
    }
}
