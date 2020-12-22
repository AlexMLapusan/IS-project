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

    public Collection<User> getAllUsers(){
        return ur.getAllUsers();
    }

    public boolean insertNewUser(User newUser){
        ur.insertNewUser(newUser);
        //todo validate (perhaps inserting failed) and return false if something went wrong
        return true;
    }
}
