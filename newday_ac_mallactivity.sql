/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/5 14:31:07                            */
/*==============================================================*/


drop table if exists AC_Mall_Activity;

drop table if exists AC_Mall_Activity_Goods;

/*==============================================================*/
/* Table: AC_Mall_Activity                                      */
/*==============================================================*/
create table AC_Mall_Activity
(
   id                   int not null,
   title                varchar(50),
   name                 varchar(50),
   dictcode             varchar(20),
   detailinfo           text,
   createtime           datetime,
   mcode                varchar(50),
   primary key (id),
   constraint FK_Reference_9 foreign key (mcode)
      references A_Managers (code) on delete restrict on update restrict,
   constraint FK_Mall_Activity_Type foreign key (dictcode)
      references A_Dicts (code) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: AC_Mall_Activity_Goods                                */
/*==============================================================*/
create table AC_Mall_Activity_Goods
(
   id                   int not null,
   mallid               int,
   goodid               char(20),
   createtime           datetime,
   state                varchar(20),
   primary key (id),
   constraint FK_mallactivitylist_mallactivity foreign key (mallid)
      references AC_Mall_Activity (id) on delete restrict on update restrict,
   constraint FK_mallactivitylist_goods foreign key (goodid)
      references AB_Goods (id) on delete restrict on update restrict
);

