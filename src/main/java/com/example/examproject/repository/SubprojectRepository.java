package com.example.examproject.repository;

import com.example.examproject.model.Subproject;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class SubprojectRepository {

    @Value("jdbc:mysql://localhost:3306/ProjectManager_db")
    private String dbUrl;

    @Value("root")
    private String dbUsername;

    @Value("Dru58tet@")
    private String dbPassword;

    public Subproject createSubproject(Subproject subproject) {
        Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
        String SQL = "INSERT INTO project (subprojectName, description, status, start_date, end_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, subproject.getSubprojectName());
            ps.setString(2, subproject.getDescription());
            ps.setString(3, subproject.getStatus());
            ps.setDate(4, Date.valueOf(subproject.getStartDate()));
            ps.setDate(5, Date.valueOf(subproject.getEndDate()));

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Oprettelse af subprojektet mislykkedes, ingen rækker påvirket.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subproject;
    }

    public ArrayList<Subproject> getAllSubprojects(int projectId) {
        ArrayList<Subproject> subprojects = new ArrayList<>();
        String SQL = "SELECT * FROM subproject WHERE project_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, projectId);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Subproject subproject = new Subproject();
                subproject.setId(resultSet.getInt("ID"));
                subproject.setProjectId(resultSet.getInt("PROJECT_ID"));
                subproject.setSubprojectName(resultSet.getString("SUBPROJECT_NAME"));
                subproject.setDescription(resultSet.getString("DESCRIPTION"));
                subproject.setStatus(resultSet.getString("STATUS"));
                subproject.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
                subproject.setEndDate(resultSet.getDate("END_DATE").toLocalDate());
                subprojects.add(subproject);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Fejl ved hentning af subprojekter fra databasen", e);
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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return subprojects;
    }

    public Subproject updateSubproject(Subproject subproject) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "UPDATE subproject SET subproject_name=?, description=?, status=?, start_date=?, end_date=? WHERE ID=?";
            ps = conn.prepareStatement(SQL);

            ps.setString(1, subproject.getSubprojectName());
            ps.setString(2, subproject.getDescription());
            ps.setString(3, subproject.getStatus());
            ps.setDate(4, Date.valueOf(subproject.getStartDate()));
            ps.setDate(5, Date.valueOf(subproject.getEndDate()));
            ps.setInt(6, subproject.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating subproject failed, no rows affected.");
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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return subproject;
    }

    public void deleteSubproject(int subprojectId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "DELETE FROM subproject WHERE ID=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, subprojectId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deleting subproject failed, no rows affected.");
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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Subproject getSubprojectById(int id) {
        Subproject subproject = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "SELECT * FROM subproject WHERE ID=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                subproject = new Subproject();
                subproject.setId(resultSet.getInt("ID"));
                subproject.setSubprojectName(resultSet.getString("SUBPROJECT_NAME"));
                subproject.setDescription(resultSet.getString("DESCRIPTION"));
                subproject.setStatus(resultSet.getString("STATUS"));
                subproject.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
                subproject.setEndDate(resultSet.getDate("END_DATE").toLocalDate());
                subproject.setProjectId(resultSet.getInt("PROJECT_ID"));
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
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return subproject;
    }
}
