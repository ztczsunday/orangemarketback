/** 修改评论表，新建子评论表，并在商品表中增加评论数记录 **/
ALTER TABLE orangesoft.user_comment DROP COLUMN sub_comment;
ALTER TABLE orangesoft.user_comment ADD comment_details varchar(200) NULL;

CREATE TABLE orangesoft.sub_comments (
                                         sub_comment_id BIGINT NULL,
                                         sub_comment_details varchar(200) NULL,
                                         sub_comment_time DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
                                         is_deleted TINYINT DEFAULT 0 NULL,
                                         comment_id varchar(200) NULL,
                                         CONSTRAINT sub_comments_pk PRIMARY KEY (sub_comment_id)
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_general_ci;

ALTER TABLE orangesoft.commodity ADD comment_count INT NULL;
ALTER TABLE orangesoft.commodity ADD praise_comment_count INT NULL;

ALTER TABLE orangesoft.sub_comments MODIFY COLUMN sub_comment_id bigint(20) auto_increment NOT NULL;
