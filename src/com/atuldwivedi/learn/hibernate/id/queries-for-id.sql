/*
 * HFW_STUDENT_01 - starts
 * ------------------------------------------------------------------
 * Hibernate Framework Student Table Number 01
 */
DROP TABLE IF EXISTS HFW_STUDENT_01;

CREATE TABLE HFW_STUDENT_01
	(ROLL_NUMBER			BIGINT AUTO_INCREMENT PRIMARY KEY,
	 NAME 					VARCHAR(50) NOT NULL,
	 EMAIL					VARCHAR(50),
	 MOBILE					VARCHAR(10),
	 ADDRESS				VARCHAR(200));
	 
/*
 * MySQL 
 * This will reset the auto increment counter to specified value.
 */
ALTER TABLE HFW_STUDENT_01 AUTO_INCREMENT = 2001;
/*
 * H2 
 * This will reset the auto increment counter to specified value.
 */
ALTER TABLE HFW_STUDENT_01 ALTER COLUMN ROLL_NUMBER  RESTART WITH 1001;

/* 
 * MySQL
 * This will delete all the rows from table and reset the auto increment counter to 1
 */
TRUNCATE TABLE HFW_STUDENT_01;


/*
 * HFW_STUDENT_01 - ends
 * ------------------------------------------------------------------
 */


CREATE SEQUENCE ROLL_NUMBER_SEQ;

ALTER SEQUENCE ROLL_NUMBER_SEQ RESTART WITH 1;

DROP TABLE IF EXISTS HFW_STUDENT;

CREATE TABLE HFW_STUDENT
	(ROLL_NUMBER			BIGINT PRIMARY KEY,
	 NAME 					VARCHAR(50) NOT NULL,
	 EMAIL					VARCHAR(50),
	 MOBILE					VARCHAR(10),
	 ADDRESS				VARCHAR(200));
	 
INSERT INTO HFW_STUDENT VALUES(1000, 'Atul Dwivedi', 'contact@atuldwivedi.com', '9110460027', 'Bengaluru');