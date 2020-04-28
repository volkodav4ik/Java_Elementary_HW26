package com.volkodav4ik.dao;

import com.volkodav4ik.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static UserDao instance;

    private List<User> users = new ArrayList<>();

    public static synchronized UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> getAll() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

}
