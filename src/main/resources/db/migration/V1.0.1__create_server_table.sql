DROP TABLE IF EXISTS SERVER CASCADE;

SET standard_conforming_strings = OFF;
CREATE TABLE SERVER
(
    ID           INT8,
    CONSTRAINT SERVER_PK PRIMARY KEY (ID),
    OGCPROTOCOL VARCHAR(256),
    TITLE VARCHAR(256),
    VERSION VARCHAR(256),
    URL VARCHAR(256),
    QUERYABLE bool
);

