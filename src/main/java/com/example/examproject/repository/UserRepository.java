package com.example.examproject.repository;

import com.example.examproject.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.example.examproject.util.ConnectionManager;

import java.sql.*;


@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("Kwc52vap2qc#")
    private String password;


    public User registerUser(User user) {
        try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password)) {
            String SQL = "INSERT INTO users (ID, FIRST_NAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                ps.setInt(1, user.getid());
                ps.setString(2, user.getFirstname());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getPassword()); // Sætter ID-værdien

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User findById(int id) {
            try (Connection con = DriverManager.getConnection(dbUrl, username, password)) {
                String sql = "SELECT * FROM users WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setInt(1, id);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            return new User(
                                    rs.getString("FIRSTNAME"),
                                    rs.getString("USERNAME"),
                                    rs.getString("PASSWORD"),
                                    rs.getInt("ID")
                            );
                        }
                    }
                }
                return null;   // Returner null, hvis brugeren ikke findes
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

