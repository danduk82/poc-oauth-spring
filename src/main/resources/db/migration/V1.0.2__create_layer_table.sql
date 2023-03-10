DROP TABLE IF EXISTS LAYER CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE LAYER
(
    ID           INT8,
    CONSTRAINT LAYER_PK PRIMARY KEY (ID),
    FK_SERVER_ID INT8,
    NAME varchar(256),
    TITLE varchar(256),
    MATRIXSET varchar(256),
    QUERIABLE bool
);


ALTER TABLE LAYER
    ADD CONSTRAINT fk_server_id_constraint
        FOREIGN KEY (FK_SERVER_ID) REFERENCES SERVER (id);
