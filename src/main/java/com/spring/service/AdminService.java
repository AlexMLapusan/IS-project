package com.spring.service;

import com.spring.entity.Admin;
import com.spring.entity.User;
import com.spring.repository.AdminRepo;
import com.spring.repository.UserRepo;
import com.spring.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Transactional
    public ResponseHandler updateAdmin(Admin admin) {
        if(adminRepo.checkEmailExistForAnotherId(admin.getEmail(),admin.getId()))
        {
            return new ResponseHandler("ERR", "email");
        }
        else
        {
            Admin updatedUser = adminRepo.updateAdmin(admin);
            return new ResponseHandler("OK", "");
        }

    }

    @Transactional
    public ResponseHandler confirmAccount(String email, String password)
    {
        Admin admin = adminRepo.findAdminByEmailAndPass(email, password);
        if(admin != null)
        {
            admin.setConfirmed(true);
            adminRepo.updateAdmin(admin);
            return new ResponseHandler("OK", "");
        }
        else
        {
            return new ResponseHandler("ERR", "");
        }
    }

    public ResponseHandler resetPassword(String email, String password, String newPassword)
    {
        Admin admin = adminRepo.findAdminByEmailAndPass(email, password);
        if(admin != null)
        {
            admin.setPassword(newPassword);
            adminRepo.updateAdmin(admin);
            return new ResponseHandler("OK", "");
        }
        else
        {
            return new ResponseHandler("ERR", "");
        }
    }

    public String getAdminPassword(String email) {
        Admin u = adminRepo.findAdminByEmail(email);
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
