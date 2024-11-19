CREATE TABLE `t_games`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(50) NOT NULL,
    `description_game` varchar(500),
    `developer` varchar(50) NOT NULL,
    `publisher` varchar(50) NOT NULL,
    `release_date` date,
    `price` decimal(10,2) NOT NULL,
    `rating` int(1),
    PRIMARY KEY (`id`)
);