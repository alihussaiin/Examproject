package com.example.examproject;

import com.example.examproject.model.User;
import com.example.examproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

   /* @Test
    void testRegisterUser() {
        User newUser = new User();
        newUser.setid(4);
        newUser.setFirstname("leoj");
        newUser.setUsername("leoj123");
        newUser.setPassword("password1");

        User registeredUser = userRepository.registerUser(newUser);

        assertNotNull(registeredUser);
        assertEquals(newUser.getid(), registeredUser.getid());
        assertEquals(newUser.getFirstname(), registeredUser.getFirstname());
        assertEquals(newUser.getUsername(), registeredUser.getUsername());
        assertEquals(newUser.getPassword(), registeredUser.getPassword());
    }

    @Test
    void testFindById() {
        int userId = 1;
        User foundUser = userRepository.findById(userId);
        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getid());

    }

    @Test
    void testFindByUsername() {
        String username = "joel123"; // Assuming this username exists in your test data

        User foundUser = userRepository.findByUsername(username);

        assertNotNull(foundUser);
        assertEquals(username, foundUser.getUsername());
    }*/
}