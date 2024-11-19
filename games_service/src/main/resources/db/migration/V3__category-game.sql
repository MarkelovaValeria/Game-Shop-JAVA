CREATE TABLE `t_categoryGame`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `category_id` bigint(20) NOT NULL,
    `game_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`category_id`) REFERENCES `t_category`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`game_id`) REFERENCES `t_games`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);