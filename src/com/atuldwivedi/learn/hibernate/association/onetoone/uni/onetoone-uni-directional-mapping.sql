DROP SCHEMA IF EXISTS hfw_onetoone_uni;

CREATE SCHEMA hfw_onetoone_uni;

CREATE TABLE hfw_onetoone_uni.Phone (
    id BIGINT AUTO_INCREMENT,
    number VARCHAR(255),
    details_id BIGINT,
    PRIMARY KEY ( id )
);

CREATE TABLE hfw_onetoone_uni.PhoneDetails (
    id BIGINT AUTO_INCREMENT,
    provider VARCHAR(255),
    technology VARCHAR(255),
    PRIMARY KEY ( id )
);

ALTER TABLE hfw_onetoone_uni.Phone
ADD CONSTRAINT hfw_onetoone_uni_phone_fk 
FOREIGN KEY (details_id) REFERENCES hfw_onetoone_uni.PhoneDetails(id);