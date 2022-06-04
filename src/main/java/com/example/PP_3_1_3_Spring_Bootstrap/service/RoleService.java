package com.example.PP_3_1_3_Spring_Bootstrap.service;

import com.example.PP_3_1_3_Spring_Bootstrap.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role findById(Long id);

    void saveRole(Role role);
}