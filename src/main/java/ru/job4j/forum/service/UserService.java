package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> users = new HashMap();
    private int counter = 1;
    private int currentUserId = 1;

    public UserService() {
        int id = counter++;
        User firstUser = User.of("user", "pass");
        firstUser.setId(id);
        users.put(id, firstUser);
    }

    public List<User> getUsers() {
        return (List<User>) users.values();
    }

    public void add(String username, String password) {
        int id = counter++;
        User user = User.of(username, password);
        user.setId(id);
        users.put(id, user);
    }

    public User getCurrentUser() {
        return users.get(currentUserId);
    }

    public void setCurrentUserId(int id) {
        currentUserId = id;
    }

    public User savedUser(String username, String password) {
        User resultUser = null;
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    resultUser = user;
                }
            }
        }
        return resultUser;
    }

    public boolean isRegistered(String username) {
        boolean result = false;
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                result = true;
            }
        }
        return result;
    }
}