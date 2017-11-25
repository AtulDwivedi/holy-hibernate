--DROP SCHEMA IF EXISTS hfw_manytomany_bi;

--CREATE SCHEMA hfw_manytomany_bi;

DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Person_Address;

CREATE TABLE Address (
    id BIGINT AUTO_INCREMENT,
    number VARCHAR(255) ,
    street VARCHAR(255) ,
    PRIMARY KEY ( id )
);

CREATE TABLE Person (
    id BIGINT  AUTO_INCREMENT,
    name varchar,
    PRIMARY KEY ( id )
);

CREATE TABLE Person_Address (
    Owners_id BIGINT NOT NULL ,
    addresses_id BIGINT NOT NULL
);

ALTER TABLE Person_Address
ADD CONSTRAINT addresses_id_fk
FOREIGN KEY (addresses_id) REFERENCES Address;

ALTER TABLE Person_Address
ADD CONSTRAINT Owners_id_fk
FOREIGN KEY (Owners_id) REFERENCES Person;