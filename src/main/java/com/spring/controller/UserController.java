package com.spring.controller;

import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.service.UserService;

import java.util.ArrayList;
import java.util.Collection;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public User attemptLogin(@RequestParam(defaultValue = "empty") String email, @RequestParam(defaultValue = "empty") String password) {
        return userService.attemptLogin(email, password);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> getAllStudents() {
        return userService.getAllUsers();
    }
}
