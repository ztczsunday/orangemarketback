/** 自己评论表中增加用户表uid外键 **/
ALTER TABLE orangesoft.sub_comments ADD uid INT NULL;
ALTER TABLE orangesoft.sub_comments ADD CONSTRAINT sub_comments_FK_1 FOREIGN KEY (uid) REFERENCES orangesoft.user_info(uid) ON DELETE SET NULL;
