package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class IndexControl {
    private final PostService posts;
    private final UserService users;

    public IndexControl(PostService posts, UserService users) {
        this.posts = posts;
        this.users = users;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.getPosts());
        model.addAttribute("user", users.getCurrentUser());
        return "index";
    }
}