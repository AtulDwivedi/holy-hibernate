DROP SCHEMA IF EXISTS HFW_ONETOMANY_BI;

CREATE SCHEMA HFW_ONETOMANY_BI;

CREATE TABLE HFW_ONETOMANY_BI.COURSE 
  ( 
     ID      BIGINT AUTO_INCREMENT, 
     TITLE   VARCHAR(50), 
     
     PRIMARY KEY(ID),
--     UNIQUE KEY TITLE_UNIQUE_KEY (TITLE),
  );
  
  CREATE TABLE HFW_ONETOMANY_BI.ASSIGNMENT 
  ( 
     ID      BIGINT AUTO_INCREMENT, 
     DESCRIPTION   VARCHAR(200),
     COURSE_ID 		BIGINT,
     
     PRIMARY KEY(ID),
     FOREIGN KEY(COURSE_ID) REFERENCES COURSE(ID)
  );