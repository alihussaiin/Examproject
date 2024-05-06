package com.example.examproject.service;
import com.example.examproject.model.User;
import org.springframework.stereotype.Service;
import com.example.examproject.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.registerUser(user);
    }

}
