package com.example.backEndProject.controller;

import com.example.backEndProject.model.User;
import com.example.backEndProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

//    Mapping Methods

    @GetMapping("/list_all_users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users_postgres")
    public String listAll(Model model) {
        List<User> listUsers = userService.getAll();
        model.addAttribute("listUsers", listUsers);

        return "students";
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }



}
