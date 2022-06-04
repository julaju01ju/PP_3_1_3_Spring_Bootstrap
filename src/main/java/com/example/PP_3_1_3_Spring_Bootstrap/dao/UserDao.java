package com.example.PP_3_1_3_Spring_Bootstrap.dao;

import com.example.PP_3_1_3_Spring_Bootstrap.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getById(Long id);

    User getByLogin(String email);

    void update(User updateUser);

    void save(User user);

    void delete(Long id);
}
