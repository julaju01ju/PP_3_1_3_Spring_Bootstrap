package com.example.PP_3_1_3_Spring_Bootstrap.service;

import com.example.PP_3_1_3_Spring_Bootstrap.dao.UserDao;
import com.example.PP_3_1_3_Spring_Bootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void UserServiceImp(UserDao userDao, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Iterable< ? extends Long > index = null;
        if (index != null) {
            for (Long id : index) {
                user.addRole(roleService.findById(id));
            }
        } else {
            user.addRole(roleService.findById(2L));
        }
        userDao.save(user);
    }
    @Override
    public void update(User updatedUser) {
        User user = getById(updatedUser.getId());
        if (!user.getPassword().equals(userDao.getById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        Iterable< ? extends Long > index = null;
        if (index != null) {
            for (Long id : index) {
                updatedUser.addRole(roleService.findById(id));
            }
        } else {
            updatedUser.addRole(roleService.findById(2L));
        }
        userDao.update(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByLogin(String email) {
        return userDao.getByLogin(email);
    }
}
