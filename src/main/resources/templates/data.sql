DROP DATABASE IF EXISTS projectmanager_db;
CREATE DATABASE projectmanager_db;
USE projectmanager_db;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS subproject;
DROP TABLE IF EXISTS task;

CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       first_name VARCHAR(50),
                       username VARCHAR(50),
                       password INT(255)
);

CREATE TABLE project (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         users_id INT,
                         name VARCHAR(255),
                         description VARCHAR(255),
                         status VARCHAR(255),
                         start_date DATE,
                         end_date DATE,
                         FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE subproject (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            project_id INT,
                            name VARCHAR(255),
                            status VARCHAR(255),
                            start_date INT,
                            end_date INT,
                            FOREIGN KEY (project_id) REFERENCES project(id)
);

CREATE TABLE task (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      subproject_id INT,
                      name VARCHAR(255),
                      FOREIGN KEY (subproject_id) REFERENCES subproject(id)
);

select * from users