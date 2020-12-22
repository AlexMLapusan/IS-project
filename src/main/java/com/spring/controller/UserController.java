package com.spring.controller;

import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.service.UserService;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("req/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> getAllStudents() {
        return userService.getAllUsers();
    }
}
