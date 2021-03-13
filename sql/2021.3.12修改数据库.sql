/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/3/12 10:56:08                           */
/*==============================================================*/


drop table if exists chat;

drop table if exists chat_details;

drop table if exists commmodity_details;

drop table if exists commodity;

drop table if exists commodity_label;

drop table if exists commodity_order;

drop table if exists data_dictionary;

drop table if exists favorites_commodity;

drop table if exists favorites_shop;

drop table if exists footprint;

drop table if exists logistics;

drop table if exists manager;

drop table if exists order_logistics;

drop table if exists order_stateflow;

drop table if exists receive_address;

drop table if exists shop;

drop table if exists sub_commodity;

drop table if exists user_comment;

drop table if exists user_info;

/*==============================================================*/
/* Table: chat                                                  */
/*==============================================================*/
create table chat
(
    chat_id         bigint not null auto_increment,
    chat_content_id bigint,
    chat_date       datetime,
    sender_id       int,
    sender_type     varchar(10),
    receiver_id     int,
    receiver_type   varchar(10),
    primary key (chat_id)
);

alter table chat
    comment '�����û�֮�䣬���ߵ���֮�䶼������˽��.
���ֻ�С��û����͡����̡�';

/*==============================================================*/
/* Table: chat_details                                          */
/*==============================================================*/
create table chat_details
(
    chat_content_id bigint not null auto_increment,
    chat_content    varchar(200),
    primary key (chat_content_id)
);

/*==============================================================*/
/* Table: commmodity_details                                    */
/*==============================================================*/
create table commmodity_details
(
    details_id  bigint not null auto_increment,
    cid         bigint,
    details_url varchar(200),
    primary key (details_id)
);

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
    cid              bigint not null auto_increment,
    sid              int,
    commodity_name   varchar(40),
    commodity_icon   varchar(200),
    commodity_status bool,
    primary key (cid)
);

/*==============================================================*/
/* Table: commodity_label                                       */
/*==============================================================*/
create table commodity_label
(
    cid       bigint not null,
    record_id bigint not null,
    primary key (cid, record_id)
);

/*==============================================================*/
/* Table: commodity_order                                       */
/*==============================================================*/
create table commodity_order
(
    order_id           bigint not null auto_increment,
    comment_id         bigint,
    sid                int,
    uid                int,
    receive_address_id int,
    sub_id             int,
    count_commodity    int,
    primary key (order_id)
);

/*==============================================================*/
/* Table: data_dictionary                                       */
/*==============================================================*/
create table data_dictionary
(
    record_id          bigint not null auto_increment,
    t_index            varchar(30),
    item_name          varchar(50),
    record_create      datetime,
    record_description varchar(50),
    primary key (record_id)
);

/*==============================================================*/
/* Table: favorites_commodity                                   */
/*==============================================================*/
create table favorites_commodity
(
    uid int    not null,
    cid bigint not null,
    primary key (uid, cid)
);

/*==============================================================*/
/* Table: favorites_shop                                        */
/*==============================================================*/
create table favorites_shop
(
    uid int not null,
    sid int not null,
    primary key (uid, sid)
);

/*==============================================================*/
/* Table: footprint                                             */
/*==============================================================*/
create table footprint
(
    cid               bigint,
    uid               int,
    last_browser_date date
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
    order_id    bigint,
    record_id   bigint,
    status_date datetime
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
/* Table: user_comment                                          */
/*==============================================================*/
create table user_comment
(
    comment_id  bigint not null auto_increment,
    uid         int,
    praise      bool,
    sub_comment bigint,
    primary key (comment_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
    uid                 int not null auto_increment,
    user_telephone      varchar(20),
    user_password       varchar(20),
    user_name           varchar(20),
    user_gender         varchar(20),
    user_selfie         varchar(200),
    user_signature      varchar(40),
    user_alipay_account varchar(40),
    user_email          varchar(40),
    user_license        varchar(30),
    primary key (uid)
);

alter table user_info
    comment '�����û�';

alter table chat
    add constraint FK_chat_receiver foreign key (sender_id)
        references user_info (uid) on delete restrict on update restrict;

alter table chat
    add constraint FK_chat_sender foreign key (receiver_id)
        references user_info (uid) on delete restrict on update restrict;

alter table chat
    add constraint FK_get_chat_content foreign key (chat_content_id)
        references chat_details (chat_content_id) on delete restrict on update restrict;

alter table commmodity_details
    add constraint FK_��Ʒ�����¼ foreign key (cid)
        references commodity (cid) on
            delete
            restrict on
            update restrict;

alter table commodity
    add constraint FK_shop_commodity foreign key (sid)
        references shop (sid) on delete restrict on update restrict;

alter table commodity_label
    add constraint FK_commodity_label foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table commodity_label
    add constraint FK_commodity_label2 foreign key (record_id)
        references data_dictionary (record_id) on delete restrict on update restrict;

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

alter table commodity_order
    add constraint FK_�����ջ���ַ foreign key (receive_address_id)
        references receive_address (receive_address_id) on
            delete
            restrict on
            update restrict;

alter table favorites_commodity
    add constraint FK_favorites_commodity foreign key (uid)
        references user_info (uid) on delete restrict on update restrict;

alter table favorites_commodity
    add constraint FK_favorites_commodity2 foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table favorites_shop
    add constraint FK_favorites_shop foreign key (uid)
        references user_info (uid) on delete restrict on update restrict;

alter table favorites_shop
    add constraint FK_favorites_shop2 foreign key (sid)
        references shop (sid) on delete restrict on update restrict;

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
    add constraint FK_order_order_status foreign key (record_id)
        references data_dictionary (record_id) on delete restrict on update restrict;

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

alter table sub_commodity
    add constraint FK_commodity_sub foreign key (cid)
        references commodity (cid) on delete restrict on update restrict;

alter table user_comment
    add constraint FK_�û����۹������� foreign key (uid)
        references user_info (uid) on
            delete
            restrict on
            update restrict;

