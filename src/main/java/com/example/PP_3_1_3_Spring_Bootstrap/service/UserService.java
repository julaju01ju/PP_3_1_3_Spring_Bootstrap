package com.example.PP_3_1_3_Spring_Bootstrap.service;

import com.example.PP_3_1_3_Spring_Bootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getById(Long id);

    User getByLogin(String email);

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);
}
