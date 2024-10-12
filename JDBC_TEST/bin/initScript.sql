CREATE DATABASE Employees;

USE Employees;

CREATE TABLE Employee(
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100),
    employee_salary INT,
    employee_dept VARCHAR(50)
);

-- Initial data for easy processing and visualization
INSERT INTO Employee
VALUES (1,'Niraj',8,'Software'),
(2,'Akash',10,'IT'),
(3,'Atharva',6,'Consulting');

SELECT * FROM Employee;