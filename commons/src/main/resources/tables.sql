USE job_hunter;

CREATE TABLE IF NOT EXISTS user
(
    id       BIGINT UNSIGNED                    NOT NULL,
    PRIMARY KEY (id),

    name     VARCHAR(32)                        NOT NULL COMMENT '用户名',
    account  VARCHAR(32) UNIQUE                 NOT NULL COMMENT '账号',
    password VARCHAR(64)                        NOT NULL COMMENT '密码',

    role     ENUM ('USER', 'ADMIN', 'EMPLOYER') NOT NULL COMMENT '身份',

    KEY idx_account (account)
) COMMENT '用户表';

CREATE TABLE IF NOT EXISTS position
(
    id             BIGINT UNSIGNED NOT NULL,
    employer_id    BIGINT UNSIGNED NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (employer_id) REFERENCES user (id) ON DELETE CASCADE,

    title          VARCHAR(32) COMMENT '职位名称',
    detail_company VARCHAR(64) COMMENT '公司名称',
    min_salary     INT UNSIGNED COMMENT '最低薪资',
    max_salary     INT UNSIGNED COMMENT '最高薪资',
    education      enum ('专科', '本科', '硕士', '博士') COMMENT '学历要求',
    description    TEXT COMMENT '职位描述',
    hiring_manager VARCHAR(32) COMMENT '招聘负责人',
    last_active    DATETIME COMMENT '最后活跃时间',
    address        VARCHAR(128) COMMENT '工作地点',
    link           VARCHAR(128) COMMENT '职位链接',

    KEY idx_employer_id (employer_id)
) COMMENT '职位表';

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

CREATE TABLE IF NOT EXISTS user_info
(
    id                  BIGINT UNSIGNED UNIQUE                NOT NULL,
    user_id             BIGINT UNSIGNED UNIQUE                NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),

    birth_year          SMALLINT UNSIGNED                     NULL DEFAULT NULL COMMENT '出生年份',
    min_expected_salary INT UNSIGNED                          NULL DEFAULT NULL COMMENT '最低期望工资',
    max_expected_salary INT UNSIGNED                          NULL DEFAULT NULL COMMENT '最高期望工资',
    education           ENUM ('专科', '本科', '硕士', '博士') NULL DEFAULT NULL COMMENT '最高学历',
    school              VARCHAR(64)                           NULL DEFAULT NULL COMMENT '学校',
    major               VARCHAR(32)                           NULL DEFAULT NULL COMMENT '专业',

    KEY idx_user_id (user_id),

    CONSTRAINT chk_birth_year CHECK ( birth_year BETWEEN 1900 AND 2100 ),
    CONSTRAINT chk_salary CHECK (0 < min_expected_salary AND min_expected_salary <= max_expected_salary )
) COMMENT '用户信息表';

CREATE TABLE IF NOT EXISTS employer_info
(
    id          BIGINT UNSIGNED UNIQUE NOT NULL,
    employer_id BIGINT UNSIGNED UNIQUE NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (employer_id) REFERENCES user (id),

    company     VARCHAR(64)            NULL DEFAULT NULL COMMENT '公司名称',

    KEY idx_employer_id (employer_id)
) COMMENT '雇主信息表';