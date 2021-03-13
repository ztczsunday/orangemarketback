/**  修正两个字段名  **/
ALTER TABLE orangesoft.user_comment
    CHANGE conntent content varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;
ALTER TABLE orangesoft.user_info
    CHANGE user_alipayAccount user_alipay_account varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;
/**  修正1个字段名  **/
ALTER TABLE orangesoft.user_info
    CHANGE uer_telephone user_telephone varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;
