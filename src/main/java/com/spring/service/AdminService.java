package com.spring.service;

import com.spring.entity.Admin;
import com.spring.entity.User;
import com.spring.repository.AdminRepo;
import com.spring.repository.UserRepo;
import com.spring.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public ResponseHandler insertNewAdmin(Admin newUser) {

        if(adminRepo.checkIfEmailExist(newUser.getEmail()))
        {
            return new ResponseHandler("ERR", "email");
        }
        else{
            adminRepo.insertNewAdmin(newUser);
            return new ResponseHandler("OK", "");
        }
    }
}
