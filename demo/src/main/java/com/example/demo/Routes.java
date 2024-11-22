package com.example.demo;


import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration(proxyBeanMethods = false)
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> catalogServiceRoute() {
        return route("games_service")
                .route(RequestPredicates.path("/api/catalog"), http(
                        "http://games-service:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> catalogServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("games_service_swagger")
                .route(RequestPredicates.path("/aggregate/games_service/v3/api-docs"), http(System.getenv("CATALOG_URL")))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> shoppingCartServiceRoute() {
        return route("shoppingCart_service")
                .route(RequestPredicates.path("/api/shoppingCart"), http(
                        "http://shoppingcart-service:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> shoppingCartServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("shoppingcart-service_swagger")
                .route(RequestPredicates.path("/aggregate/shoppingCart_service/v3/api-docs"), http(System.getenv("SHOPPINGCART_URL")))
                .filter(setPath("/api-docs"))
                .build();
    }



}
