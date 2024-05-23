package com.example.examproject.repository;

import com.example.examproject.model.Task;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class TaskRepository {

    @Value("jdbc:mysql://localhost:3306/projectmanager_db")
    private String dbUrl;

    @Value("root")
    private String dbUsername;

    @Value("Kwc52vap2qc#")
    private String dbPassword;

    public Task createTask(Task task) {
        Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
        String SQL = "INSERT INTO task (subProject_id, taskName, status, priority) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, task.getSubProject_Id());
            ps.setString(2, task.getDescriptions());
            ps.setString(3, task.getStatus());
            ps.setString(4, task.getPriority());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Oprettelse af opgave mislykkedes, ingen rækker påvirket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public ArrayList<Task> getAllTasks(int subProjectId) {
        ArrayList<Task> tasks = new ArrayList<>();
        String SQL = "SELECT * FROM task WHERE sub_project_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, subProjectId);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("ID"));
                task.setSubProject_Id(resultSet.getInt("SUB_PROJECT_ID"));
                task.setDescriptions(resultSet.getString("TASK_NAME"));
                task.setStatus(resultSet.getString("STATUS"));
                task.setPriority(resultSet.getString("PRIORITY"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Fejl ved hentning af opgaver fra databasen", e);
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

        return tasks;
    }

    public Task updateTask(Task task) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "UPDATE task SET TASK_NAME=?, STATUS=?, PRIORITY=? WHERE ID=?";
            ps = conn.prepareStatement(SQL);

            ps.setString(1, task.getDescriptions());
            ps.setString(2, task.getStatus());
            ps.setString(3, task.getPriority());
            ps.setInt(4, task.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating task failed, no rows affected.");
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
        return task;
    }

    public void deleteTask(int taskId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "DELETE FROM task WHERE ID=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, taskId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deleting task failed, no rows affected.");
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

    public Task getTaskById(int taskId) {
        Task task = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "SELECT * FROM task WHERE ID=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, taskId);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getInt("ID"));
                task.setSubProject_Id(resultSet.getInt("SUB_PROJECT_ID"));
                task.setDescriptions(resultSet.getString("TASK_NAME"));
                task.setStatus(resultSet.getString("STATUS"));
                task.setPriority(resultSet.getString("PRIORITY"));
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
        return task;
    }
}
