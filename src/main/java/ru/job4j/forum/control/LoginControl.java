package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class LoginControl {
    private final UserService users;

    public LoginControl(UserService users) {
        this.users = users;
    }

    @GetMapping("/login")
    public String regPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        User user = users.savedUser(username, password);
        if (user != null) {
            users.setCurrentUserId(user.getId());
            return "redirect:/index";
        } else {
            String errorMessage = "username or password is incorrect";
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logoutPage() {
        users.setCurrentUserId(1);
        return "login";
    }
}