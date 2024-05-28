DROP DATABASE IF EXISTS projectmanager_db_test;
CREATE DATABASE projectmanager_db_test;
USE projectmanager_db_test;

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
-- Insert data into users table
INSERT INTO users (first_name, username, password) VALUES
                                                       ('Joel', 'joel123', 'password1'),
                                                       ('Beran', 'berzan321', 'password2'),
                                                       ('Ali', 'Ali231', 'password3');

-- Insert data into project table
INSERT INTO project (users_id, name, description, status, start_date, end_date) VALUES
                                                                                    (1, 'Project Alpha', 'Description for Project Alpha', 'Ongoing', '2023-01-01', '2023-12-31'),
                                                                                    (2, 'Project Beta', 'Description for Project Beta', 'Completed', '2022-01-01', '2022-12-31'),
                                                                                    (3, 'Project Gamma', 'Description for Project Gamma', 'Planned', '2024-01-01', '2024-12-31');

-- Insert data into subproject table
INSERT INTO subproject (project_id, name, description, status, start_date, end_date) VALUES
                                                                                         (1, 'Subproject A1', 'Description for Subproject A1', 'Afventer', '2023-01-01', '2023-06-30'),
                                                                                         (1, 'Subproject A2', 'Description for Subproject A2', 'Påbegyndt', '2023-07-01', '2023-12-31'),
                                                                                         (2, 'Subproject B1', 'Description for Subproject B1', 'Fuldført', '2022-01-01', '2022-06-30'),
                                                                                         (3, 'Subproject G1', 'Description for Subproject G1', 'Fuldført', '2024-01-01', '2024-06-30');

-- Insert data into task table
INSERT INTO task (subproject_id, description, status, priority, estimated_time) VALUES
                                                                                    (1, 'Task A1-1', 'Påbegyndt','høj', 10),
                                                                                    (1, 'Task A1-2', 'Fuldført', 'høj', 5),
                                                                                    (2, 'Task A2-1', 'Afventer','høj', 8),
                                                                                    (3, 'Task B1-1', 'Fuldført', 'lav', 12),
                                                                                    (4, 'Task G1-1', 'Afventer','mellem', 7);



