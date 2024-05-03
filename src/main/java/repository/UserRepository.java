package repository;
import model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    public User registerUser(User newUser) {
        try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password)) {
            String SQL = "INSERT INTO users (FIRSTNAME, USERNAME, PASSWORD, ID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                ps.setString(1, newUser.getFirstname());
                ps.setString(2, newUser.getUsername());
                ps.setString(3, newUser.getPassword());
                ps.setInt(4, newUser.getid()); // Sætter ID-værdien
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newUser;
    }
}
