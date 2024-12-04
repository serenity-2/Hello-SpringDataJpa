# CREATE TABLE `user`
# (
#     `id`      INT          NOT NULL AUTO_INCREMENT,
#     `user_id`      INT          NOT NULL COMMENT '用户ID',
#     `user_name`    VARCHAR(255) NOT NULL COMMENT '用户账号',
#     `nick_name`    VARCHAR(255) NOT NULL COMMENT '用户昵称',
#     `email`        VARCHAR(255) NOT NULL COMMENT '用户邮箱',
#     `phone_number` VARCHAR(255) NOT NULL COMMENT '手机号码',
#     `sex`          VARCHAR(255) NOT NULL COMMENT '用户性别（0男 1女 2未知）',
#     `status`       VARCHAR(255) NOT NULL DEFAULT '1' COMMENT '账号状态（1正常 0停用）',
#     `create_by`    VARCHAR(255) NOT NULL COMMENT '创建者',
#     `create_time`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `update_by`    VARCHAR(255) NOT NULL COMMENT '更新者',
#     `update_time`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`),
#     INDEX `idx_user_id` (`user_id`),
#     UNIQUE INDEX `idx_phone_number` (`phone_number`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4;
#
#
#
# INSERT INTO db2024.user (user_id, user_name, nick_name, email, phone_number, sex, status, create_by, create_time, update_by, update_time) VALUES (1, '大耳狗', 'CINNOAMOROLL', 'CINNOAMOROLL@example.com', '15000000000', '0', '1', 'admin', '2024-11-10 18:22:00', 'admin', '2024-11-10 19:10:11');
# INSERT INTO db2024.user (user_id, user_name, nick_name, email, phone_number, sex, status, create_by, create_time, update_by, update_time) VALUES (2, '美乐蒂', 'MY MELODY', 'MY MELODY_@example.com', '15100000000', '1', '1', 'admin', '2024-11-10 18:22:00', 'admin', '2024-11-10 19:10:11');
# INSERT INTO db2024.user (user_id, user_name, nick_name, email, phone_number, sex, status, create_by, create_time, update_by, update_time) VALUES (3, '帕恰狗', 'POCHACCO', 'POCHACCO@example.com', '15200000000', '2', '1', 'admin', '2024-11-10 18:22:00', 'admin', '2024-11-10 19:10:11');
# INSERT INTO db2024.user (user_id, user_name, nick_name, email, phone_number, sex, status, create_by, create_time, update_by, update_time) VALUES (4, '凯蒂猫', 'HelloKitty', 'HelloKitty@example.com', '15300000000', '0', '1', 'admin', '2024-11-10 18:22:00', 'admin', '2024-11-10 19:10:11');
# INSERT INTO db2024.user (user_id, user_name, nick_name, email, phone_number, sex, status, create_by, create_time, update_by, update_time) VALUES (5, '库洛米', 'KKUROMI', 'user5@example.com', '15400000000', '1', '1', 'admin', '2024-11-10 18:22:00', 'admin', '2024-11-10 19:10:11');
#
