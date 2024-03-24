package org.example.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User()); // User is a simple POJO with username and password fields
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(SecurityProperties.User user, Model model) {
        // Check if username and password match (dummy check)
        if ("admin".equals(user.getName()) && "password".equals(user.getPassword())) {
            return "redirect:/product/view-section";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Return to login page with error message
        }
    }
}
