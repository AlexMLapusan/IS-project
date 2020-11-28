package com.spring.controller;


import com.spring.dto.LoginDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepo;
import com.spring.service.AuthenticationService;
import com.spring.service.UserService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

//    @RequestMapping(path = "/test", method = RequestMethod.POST)
//    public User attemptLogin(@RequestBody User user) {
//        return user;
//    }

    @RequestMapping(path = "/test", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User attemptLogin(@RequestBody LoginDTO credentials) {
        //objectKey will contain the email and password
        return authenticationService.attemptLogin(credentials.getEmail(), credentials.getPassword());
    }

}
