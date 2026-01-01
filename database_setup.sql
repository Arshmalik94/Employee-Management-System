-- 1. Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS mysqljava;

-- 2. Select the database to use (CRITICAL STEP)
USE mysqljava;

-- 3. Create the 'login' table
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(50),
    PASSWORD VARCHAR(50)
);

-- 4. Create the 'employee' table
CREATE TABLE IF NOT EXISTS employee (
    NAME VARCHAR(100),
    fname VARCHAR(100),
    dob VARCHAR(30),
    salary VARCHAR(20),
    address VARCHAR(200),
    phone VARCHAR(15),
    email VARCHAR(100),
    education VARCHAR(50),
    designation VARCHAR(50),
    aadhar VARCHAR(15),
    empId VARCHAR(10) PRIMARY KEY
);

-- 5. Insert the Admin user (only if table is empty)
INSERT INTO login (username, PASSWORD)
SELECT 'admin', '12345'
WHERE NOT EXISTS (SELECT * FROM login WHERE username = 'admin');