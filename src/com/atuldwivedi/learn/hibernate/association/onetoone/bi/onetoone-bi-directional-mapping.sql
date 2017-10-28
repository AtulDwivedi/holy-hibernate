DROP SCHEMA IF EXISTS hfw_onetoone_bi;

CREATE SCHEMA hfw_onetoone_bi;

CREATE TABLE hfw_onetoone_bi.Phone (
    id BIGINT AUTO_INCREMENT,
    number VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE hfw_onetoone_bi.PhoneDetails (
    id BIGINT AUTO_INCREMENT,
    provider VARCHAR(255),
    technology VARCHAR(255),
    phone_id BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE hfw_onetoone_bi.PhoneDetails
ADD CONSTRAINT hfw_onetoone_bi_phonedetails_fk 
FOREIGN KEY (phone_id) REFERENCES hfw_onetoone_bi.Phone(id);