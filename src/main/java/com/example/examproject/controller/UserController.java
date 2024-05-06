package com.example.examproject.controller;

import com.example.examproject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.examproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;


    }

    private User user;

    @GetMapping("/")
    public String home() {
        // Tilføj eventuelle data til model, som skal vises i visningen
        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) { //KLAR
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Model model, User user) {
        /*model.addAttribute("user", userService.registerUser(user));*/
        userService.registerUser(user); // Kalder metoden i UserService for at registrere brugeren
        return "redirect:/login"; // Omdiriger brugeren til login-siden efter registrering
    }

}
