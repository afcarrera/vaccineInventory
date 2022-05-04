/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     02/05/2022 14:44:14                          */
/*==============================================================*/


drop index EMPL_ADDR_FK;

drop index ADDRESS_PK;

drop table ADDRESS;

drop index DOSE_PK;

drop table DOSE;

drop index STATUS_FK;

drop index USER_EMPL_FK;

drop index EMPLOYEE_PK;

drop table EMPLOYEE;

drop index USER_ROLE_FK;

drop index USER_PK;

drop table END_USER;

drop index OPTION_PK;

drop table OPTION;

drop index PHON_TYPE_FK;

drop index EMPL_PHON_FK;

drop index PHONE_PK;

drop table PHONE;

drop index PHONE_TYPE_PK;

drop table PHONE_TYPE;

drop index ROLE_PK;

drop table ROLE;

drop index OPTIONS_FK;

drop index ROLE_FK;

drop index ROLE_OPTION_PK;

drop table ROLE_OPTION;

drop index EMPLOYEE_FK;

drop index VACCINATION_FK;

drop index VACCINATION_PK;

drop table VACCINATION;

drop index VACCINATION_STATUS_PK;

drop table VACCINATION_STATUS;

drop index VACCINE_PK;

drop table VACCINE;

drop index DOSE_FK;

drop index VACCINE_FK;

drop index VACCINE_DOSE_PK;

drop table VACCINE_DOSE;

/*==============================================================*/
/* Table: ADDRESS                                               */
/*==============================================================*/
create table ADDRESS (
   ADDR_ID              SERIAL not null,
   EMPL_ID              INT4                 not null,
   ADDR_DESCRIPTION     VARCHAR(256)         not null,
   ADDR_PRIMARY         BOOL                 null,
   constraint PK_ADDRESS primary key (ADDR_ID)
);

/*==============================================================*/
/* Index: ADDRESS_PK                                            */
/*==============================================================*/
create unique index ADDRESS_PK on ADDRESS (
ADDR_ID
);

/*==============================================================*/
/* Index: EMPL_ADDR_FK                                          */
/*==============================================================*/
create  index EMPL_ADDR_FK on ADDRESS (
EMPL_ID
);

/*==============================================================*/
/* Table: DOSE                                                  */
/*==============================================================*/
create table DOSE (
   DOSE_ID              VARCHAR(10)          not null,
   DOSE_DESCRIPTION     VARCHAR(64)          not null,
   constraint PK_DOSE primary key (DOSE_ID)
);

/*==============================================================*/
/* Index: DOSE_PK                                               */
/*==============================================================*/
create unique index DOSE_PK on DOSE (
DOSE_ID
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE (
   EMPL_ID              SERIAL not null,
   USER_ID              INT4                 not null,
   VAST_ID              VARCHAR(10)          not null,
   EMPL_IDENTIFICATION  CHAR(10)             not null,
   EMPL_FIRST_NAME      VARCHAR(64)          not null,
   EMPL_SECOND_NAME     VARCHAR(64)          not null,
   EMPL_FIRST_SURNAME   VARCHAR(64)          not null,
   EMPL_SECOND_SURNAME  VARCHAR(64)          not null,
   EMPL_FULL_NAME       VARCHAR(256)         null,
   EMPL_EMAIL           VARCHAR(64)          not null,
   EMPL_BIRTHDAY_DATE   DATE                 null,
   constraint PK_EMPLOYEE primary key (EMPL_ID)
);

/*==============================================================*/
/* Index: EMPLOYEE_PK                                           */
/*==============================================================*/
create unique index EMPLOYEE_PK on EMPLOYEE (
EMPL_ID
);

/*==============================================================*/
/* Index: USER_EMPL_FK                                          */
/*==============================================================*/
create  index USER_EMPL_FK on EMPLOYEE (
USER_ID
);

/*==============================================================*/
/* Index: STATUS_FK                                             */
/*==============================================================*/
create  index STATUS_FK on EMPLOYEE (
VAST_ID
);

/*==============================================================*/
/* Table: END_USER                                              */
/*==============================================================*/
create table END_USER (
   USER_ID              SERIAL not null,
   ROLE_ID              VARCHAR(10)          not null,
   USER_NAME            VARCHAR(40)          not null,
   USER_PASSWORD        VARCHAR(255)         not null,
   USER_MODIFICATION_DATE DATE                 not null,
   USER_LOGIN_COUNT     INT4                 not null,
   USER_OLD_PASSWORD    VARCHAR(255)         null,
   constraint PK_END_USER primary key (USER_ID)
);

/*==============================================================*/
/* Index: USER_PK                                               */
/*==============================================================*/
create unique index USER_PK on END_USER (
USER_ID
);

/*==============================================================*/
/* Index: USER_ROLE_FK                                          */
/*==============================================================*/
create  index USER_ROLE_FK on END_USER (
ROLE_ID
);

/*==============================================================*/
/* Table: OPTION                                                */
/*==============================================================*/
create table OPTION (
   OPTI_ID              VARCHAR(10)          not null,
   OPTI_NAME            VARCHAR(128)         not null,
   constraint PK_OPTION primary key (OPTI_ID)
);

/*==============================================================*/
/* Index: OPTION_PK                                             */
/*==============================================================*/
create unique index OPTION_PK on OPTION (
OPTI_ID
);

/*==============================================================*/
/* Table: PHONE                                                 */
/*==============================================================*/
create table PHONE (
   PHON_ID              SERIAL               not null,
   EMPL_ID              INT4                 not null,
   PHTY_ID              VARCHAR(10)          not null,
   PHON_NUMBER          VARCHAR(20)          not null,
   PHON_PRIMARY         BOOL                 null,
   constraint PK_PHONE primary key (PHON_ID)
);

/*==============================================================*/
/* Index: PHONE_PK                                              */
/*==============================================================*/
create unique index PHONE_PK on PHONE (
PHON_ID
);

/*==============================================================*/
/* Index: EMPL_PHON_FK                                          */
/*==============================================================*/
create  index EMPL_PHON_FK on PHONE (
EMPL_ID
);

/*==============================================================*/
/* Index: PHON_TYPE_FK                                          */
/*==============================================================*/
create  index PHON_TYPE_FK on PHONE (
PHTY_ID
);

/*==============================================================*/
/* Table: PHONE_TYPE                                            */
/*==============================================================*/
create table PHONE_TYPE (
   PHTY_ID              VARCHAR(10)          not null,
   PHTY_NAME            VARCHAR(32)          not null,
   constraint PK_PHONE_TYPE primary key (PHTY_ID)
);

/*==============================================================*/
/* Index: PHONE_TYPE_PK                                         */
/*==============================================================*/
create unique index PHONE_TYPE_PK on PHONE_TYPE (
PHTY_ID
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
create table ROLE (
   ROLE_ID              VARCHAR(10)          not null,
   ROLE_DESCRIPTION     VARCHAR(20)          not null,
   constraint PK_ROLE primary key (ROLE_ID)
);

/*==============================================================*/
/* Index: ROLE_PK                                               */
/*==============================================================*/
create unique index ROLE_PK on ROLE (
ROLE_ID
);

/*==============================================================*/
/* Table: ROLE_OPTION                                           */
/*==============================================================*/
create table ROLE_OPTION (
   ROLE_OPTI_ID         SERIAL               not null,
   ROLE_ID              VARCHAR(10)          not null,
   OPTI_ID              VARCHAR(10)          not null,
   constraint PK_ROLE_OPTION primary key (ROLE_OPTI_ID)
);

/*==============================================================*/
/* Index: ROLE_OPTION_PK                                        */
/*==============================================================*/
create unique index ROLE_OPTION_PK on ROLE_OPTION (
ROLE_OPTI_ID
);

/*==============================================================*/
/* Index: ROLE_FK                                               */
/*==============================================================*/
create  index ROLE_FK on ROLE_OPTION (
ROLE_ID
);

/*==============================================================*/
/* Index: OPTIONS_FK                                            */
/*==============================================================*/
create  index OPTIONS_FK on ROLE_OPTION (
OPTI_ID
);

/*==============================================================*/
/* Table: VACCINATION                                           */
/*==============================================================*/
create table VACCINATION (
   VACC_ID              SERIAL not null,
   VACC_DOSE_ID         VARCHAR(10)          not null,
   EMPL_ID              INT4                 not null,
   VACC_VACCINATION_DATE DATE                 not null,
   constraint PK_VACCINATION primary key (VACC_ID)
);

/*==============================================================*/
/* Index: VACCINATION_PK                                        */
/*==============================================================*/
create unique index VACCINATION_PK on VACCINATION (
VACC_ID
);

/*==============================================================*/
/* Index: VACCINATION_FK                                        */
/*==============================================================*/
create  index VACCINATION_FK on VACCINATION (
VACC_DOSE_ID
);

/*==============================================================*/
/* Index: EMPLOYEE_FK                                           */
/*==============================================================*/
create  index EMPLOYEE_FK on VACCINATION (
EMPL_ID
);

/*==============================================================*/
/* Table: VACCINATION_STATUS                                    */
/*==============================================================*/
create table VACCINATION_STATUS (
   VAST_ID              VARCHAR(10)          not null,
   VAST_STATUS          VARCHAR(16)          not null,
   constraint PK_VACCINATION_STATUS primary key (VAST_ID)
);

/*==============================================================*/
/* Index: VACCINATION_STATUS_PK                                 */
/*==============================================================*/
create unique index VACCINATION_STATUS_PK on VACCINATION_STATUS (
VAST_ID
);

/*==============================================================*/
/* Table: VACCINE                                               */
/*==============================================================*/
create table VACCINE (
   VATY_ID              VARCHAR(10)          not null,
   VATY_NAME            VARCHAR(32)          not null,
   constraint PK_VACCINE primary key (VATY_ID)
);

/*==============================================================*/
/* Index: VACCINE_PK                                            */
/*==============================================================*/
create unique index VACCINE_PK on VACCINE (
VATY_ID
);

/*==============================================================*/
/* Table: VACCINE_DOSE                                          */
/*==============================================================*/
create table VACCINE_DOSE (
   VACC_DOSE_ID         VARCHAR(10)          not null,
   VATY_ID              VARCHAR(10)          not null,
   DOSE_ID              VARCHAR(10)          not null,
   constraint PK_VACCINE_DOSE primary key (VACC_DOSE_ID)
);

/*==============================================================*/
/* Index: VACCINE_DOSE_PK                                       */
/*==============================================================*/
create unique index VACCINE_DOSE_PK on VACCINE_DOSE (
VACC_DOSE_ID
);

/*==============================================================*/
/* Index: VACCINE_FK                                            */
/*==============================================================*/
create  index VACCINE_FK on VACCINE_DOSE (
VATY_ID
);

/*==============================================================*/
/* Index: DOSE_FK                                               */
/*==============================================================*/
create  index DOSE_FK on VACCINE_DOSE (
DOSE_ID
);

alter table ADDRESS
   add constraint FK_ADDRESS_EMPL_ADDR_EMPLOYEE foreign key (EMPL_ID)
      references EMPLOYEE (EMPL_ID)
      on delete restrict on update restrict;

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_STATUS_VACCINAT foreign key (VAST_ID)
      references VACCINATION_STATUS (VAST_ID)
      on delete restrict on update restrict;

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_USER_EMPL_END_USER foreign key (USER_ID)
      references END_USER (USER_ID)
      on delete restrict on update restrict;

alter table END_USER
   add constraint FK_END_USER_USER_ROLE_ROLE foreign key (ROLE_ID)
      references ROLE (ROLE_ID)
      on delete restrict on update restrict;

alter table PHONE
   add constraint FK_PHONE_EMPL_PHON_EMPLOYEE foreign key (EMPL_ID)
      references EMPLOYEE (EMPL_ID)
      on delete restrict on update restrict;

alter table PHONE
   add constraint FK_PHONE_PHON_TYPE_PHONE_TY foreign key (PHTY_ID)
      references PHONE_TYPE (PHTY_ID)
      on delete restrict on update restrict;

alter table ROLE_OPTION
   add constraint FK_ROLE_OPT_OPTIONS_OPTION foreign key (OPTI_ID)
      references OPTION (OPTI_ID)
      on delete restrict on update restrict;

alter table ROLE_OPTION
   add constraint FK_ROLE_OPT_ROLE_ROLE foreign key (ROLE_ID)
      references ROLE (ROLE_ID)
      on delete restrict on update restrict;

alter table VACCINATION
   add constraint FK_VACCINAT_EMPLOYEE_EMPLOYEE foreign key (EMPL_ID)
      references EMPLOYEE (EMPL_ID)
      on delete restrict on update restrict;

alter table VACCINATION
   add constraint FK_VACCINAT_VACCINATI_VACCINE_ foreign key (VACC_DOSE_ID)
      references VACCINE_DOSE (VACC_DOSE_ID)
      on delete restrict on update restrict;

alter table VACCINE_DOSE
   add constraint FK_VACCINE__DOSE_DOSE foreign key (DOSE_ID)
      references DOSE (DOSE_ID)
      on delete restrict on update restrict;

alter table VACCINE_DOSE
   add constraint FK_VACCINE__VACCINE_VACCINE foreign key (VATY_ID)
      references VACCINE (VATY_ID)
      on delete restrict on update restrict;

