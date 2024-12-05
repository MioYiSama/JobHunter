CREATE TABLE IF NOT EXISTS user_info
(
    id                  BIGINT UNSIGNED UNIQUE                NOT NULL,
    user_id             BIGINT UNSIGNED UNIQUE                NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,

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
    FOREIGN KEY (employer_id) REFERENCES user (id) ON DELETE CASCADE,

    company     VARCHAR(64)            NULL DEFAULT NULL COMMENT '公司名称',

    KEY idx_employer_id (employer_id)
) COMMENT '雇主信息表';