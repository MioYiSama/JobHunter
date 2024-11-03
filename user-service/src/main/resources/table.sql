CREATE TABLE IF NOT EXISTS user
(
    id       BIGINT UNSIGNED                    NOT NULL,
    PRIMARY KEY (id),

    name     VARCHAR(32)                        NOT NULL COMMENT '用户名',
    account  VARCHAR(32)                        NOT NULL COMMENT '账号',
    password VARCHAR(64)                        NOT NULL COMMENT '密码',

    role     ENUM ('USER', 'ADMIN', 'EMPLOYER') NOT NULL COMMENT '身份',

    KEY idx_account (account)
) COMMENT '用户表';