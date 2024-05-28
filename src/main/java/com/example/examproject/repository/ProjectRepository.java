package com.example.examproject.repository;

import com.example.examproject.model.Project;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

    @Repository
    public class ProjectRepository {


        @Value("jdbc:mysql://localhost:3306/projectmanager_db")
        private String dbUrl;

        @Value("root")
        private String dbUsername;

        @Value("Kwc52vap2qc#")
        private String dbPassword;

        public Project createProject(Project project) {
            System.out.println(project.getUsers_id());
            Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "INSERT INTO project (users_id, name, description, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";//de skal være de samme som de er kaldt inde i

            try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                ps.setInt(1, project.getUsers_id());
                ps.setString(2, project.getName());
                ps.setString(3, project.getDescription());
                ps.setString(4, project.getStatus());
                ps.setDate(5, Date.valueOf(project.getStartDate()));
                ps.setDate(6, Date.valueOf(project.getEndDate()));

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Oprettelse af projekt mislykkedes ingen, rækker påvirket.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return project;
        }


        public ArrayList<Project> getAllProjects(int userId) {
           Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            ArrayList<Project> projects = new ArrayList<>();
            String SQL = "SELECT * FROM project where users_id = ?";

            ResultSet resultSet = null;

            try {PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, userId);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Project project = new Project();
                    project.setId(resultSet.getInt("ID"));
                    project.setUsers_id(resultSet.getInt("USERS_ID"));
                    project.setName(resultSet.getString("NAME"));
                    project.setDescription(resultSet.getString("DESCRIPTION"));
                    project.setStatus(resultSet.getString("STATUS"));
                    project.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
                    project.setEndDate(resultSet.getDate("END_DATE").toLocalDate());
                    projects.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Fejl ved hentning af projekter fra databasen", e);
            }

            return projects;
        }


        public Project updateProject(Project project) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
                String SQL = "UPDATE project SET NAME=?, DESCRIPTION=?, STATUS=?, START_DATE=?, END_DATE=? WHERE ID=?";
                ps = conn.prepareStatement(SQL);

                ps.setString(1, project.getName());
                ps.setString(2, project.getDescription());
                ps.setString(3, project.getStatus());
                ps.setDate(4, Date.valueOf(project.getStartDate()));
                ps.setDate(5, Date.valueOf(project.getEndDate()));
                ps.setInt(6, project.getId());  // ID skal bruges i WHERE-betingelsen

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Updating project failed, no rows affected.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return project;
        }



        public void deleteProject(int projectId) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
                String SQL = "DELETE FROM project WHERE ID=?";
                ps = conn.prepareStatement(SQL);
                ps.setInt(1, projectId);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Deleting project failed, no rows affected.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public Project getProjectById(int projectId) {
            Project project = null;
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            try {
                conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
                String SQL = "SELECT * FROM project WHERE ID=?";
                ps = conn.prepareStatement(SQL);
                ps.setInt(1, projectId);
                resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    project = new Project();
                    project.setId(resultSet.getInt("ID"));
                    project.setUsers_id(resultSet.getInt("USERS_ID"));
                    project.setName(resultSet.getString("NAME"));
                    project.setDescription(resultSet.getString("DESCRIPTION"));
                    project.setStatus(resultSet.getString("STATUS"));
                    project.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
                    project.setEndDate(resultSet.getDate("END_DATE").toLocalDate());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return project;
        }

    }



