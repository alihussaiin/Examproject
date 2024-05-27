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
                      status VARCHAR(255),
                      priority VARCHAR(255),
                      FOREIGN KEY (subproject_id) REFERENCES subproject(subproject_id)
);

INSERT INTO project (id, users_id, name, description, status, start_date, end_date) VALUES
                                                                                        (1, null, 'projekt 1','final', 'igang', '2024-05-15', '2024-05-25'),
                                                                                        (2, null, 'projekt 2','robotics','igang','2024-05-20', '2024-05-25'),
                                                                                        (3, null, 'projekt 3','game development', 'igang', '2024-05-05', '2024-05-30'),
                                                                                        (4, null, 'projekt 4','fullstack', 'igang', '2024-05-01', '2024-05-31'),
                                                                                        (5, null, 'projekt 5','security', 'igang', '2024-05-01', '2024-05-25');
