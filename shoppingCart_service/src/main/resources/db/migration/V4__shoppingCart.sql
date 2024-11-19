CREATE TABLE `t_shoppingCart`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL,
    `game_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `t_users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);