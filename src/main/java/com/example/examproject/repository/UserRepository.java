package com.example.examproject.repository;

import com.example.examproject.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.example.examproject.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("@H0wtomakemoney")
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
}
