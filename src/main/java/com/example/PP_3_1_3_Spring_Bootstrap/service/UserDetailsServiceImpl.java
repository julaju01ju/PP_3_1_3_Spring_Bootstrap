package com.example.PP_3_1_3_Spring_Bootstrap.service;

import com.example.PP_3_1_3_Spring_Bootstrap.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this. userDao =  userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.getByLogin(s);
    }
}
