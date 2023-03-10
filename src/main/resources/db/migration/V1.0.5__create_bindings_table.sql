DROP TABLE IF EXISTS BINDINGS CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE BINDINGS
(
    ID           INT8,
    CONSTRAINT BINDINGS_PK PRIMARY KEY (ID),
    FK_USERS_ID INT8,
    FK_ROLE_ID INT8
);

ALTER TABLE BINDINGS
    ADD CONSTRAINT fk_user_id_constraint
        FOREIGN KEY (FK_USERS_ID) REFERENCES USERS (id);
ALTER TABLE BINDINGS
    ADD CONSTRAINT fk_role_id_constraint
        FOREIGN KEY (FK_ROLE_ID) REFERENCES ROLE (id);
