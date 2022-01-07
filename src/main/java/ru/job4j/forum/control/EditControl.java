package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

@Controller
public class EditControl {
    private final PostRepository posts;

    public EditControl(PostRepository posts) {
        this.posts = posts;
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam int id, Model model) {
        Post post = posts.findById(id).orElse(Post.of("emptyName", "emptyDesc"));
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/editSave")
    public String editSave(@ModelAttribute Post post) {
        posts.save(post);
        return "redirect:/index";
    }
}