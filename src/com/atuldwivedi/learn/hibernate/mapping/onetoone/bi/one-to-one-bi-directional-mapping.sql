DROP SCHEMA IF EXISTS HFW_ONETOONE_BI;

CREATE SCHEMA HFW_ONETOONE_BI;
  
CREATE TABLE HFW_ONETOONE_BI.HFW_ONETOONE_TRAINER_DETAIL 
  ( 
     ID      BIGINT AUTO_INCREMENT PRIMARY KEY, 
     EMAIL   VARCHAR(50), 
     WEBSITE VARCHAR(100) 
  );
  
CREATE TABLE HFW_ONETOONE_BI.HFW_ONETOONE_TRAINER 
  ( 
     ID                BIGINT AUTO_INCREMENT, 
     NAME              VARCHAR(50), 
     MOBILE_NUMBER     VARCHAR(10), 
     TRAINER_DETAIL_ID BIGINT, 
     PRIMARY KEY(ID), 
     FOREIGN KEY (TRAINER_DETAIL_ID) REFERENCES HFW_ONETOONE_TRAINER_DETAIL (ID) 
  );  
