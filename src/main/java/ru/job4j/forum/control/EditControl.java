package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class EditControl {
    private final PostService posts;

    public EditControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam int id, Model model) {
        Post post = posts.getPost(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/editSave")
    public String editSave(@RequestParam int id, @RequestParam String name,
                           @RequestParam String description) {
        Post post = posts.getPost(id);
        post.setName(name);
        post.setDescription(description);
        posts.saveOrUpdate(post);
        return "redirect:/index";
    }
}