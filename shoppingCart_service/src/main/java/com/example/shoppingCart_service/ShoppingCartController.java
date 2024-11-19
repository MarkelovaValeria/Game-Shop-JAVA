package com.example.shoppingCart_service;

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
