CREATE TABLE `t_userRole`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL,
    `role_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `t_users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`role_id`) REFERENCES `t_role`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);