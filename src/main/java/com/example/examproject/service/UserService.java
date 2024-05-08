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

    public  User findbyId(int id) {
        return userRepository.findById(id);
    }

    public User findbyUsername(String username) {
        return userRepository.findByUsername(username);
        
    }

   public User loginUser(String username, int password) {
        // find user i db
        User userFromDb = userRepository.findByUsername(username);

       // sammenlign password fra db mod password fra form
       if (userFromDb != null) {
           if (userFromDb.getPassword().equals(password)) {
               return userFromDb;
           }
       }
       return null;
   }
}


