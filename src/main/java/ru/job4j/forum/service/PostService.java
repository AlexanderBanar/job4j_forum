package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private int counter = 1;

    public PostService() {
        Post initPost = Post.of("Олег", "Продаю машину ладу 01.");
        int id = counter++;
        initPost.setId(id);
        posts.put(id, initPost);
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }

    public void add(Post post) {
        int id = counter++;
        post.setId(id);
        posts.put(id, post);
    }

    public Post getPost(int id) {
        return posts.get(id);
    }

    public void update(int id, Post post) {
        posts.put(id, post);
    }
}