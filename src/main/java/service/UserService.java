package service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {

    @GetMapping("/register")
    public String registerAccount() {
        return "user/doregister";
    }
}
