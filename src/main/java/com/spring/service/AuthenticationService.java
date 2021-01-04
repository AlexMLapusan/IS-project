package com.spring.service;

import com.spring.dto.LoginDTO;
import com.spring.entity.Admin;
import com.spring.entity.User;
import com.spring.repository.AdminRepo;
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
    @Autowired
    private AdminRepo adminRepo;

    public ResponseHandler attemptUserLogin(String email, String password) {
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

    public ResponseHandler attemptAdminLogin(String email, String password) {
        if(adminRepo.checkIfEmailExist(email))
        {
            Admin loggedAdmin = adminRepo.findAdminByEmailAndPass(email, password);
            if(loggedAdmin == null)
            {
                return new ResponseHandler("ERR", "password");
            }
            else {
                if(loggedAdmin.isConfirmed())
                {
                    return new ResponseHandler("OK", loggedAdmin);
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
