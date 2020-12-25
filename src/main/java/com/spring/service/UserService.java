package com.spring.service;

import com.spring.dto.RegisterUserDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo ur;

    public Collection<User> getAllUsers() {
        return ur.getAllUsers();
    }

    public boolean insertNewUser(User newUser) {
        ur.insertNewUser(newUser);
        //todo validate (perhaps inserting failed) and return false if something went wrong
        return true;
    }

    @Transactional
    public User updateUser(User user) {
        User updatedUser = ur.updateUser(user);

        Utils.setLoggedUser(updatedUser);

        return updatedUser;
    }
}
