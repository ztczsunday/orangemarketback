/**修改user_info表中字段顺序**/
ALTER TABLE orangesoft.user_info
    CHANGE user_telephone user_telephone varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL AFTER uid;
ALTER TABLE orangesoft.user_info
    CHANGE user_name user_name varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL AFTER user_password;
ALTER TABLE orangesoft.user_info
    CHANGE user_gender user_gender varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL AFTER user_name;
