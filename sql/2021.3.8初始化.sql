/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/3/8 14:06:32                            */
/*==============================================================*/


drop table if exists chat;

drop table if exists commodity;

drop table if exists commodity_add_label;

drop table if exists commodity_label;

drop table if exists commodity_order;

drop table if exists favorites;

drop table if exists footprint;

drop table if exists logistics;

drop table if exists manager;

drop table if exists order_logistics;

drop table if exists order_stateflow;

drop table if exists order_status;

drop table if exists receive_address;

drop table if exists shop;

drop table if exists shop_chat;

drop table if exists sub_commodity;

drop table if exists user_chat;

drop table if exists user_comment;

drop table if exists user_info;

/*==============================================================*/
/* Table: chat                                                  */
/*==============================================================*/
create table chat
(
    chat_id      bigint not null auto_increment,
    chat_content varchar(200),
    chat_date    datetime,
    chat_status  bool,
    primary key (chat_id)
);

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
    cid                   bigint not null auto_increment,
    sid                   int,
    commodity_ame         varchar(40),
    commodity_description varchar(200),
    commodity_status      bool,
    primary key (cid)
);

/*==============================================================*/
/* Table: commodity_add_label                                   */
/*==============================================================*/
create table commodity_add_label
(
    cid      bigint not null,
    label_id int    not null,
    primary key (cid, label_id)
);

/*==============================================================*/
/* Table: commodity_label                                       */
/*==============================================================*/
create table commodity_label
(
    label_id   int not null auto_increment,
    label_name varchar(20),
    primary key (label_id)
);

/*==============================================================*/
/* Table: commodity_order                                       */
/*==============================================================*/
create table commodity_order
(
    order_id   bigint not null auto_increment,
    comment_id bigint,
    sid        int,
    uid        int,
    sub_id     int,
    primary key (order_id)
);

/*==============================================================*/
/* Table: favorites                                             */
/*==============================================================*/
create table favorites
(
    uid int    not null,
    cid bigint not null,
    primary key (uid, cid)
);

/*==============================================================*/
/* Table: footprint                                             */
/*==============================================================*/
create table footprint
(
    cid               bigint not null,
    uid               int    not null,
    last_browser_date date,
    primary key (cid, uid)
);

/*==============================================================*/
/* Table: logistics                                             */
/*==============================================================*/
create table logistics
(
    logistics_id   int not null auto_increment,
    logistics_name varchar(20),
    primary key (logistics_id)
);

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager
(
    manager_account  varchar(20) not null,
    manager_password varchar(40),
    primary key (manager_account)
);

alter table manager
    comment '����Աר���˻�';

/*==============================================================*/
/* Table: order_logistics                                       */
/*==============================================================*/
create table order_logistics
(
    order_id     bigint not null,
    logistics_id int    not null,
    primary key (order_id, logistics_id)
);

/*==============================================================*/
/* Table: order_stateflow                                       */
/*==============================================================*/
create table order_stateflow
(
    status_id   smallint not null,
    order_id    bigint   not null,
    status_date datetime,
    primary key (status_id, order_id)
);

/*==============================================================*/
/* Table: order_status                                          */
/*==============================================================*/
create table order_status
(
    status_id   smallint not null auto_increment,
    status_name varchar(20),
    primary key (status_id)
);

/*==============================================================*/
/* Table: receive_address                                       */
/*==============================================================*/
create table receive_address
(
    receive_address_id int not null auto_increment,
    uid                int,
    address_details    varchar(100),
    is_default         bool,
    primary key (receive_address_id)
);

/*==============================================================*/
/* Table: shop                                                  */
/*==============================================================*/
create table shop
(
    sid              int not null auto_increment,
    uid              int,
    shop_name        varchar(20),
    shop_description varchar(100),
    shop_address     varchar(100),
    primary key (sid)
);

/*==============================================================*/
/* Table: shop_chat                                             */
/*==============================================================*/
create table shop_chat
(
    chat_id bigint not null,
    sid     int    not null,
    primary key (chat_id, sid)
);

/*==============================================================*/
/* Table: sub_commodity                                         */
/*==============================================================*/
create table sub_commodity
(
    sub_id   int not null auto_increment,
    cid      bigint,
    sub_name varchar(20),
    sub_icon varchar(200),
    stock    int,
    price    real,
    primary key (sub_id)
);

/*==============================================================*/
/* Table: user_chat                                             */
/*==============================================================*/
create table user_chat
(
    uid     int    not null,
    chat_id bigint not null,
    primary key (uid, chat_id)
);

/*==============================================================*/
/* Table: user_comment                                          */
/*==============================================================*/
create table user_comment
(
    comment_id  bigint not null auto_increment,
    uid         int,
    praise      bool,
    conntent    varchar(200),
    sub_comment bigint,
    primary key (comment_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
    uid                int not null auto_increment,
    user_password      varchar(20),
    user_alipayAccount varchar(40),
    uer_telephone      varchar(20),
    user_name          varchar(20),
    user_gender        varchar(20),
    user_selfie        varchar(200),
    user_signature     varchar(40),
    user_email         varchar(40),
    user_license       varchar(30),
    primary key (uid)
);

alter table user_info
    comment '�����û�';

alter table commodity
    add constraint FK_shop_commodity foreign key (sid)
        references shop (sid) on delete restrict on update restrict;

alter table commodity_add_label
    add constraint FK_commodity_label foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table commodity_add_label
    add constraint FK_commodity_label2 foreign key (label_id)
        references commodity_label (label_id) on delete restrict on update restrict;

alter table commodity_order
    add constraint FK_shop_order foreign key (sid)
        references shop (sid) on delete restrict on update restrict;

alter table commodity_order
    add constraint FK_���ζ������� foreign key (comment_id)
        references user_comment (comment_id) on
            delete
            restrict on
            update restrict;

alter table commodity_order
    add constraint FK_�û��¶��� foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

alter table commodity_order
    add constraint FK_����ָ����Ʒ foreign key (sub_id)
        references sub_commodity (sub_id) on
            delete
            restrict on
            update restrict;

alter table favorites
    add constraint FK_favorites foreign key (uid)
        references user_info (uid) on delete restrict on update restrict;

alter table favorites
    add constraint FK_favorites2 foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table footprint
    add constraint FK_��ʷ��� foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

alter table footprint
    add constraint FK_��ʷ�����Ʒ foreign key (cid)
        references commodity (cid) on
            delete
            restrict on
            update restrict;

alter table order_logistics
    add constraint FK_order_logistics foreign key (order_id)
        references commodity_order (order_id) on delete restrict on update restrict;

alter table order_logistics
    add constraint FK_order_logistics2 foreign key (logistics_id)
        references logistics (logistics_id) on delete restrict on update restrict;

alter table order_stateflow
    add constraint FK_order_order_status foreign key (status_id)
        references order_status (status_id) on delete restrict on update restrict;

alter table order_stateflow
    add constraint FK_����״̬��� foreign key (order_id)
        references commodity_order (order_id) on
            delete
            restrict on
            update restrict;

alter table receive_address
    add constraint FK_�û����ջ���ַ foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

alter table shop
    add constraint FK_���ҿ����� foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

alter table shop_chat
    add constraint FK_shop_chat foreign key (chat_id)
        references chat (chat_id) on delete restrict on update restrict;

alter table shop_chat
    add constraint FK_shop_chat2 foreign key (sid)
        references shop (sid) on delete restrict on update restrict;

alter table sub_commodity
    add constraint FK_commodity_sub foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table user_chat
    add constraint FK_user_chat foreign key (uid)
        references user_info (uid) on delete restrict on update restrict;

alter table user_chat
    add constraint FK_user_chat2 foreign key (chat_id)
        references chat (chat_id) on delete restrict on update restrict;

alter table user_comment
    add constraint FK_�û����۹������� foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

