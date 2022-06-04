package com.example.PP_3_1_3_Spring_Bootstrap.dao;

import com.example.PP_3_1_3_Spring_Bootstrap.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    Role findById(Long id);

    void saveRole(Role role);
}