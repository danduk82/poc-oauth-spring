DROP TABLE IF EXISTS ACL CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE ACL
(
    ID           INT8,
    CONSTRAINT ACL_PK PRIMARY KEY (ID),
    FK_LAYER_ID INT8,
    FK_ROLE_ID INT8
);

ALTER TABLE ACL
    ADD CONSTRAINT fk_layer_id_constraint
        FOREIGN KEY (FK_LAYER_ID) REFERENCES LAYER (id);
ALTER TABLE ACL
    ADD CONSTRAINT fk_role_id_constraint
        FOREIGN KEY (FK_ROLE_ID) REFERENCES ROLE (id);
