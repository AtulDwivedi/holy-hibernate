/*
 * HFW_STUDENT_IDENTITY - starts
 * ------------------------------------------------------------------
 * Hibernate Framework Student Table Number 01
 */
DROP TABLE IF EXISTS HFW_STUDENT_IDENTITY;

CREATE TABLE HFW_STUDENT_IDENTITY
	(ROLL_NUMBER			BIGINT AUTO_INCREMENT PRIMARY KEY,
	 NAME 					VARCHAR(50) NOT NULL,
	 EMAIL					VARCHAR(50),
	 MOBILE					VARCHAR(10),
	 ADDRESS				VARCHAR(200));
	 
/*
 * MySQL 
 * This will reset the auto increment counter to specified value.
 */
ALTER TABLE HFW_STUDENT_IDENTITY AUTO_INCREMENT = 2001;
/*
 * H2 
 * This will reset the auto increment counter to specified value.
 */
ALTER TABLE HFW_STUDENT_IDENTITY ALTER COLUMN ROLL_NUMBER  RESTART WITH 1001;

/* 
 * MySQL
 * This will delete all the rows from table and reset the auto increment counter to 1
 */
TRUNCATE TABLE HFW_STUDENT_IDENTITY;