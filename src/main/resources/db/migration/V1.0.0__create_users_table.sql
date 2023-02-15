DROP TABLE IF EXISTS USERS CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE USERS
(
    ID           INT8,
    CONSTRAINT USERS_PK PRIMARY KEY (ID),
    EMAIL varchar(256),
    NAME varchar(256),
    LASTNAME varchar(256)
);
