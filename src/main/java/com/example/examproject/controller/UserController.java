package com.example.examproject.controller;

import com.example.examproject.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.examproject.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    private User user;

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) { //KLAR
        model.addAttribute("userObject", new User());
        return "register";
    }

    @PostMapping("/users/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, HttpSession session, Model model) {
        User validatedUser = userService.findbyUsername(user.getUsername());
        session.setAttribute("loggedInUser", validatedUser);
        if (validatedUser != null && validatedUser.getPassword().equals(user.getPassword())) {
            session.setMaxInactiveInterval(1800); //slet denne linje hvis koden fejler
            return "redirect:/projects";
        }
        else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logud")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}

