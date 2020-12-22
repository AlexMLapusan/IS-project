package com.spring.controller;


import com.spring.dto.LoginDTO;
import com.spring.dto.RegisterUserDTO;
import com.spring.entity.User;
import com.spring.mappers.UserMapper;
import com.spring.service.AuthenticationService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;
//    @RequestMapping(path = "/test", method = RequestMethod.POST)
//    public User attemptLogin(@RequestBody User user) {
//        return user;
//    }

    @RequestMapping(path = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User registerUser(@RequestBody RegisterUserDTO newUserDTO) {
        //objectKey will contain the email and password
        User newUser = UserMapper.registerUserDTOToEntity(newUserDTO);
        if (!userService.insertNewUser(newUser)) {
            return null;
        }
        return newUser;
    }

}
