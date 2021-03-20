/* 设置评论数、好评数默认值为0 */
ALTER TABLE orangesoft.commodity
    MODIFY COLUMN comment_count int(11) DEFAULT 0 NULL;
ALTER TABLE orangesoft.commodity
    MODIFY COLUMN praise_comment_count int(11) DEFAULT 0 NULL;
ALTER TABLE orangesoft.shop
    MODIFY COLUMN comment_count bigint(20) DEFAULT 0 NULL;
ALTER TABLE orangesoft.shop
    MODIFY COLUMN praise_count bigint(20) DEFAULT 0 NULL;

/** 为站内信添加是否已读字段 **/
ALTER TABLE orangesoft.chat
    ADD is_read TINYINT DEFAULT 0 NULL;
/** 添加店铺头像 **/
ALTER TABLE orangesoft.shop
    ADD shop_icon varchar(200) NULL;
