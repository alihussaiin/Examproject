DROP DATABASE IF EXISTS projectmanager_db;
CREATE DATABASE projectmanager_db;
USE projectmanager_db;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS subproject;
DROP TABLE IF EXISTS task;

CREATE TABLE users (
                       users_id INT PRIMARY KEY AUTO_INCREMENT,
                       first_name VARCHAR(50),
                       last_name VARCHAR(50),
                       username VARCHAR(50),
                       password INT(255)
);

CREATE TABLE project (
                         project_id INT PRIMARY KEY AUTO_INCREMENT,
                         users_id INT,
                         name VARCHAR(255),
                         description VARCHAR(255),
                         status VARCHAR(255),
                         start_date DATE,
                         end_date DATE,
                         FOREIGN KEY (users_id) REFERENCES users(users_id)
);

CREATE TABLE subproject (
                            subproject_id INT PRIMARY KEY AUTO_INCREMENT,
                            project_id INT,
                            name VARCHAR(255),
                            status VARCHAR(255),
                            start_date INT,
                            end_date INT,
                            FOREIGN KEY (project_id) REFERENCES project(project_id)
);

CREATE TABLE task (
                      task_id INT PRIMARY KEY AUTO_INCREMENT,
                      subproject_id INT,
                      name VARCHAR(255),
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id)
);