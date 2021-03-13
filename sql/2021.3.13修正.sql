/** 添加新表 **/
CREATE TABLE orangesoft.commodity_pictures
(
    pictures varchar(200) NULL,
    pid      BIGINT       NULL,
    cid      BIGINT       NULL,
    CONSTRAINT commodity_pictures_pk PRIMARY KEY (pid),
    CONSTRAINT commodity_pictures_FK FOREIGN KEY (cid) REFERENCES orangesoft.commodity (cid) ON DELETE CASCADE
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;
ALTER TABLE orangesoft.commodity
    DROP COLUMN commodity_icon;
ALTER TABLE orangesoft.commodity_pictures
    CHANGE pictures picture_url varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;
/** 增加主键 **/
ALTER TABLE orangesoft.footprint
    ADD CONSTRAINT footprint_pk PRIMARY KEY (uid, cid);
ALTER TABLE orangesoft.order_stateflow
    ADD CONSTRAINT order_stateflow_pk PRIMARY KEY (order_id, record_id);
