/** 为收货地址表添加伪删除字段 **/
ALTER TABLE orangesoft.receive_address ADD is_deleted TINYINT DEFAULT 0 NULL;
