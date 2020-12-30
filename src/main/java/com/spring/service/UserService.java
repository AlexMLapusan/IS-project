package com.spring.service;

import com.spring.dto.RegisterUserDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.utils.ResponseHandler;
import com.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Collection<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public ResponseHandler insertNewUser(User newUser) {
        //todo validate (perhaps inserting failed) and return false if something went wrong

        if(userRepo.checkIfEmailExist(newUser.getEmail()))
        {
            return new ResponseHandler("ERR", "email");
        }
        else{
            userRepo.insertNewUser(newUser);
            return new ResponseHandler("OK", "");
        }
    }

    @Transactional
    public ResponseHandler updateUser(User user) {
        if(userRepo.checkEmailExistForAnotherId(user.getEmail(),user.getId()))
        {
            return new ResponseHandler("ERR", "email");
        }
        else
        {
            User updatedUser = userRepo.updateUser(user);
            return new ResponseHandler("OK", "");
        }

    }

    @Transactional
    public Boolean deleteUser(String userId) {
        Boolean allGood = userRepo.deleteUser(userId);

        return allGood ;
    }

    @Transactional
    public ResponseHandler confirmAccount(String email, String password)
    {
        User user = userRepo.findUserByEmailAndPass(email, password);
        if(user != null)
        {
            user.setConfirmed(true);
            userRepo.updateUser(user);
            return new ResponseHandler("OK", "");
        }
        else
        {
            return new ResponseHandler("ERR", "");
        }
    }

    public ResponseHandler resetPassword(String email, String password, String newPassword)
    {
        User user = userRepo.findUserByEmailAndPass(email, password);
        if(user != null)
        {
            user.setPassword(newPassword);
            userRepo.updateUser(user);
            return new ResponseHandler("OK", "");
        }
        else
        {
            return new ResponseHandler("ERR", "");
        }
    }

    public String getUserPassword(String email) {
        User u = userRepo.findUserByEmail(email);
        if(u!= null)
        {
            return u.getPassword();
        }
        else
        {
            return "";
        }
    }
}
