CREATE TABLE `t_users`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    `surname` varchar(50) NOT NULL,
    `age` int(2) NOT NULL,
    `email` varchar(50) NOT NULL,
    `phone` varchar(50),
    PRIMARY KEY (`id`)
);