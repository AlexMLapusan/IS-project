package com.spring.controller;

import com.spring.entity.Admin;
import com.spring.entity.User;
import com.spring.service.AdminService;
import com.spring.service.UserService;
import com.spring.utils.MailSender;
import com.spring.utils.ResponseHandler;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("req/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseHandler updateUser(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @RequestMapping(path = "/send-reset-email", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler resetPassword(@RequestBody String data) {
        JSONObject jo = new JSONObject(data);
        String email = (String) jo.get("email");
        String password = (String) jo.get("password");
        String passwordEncrypted = (String) jo.get("passwordEncrypted");
        String token = adminService.getAdminPassword(email);
        String msg =" Click the link for reset your password! Your new password will be: " + password
                + "     http://localhost:8080/req/admin/reset-password?email=" + email + "&token=" +token + "&pas=" +passwordEncrypted;
        MailSender.sendEmail(email,"PublicTransport account reset password", msg);
        return new ResponseHandler("OK", jo.get("email"));
    }

    @RequestMapping(path = "/reset-password", method = RequestMethod.GET)
    @ResponseBody
    public String confirm(@RequestParam(name = "email") String email, @RequestParam(name = "token") String token, @RequestParam(name = "pas") String pas) {
        adminService.resetPassword(email,token,pas);
        return "<script > window.location.replace(window.location.origin + \"/login\"); </script>";
    }
}
