create database Resource_management_system

use Resource_management_system

select * from users
drop table users

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    email_address VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
delete from users where user_id=6;


CREATE TABLE files (
    id INT AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(255),
    file_type VARCHAR(100),
    file_data LONGBLOB
);



