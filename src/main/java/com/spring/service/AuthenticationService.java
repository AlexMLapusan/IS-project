package com.spring.service;

import com.spring.dto.LoginDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    public User attemptLogin(String email, String password) {
        return userRepo.findUserByEmailAndPass(email, password);
    }

}
