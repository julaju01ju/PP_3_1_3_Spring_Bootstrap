package com.example.PP_3_1_3_Spring_Bootstrap.controller;

import com.example.PP_3_1_3_Spring_Bootstrap.model.User;
import com.example.PP_3_1_3_Spring_Bootstrap.service.RoleService;
import com.example.PP_3_1_3_Spring_Bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String getCurrentUserInfo(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        User thisUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("newUser", new User());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update")
    public String updateUser(@ModelAttribute("newUser") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
