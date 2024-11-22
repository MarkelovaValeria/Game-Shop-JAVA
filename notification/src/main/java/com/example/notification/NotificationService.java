package com.example.notification;

import com.example.notification.event.CatalogPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {
    @KafkaListener(topics = "game-created")
    public void listen(CatalogPlacedEvent catalogPlacedEvent) {
        log.info("Got Message from game-created topic {}", catalogPlacedEvent);
    }
}