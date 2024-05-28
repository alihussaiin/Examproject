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
                       password VARCHAR(25)
);

CREATE TABLE project (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         users_id INT,
                         name VARCHAR(50),
                         description VARCHAR(100),
                         status VARCHAR(25),
                         start_date DATE,
                         end_date DATE,
                         FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE subproject (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            project_id INT,
                            name VARCHAR(50),
                            description VARCHAR (100),
                            status VARCHAR(25),
                            start_date DATE,
                            end_date DATE,
                            FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE
);

CREATE TABLE task (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      subproject_id INT,
                      description VARCHAR (50),
                      status VARCHAR (50),
                      priority VARCHAR (50),
                      estimated_time int,
                      FOREIGN KEY (subproject_id) REFERENCES subproject(id) ON DELETE CASCADE
);

