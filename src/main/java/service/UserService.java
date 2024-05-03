package service;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
