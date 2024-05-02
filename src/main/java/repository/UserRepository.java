package repository;

import org.springframework.web.bind.annotation.GetMapping;

public class UserRepository {

    @GetMapping("/register")
    public String registerAccount() {
        return "user/doregister";
    }
}
