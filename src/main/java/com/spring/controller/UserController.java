package com.spring.controller;

import com.spring.dto.RegisterUserDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.*;
import com.spring.service.UserService;

import java.util.Collection;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("req/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public Boolean deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
