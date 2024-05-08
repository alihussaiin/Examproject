package com.example.examproject.repository;

import com.example.examproject.model.User;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("Kwc52vap2qc#")
    private String dbPassword;


    public User registerUser(User user) {
        try (Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String SQL = "INSERT INTO users (ID, FIRST_NAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                ps.setInt(1, user.getid());
                ps.setString(2, user.getFirstname());
                ps.setString(3, user.getUsername());
                ps.setInt(4, user.getPassword()); // Sætter ID-værdien

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    //TODO refactor if time
    public User findById(int id) {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                } else {
                    return null; // Return null if the user does not exist
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Print or log the exception
            throw new RuntimeException("Failed to retrieve user by ID", e);
        }
    }


    public User findByUsername(String username) {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                } else {
                    return null; // Return null if the user does not exist
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Print or log the exception
            throw new RuntimeException("Failed to retrieve user by username", e);
        }
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("first_name"),
                rs.getString("username"),
                rs.getInt("password"), // Assuming password is a String, adjust accordingly
                rs.getInt("ID")
        );
    }

}
