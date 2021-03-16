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

/** 修改评论的指向 **/
ALTER TABLE orangesoft.commodity_order DROP FOREIGN KEY FK_本次订单评价;
ALTER TABLE orangesoft.commodity_order DROP INDEX FK_本次订单评价;
ALTER TABLE orangesoft.commodity_order DROP COLUMN comment_id;

ALTER TABLE orangesoft.user_comment ADD cid BIGINT NULL;
ALTER TABLE orangesoft.user_comment ADD CONSTRAINT user_comment_FK FOREIGN KEY (cid) REFERENCES orangesoft.commodity(cid) ON DELETE CASCADE;

ALTER TABLE orangesoft.sub_comments MODIFY COLUMN comment_id BIGINT NULL;
ALTER TABLE orangesoft.sub_comments ADD CONSTRAINT sub_comments_FK FOREIGN KEY (comment_id) REFERENCES orangesoft.user_comment(comment_id) ON DELETE CASCADE;

/** 增加店铺评价记录 **/
ALTER TABLE orangesoft.shop ADD comment_count BIGINT NULL;
ALTER TABLE orangesoft.shop ADD praise_count BIGINT NULL;
/** 为商品子种类增加逻辑删除字段 **/
ALTER TABLE orangesoft.sub_commodity ADD sub_commodity_status TINYINT DEFAULT 1 NULL;
/** 商品上架状态默认为1 **/
ALTER TABLE orangesoft.commodity MODIFY COLUMN commodity_status tinyint(1) DEFAULT 1 NULL;

/** 修改所有数据库中时间类型为timestamp **/
ALTER TABLE orangesoft.sub_comments MODIFY COLUMN sub_comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;
ALTER TABLE orangesoft.order_stateflow MODIFY COLUMN status_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;
ALTER TABLE orangesoft.footprint MODIFY COLUMN last_browser_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;
ALTER TABLE orangesoft.data_dictionary MODIFY COLUMN record_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;
ALTER TABLE orangesoft.chat MODIFY COLUMN chat_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;
