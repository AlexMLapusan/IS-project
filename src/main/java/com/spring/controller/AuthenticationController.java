package com.spring.controller;


import com.spring.dto.LoginDTO;
import com.spring.entity.User;
import com.spring.service.AuthenticationService;
import com.spring.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/req/login")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

//    @RequestMapping(path = "/test", method = RequestMethod.POST)
//    public User attemptLogin(@RequestBody User user) {
//        return user;
//    }

    @RequestMapping(path = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler attemptLogin(@RequestBody LoginDTO credentials) {
        //objectKey will contain the email and password
        return authenticationService.attemptLogin(credentials.getEmail(), credentials.getPassword());
    }

}
