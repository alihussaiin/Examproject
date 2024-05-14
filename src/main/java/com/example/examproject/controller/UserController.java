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
        // Tilføj eventuelle data til model, som skal vises i visningen
        return "index";
    }


        @GetMapping("/register")
    public String showRegistrationForm(Model model) { //KLAR
        model.addAttribute("userObject", new User());
        return "register";
    }

    @PostMapping("/users/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user); // Kalder metoden i UserService for at registrere brugeren
        return "redirect:/login"; // Omdiriger brugeren til login-siden efter registrering
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute User user, HttpSession session, Model model) {
//        // Kontroller, om brugeren findes i databasen
//        User validatedUser = userService.findbyUsername(user.getUsername());
//        session.setAttribute("loggedInUser", validatedUser);
//        System.out.println("validatedUser = " + validatedUser);
//        System.out.println("user = " + user);
//
//        if (validatedUser != null && validatedUser.getPassword().equals(user.getPassword())) {
//            // Brugeren er fundet i databasen og adgangskoden matcher
//            // Gem brugeren i sessionen i 1800 sekunder
//            session.setAttribute("loggedInUser", validatedUser);
//            System.out.println("session " + session.getAttribute("loggedInUserId"));
//            session.setMaxInactiveInterval(1800); // 30 minutter = 1800 serkunder
//            return "redirect:/project_frontpage"; // Omdiriger brugeren til forsiden
//        } else {
//            System.out.println("FEJL");
//            // Brugeren blev ikke fundet i databasen eller adgangskoden er forkert
//            model.addAttribute("error", "Invalid username or password");
//            return "login"; // Tilbage til loginside med fejlmeddelelse
//        }
//    }


    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, WebRequest request, Model model) {
        // Kontroller, om brugeren findes i databasen
        User validatedUser = userService.findbyUsername(user.getUsername());
        request.setAttribute("loggedInUser", validatedUser, WebRequest.SCOPE_SESSION);

        if (validatedUser != null && validatedUser.getPassword().equals(user.getPassword())) {
            // Brugeren er fundet i databasen og adgangskoden matcher
            // Gem brugeren i sessionen i 1800 sekunder
           // session.setAttribute("loggedInUser", validatedUser);
            //System.out.println("session " + session.getAttribute("loggedInUserId"));
            //session.setMaxInactiveInterval(1800); // 30 minutter = 1800 serkunder
            return "redirect:/project_frontpage"; // Omdiriger brugeren til forsiden
        } else {
            // Brugeren blev ikke fundet i databasen eller adgangskoden er forkert
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Tilbage til loginside med fejlmeddelelse
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Udløs sessionen for at logge brugeren ud
        return "redirect:/login"; // Omdiriger brugeren til login-siden
    }



}

