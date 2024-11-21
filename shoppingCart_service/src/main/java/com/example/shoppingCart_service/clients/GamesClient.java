package com.example.shoppingCart_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "games-service", url = "${game.url}")
public interface GamesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/catalog")
    boolean isGame(@RequestParam Long id);
}
