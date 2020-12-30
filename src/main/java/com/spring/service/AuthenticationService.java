package com.spring.service;

import com.spring.dto.LoginDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepo;
import com.spring.utils.ResponseHandler;
import com.spring.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    public ResponseHandler attemptLogin(String email, String password) {
        if(userRepo.checkIfEmailExist(email))
        {
            User loggedUser = userRepo.findUserByEmailAndPass(email, password);
            if(loggedUser == null)
            {
                return new ResponseHandler("ERR", "password");
            }
            else {
                if(loggedUser.isConfirmed())
                {
                    return new ResponseHandler("OK", loggedUser);
                }
                else
                {
                    return new ResponseHandler("ERR", "confirm");
                }
            }
        }
        else
        {
            return new ResponseHandler("ERR", "email");
        }
    }

}
