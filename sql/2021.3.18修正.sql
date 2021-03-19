/** 添加主键自增 **/
ALTER TABLE orangesoft.commodity_pictures
    MODIFY COLUMN pid bigint(20) auto_increment NOT NULL;
