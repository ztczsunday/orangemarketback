/** 修正字段名 **/
RENAME TABLE orangesoft.commmodity_details TO orangesoft.commodity_details;
/** 添加评论时间字段，自动填入当前时间戳 **/
ALTER TABLE orangesoft.user_comment ADD comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL;