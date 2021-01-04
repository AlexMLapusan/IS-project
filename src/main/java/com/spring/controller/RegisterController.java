package com.spring.controller;


import com.spring.dto.LoginDTO;
import com.spring.dto.RegisterAdminDTO;

import com.spring.dto.RegisterUserDTO;
import com.spring.entity.Admin;
import com.spring.entity.User;
import com.spring.mappers.AdminMapper;
import com.spring.mappers.UserMapper;
import com.spring.service.AdminService;
import com.spring.service.AuthenticationService;

import com.spring.service.UserService;
import com.spring.utils.MailSender;
import com.spring.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("req/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;
//    @RequestMapping(path = "/test", method = RequestMethod.POST)
//    public User attemptLogin(@RequestBody User user) {
//        return user;
//    }

    @RequestMapping(path = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler registerUser(@RequestBody RegisterUserDTO newUserDTO) {
        //objectKey will contain the email and password
        User newUser = UserMapper.registerUserDTOToEntity(newUserDTO);
        ResponseHandler r = userService.insertNewUser(newUser);
        if (!r.getStatus().equals("OK")) {
            return r;
        }
        String msg = newUser.getFirstName() + " please confirm your account "
                + "http://localhost:8080/req/register/confirm?token=" + newUser.getPassword()
                + "&email=" + newUser.getEmail();
        MailSender.sendEmail(newUser.getEmail(),"PublicTransport account confirmation", msg);
        return new ResponseHandler("OK", "");
    }

    @RequestMapping(path = "/confirm", method = RequestMethod.GET)
    @ResponseBody
    public String confirm(@RequestParam(name = "token") String token, @RequestParam(name = "email") String email) {
        userService.confirmAccount(email,token);
        return "<script > window.location.replace(window.location.origin + \"/login\"); </script>";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler registerAdmin(@RequestBody RegisterAdminDTO newAdminDTO) {
        //objectKey will contain the email and password
        Admin newAdmin = AdminMapper.registerUserDTOToEntity(newAdminDTO);
        ResponseHandler r = adminService.insertNewAdmin(newAdmin);
        if (!r.getStatus().equals("OK")) {
            return r;
        }
        String msg =  " Please confirm your account "
                + "http://localhost:8080/req/register/confirm?token=" + newAdmin.getPassword()
                + "&email=" + newAdmin.getEmail();
        MailSender.sendEmail(newAdmin.getEmail(),"PublicTransport account confirmation", msg);
        return new ResponseHandler("OK", "");
    }

}
