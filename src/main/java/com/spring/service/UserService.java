package com.spring.service;

import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.repository.UserRepo;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepo ur;

    public User attemptLogin(String email, String password) {
        UserRepo ur = new UserRepo();
//        return userDTO.loginWithEmailAndPass(email, password);
        return ur.findUserByEmailAndPass("geo@gmail.com", "pass");
    }

    public Collection<User> getAllUsers(){
        return ur.getAllUsers();
    }
}
