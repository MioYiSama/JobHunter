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