DROP TABLE IF EXISTS ROLE CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE ROLE
(
    ID           INT8,
    CONSTRAINT ROLE_PK PRIMARY KEY (ID),
    NAME varchar(256)
);
