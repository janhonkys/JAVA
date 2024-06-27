CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','Tester',20),
	(2,'Emma','Baumgarten','Manager',30),
	(3,'Avani','Gupta','Developer',35),
	(4,'Yuri','Petrov','Tester',45),
	(5,'Juan','Vega','Developer',47);
ALTER TABLE employee MODIFY COLUMN position VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE employee MODIFY COLUMN first_name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE employee MODIFY COLUMN position VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SELECT COUNT(*) AS totalEmployees FROM employee;
INSERT INTO `employee` VALUES (1,'Leslie','Andrews','Tester',20);
SELECT * from employee;
DELETE FROM employee WHERE id = 1;

SELECT COUNT(*) AS totalEmployees FROM employee WHERE age < 20;
SELECT COUNT(*) AS totalEmployees1 FROM employee WHERE age BETWEEN 20 AND 40;
SELECT COUNT(*) AS totalEmployees2 FROM employee WHERE age BETWEEN 40 AND 60;
SELECT COUNT(*) AS totalEmployees3 FROM employee WHERE age > 60;
