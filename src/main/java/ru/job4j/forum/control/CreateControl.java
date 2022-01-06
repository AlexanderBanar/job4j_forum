package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class CreateControl {
    private final PostService posts;

    public CreateControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/create")
    public String createPage() {
        return "create";
    }

    @PostMapping("/createSave")
    public String createSave(@RequestParam String name, @RequestParam String description) {
        posts.saveOrUpdate(Post.of(name, description));
        return "redirect:/index";
    }
}