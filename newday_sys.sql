/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/13 17:36:48                           */
/*==============================================================*/


alter table AB_Brands
   drop primary key;

drop table if exists AB_Brands;

alter table AB_Goods
   drop primary key;

drop table if exists AB_Goods;

alter table AB_Types
   drop primary key;

drop table if exists AB_Types;

alter table A_Dicts
   drop primary key;

drop table if exists A_Dicts;

alter table A_Managers
   drop primary key;

drop table if exists A_Managers;

alter table A_Menus
   drop primary key;

drop table if exists A_Menus;

alter table A_Users
   drop primary key;

drop table if exists A_Users;

/*==============================================================*/
/* Table: AB_Brands                                             */
/*==============================================================*/
create table AB_Brands
(
   id                   int not null,
   type                 varchar(20),
   name                 varchar(20)
);

alter table AB_Brands
   add primary key (id);

/*==============================================================*/
/* Table: AB_Goods                                              */
/*==============================================================*/
create table AB_Goods
(
   id                   char(20) not null,
   type                 int,
   brand                int,
   name                 varchar(50),
   stock                int,
   price                decimal(10),
   effect               varchar(200),
   spec                 varchar(100),
   area                 varchar(100),
   packing              varchar(50),
   state                varchar(20),
   mainpicture          text,
   secpicture           text,
   specifics            text,
   createtime           datetime,
   publishtime          datetime
);

alter table AB_Goods
   add primary key (id);

/*==============================================================*/
/* Table: AB_Types                                              */
/*==============================================================*/
create table AB_Types
(
   id                   int not null,
   dictcode             varchar(20),
   pid                  int,
   name                 varchar(50)
);

alter table AB_Types
   add primary key (id);

/*==============================================================*/
/* Table: A_Dicts                                               */
/*==============================================================*/
create table A_Dicts
(
   code                 varchar(20) not null,
   name                 varchar(100),
   detailinfo           text,
   type                 varchar(50),
   typedetail           text
);

alter table A_Dicts
   add primary key (code);

/*==============================================================*/
/* Table: A_Managers                                            */
/*==============================================================*/
create table A_Managers
(
   code                 varchar(50) not null,
   password             varchar(50),
   name                 varchar(100)
);

alter table A_Managers
   add primary key (code);

/*==============================================================*/
/* Table: A_Menus                                               */
/*==============================================================*/
create table A_Menus
(
   id                   int not null,
   name                 varchar(50),
   type                 char(3),
   level                int,
   orderid              int,
   pid                  int,
   status               char,
   usercode             varchar(50),
   createtime           date
);

alter table A_Menus
   add primary key (id);

/*==============================================================*/
/* Table: A_Users                                               */
/*==============================================================*/
create table A_Users
(
   code                 varchar(50) not null,
   password             varchar(50),
   name                 varchar(100)
);

alter table A_Users
   add primary key (code);

alter table AB_Brands add constraint FK_brand_dict foreign key (type)
      references A_Dicts (code) on delete restrict on update restrict;

alter table AB_Goods add constraint FK_good_brand foreign key (brand)
      references AB_Brands (id) on delete restrict on update restrict;

alter table AB_Goods add constraint FK_good_type foreign key (type)
      references AB_Types (id) on delete restrict on update restrict;

alter table AB_Goods add constraint FK_goods_state foreign key (state)
      references A_Dicts (code) on delete restrict on update restrict;

alter table AB_Types add constraint FK_type_dict foreign key (dictcode)
      references A_Dicts (code) on delete restrict on update restrict;

alter table A_Menus add constraint FK_user_menu foreign key (usercode)
      references A_Managers (code) on delete restrict on update restrict;

