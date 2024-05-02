package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
@RequestMapping(path = "")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String home() {
        // Tilføj eventuelle data til model, som skal vises i visningen
        return "index";
    }



    @GetMapping("/register")
    public String registerAccount() {
        return "user/doregister";
    }
}
