CREATE TABLE IF NOT EXISTS favorite
(
    id          BIGINT UNSIGNED NOT NULL,
    user_id     BIGINT UNSIGNED NOT NULL,
    position_id BIGINT UNSIGNED NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES position (id) ON DELETE CASCADE,

    KEY `idx_user_id` (`user_id`),
    KEY `idx_position_id` (`position_id`)
) COMMENT '用户收藏表';