package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {
    private final UserService users;

    public RegControl(UserService users) {
        this.users = users;
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }

    @PostMapping("/reg")
    public String regSave(@RequestParam String username, @RequestParam String password,
                          Model model) {
        if (users.isRegistered(username)) {
            String errorMessage = "user with this username is already registered";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        } else {
            users.add(username, password);
        }
        return "redirect:/login";
    }
}