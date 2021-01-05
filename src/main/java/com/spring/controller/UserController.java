package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.entity.User;
import com.spring.service.UserService;
import com.spring.utils.MailSender;
import com.spring.utils.ResponseHandler;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("req/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseHandler updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public Boolean deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }

    @RequestMapping(path = "/send-reset-email", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler resetPassword(@RequestBody String data) {
        JSONObject jo = new JSONObject(data);
        String email = (String) jo.get("email");
        String password = (String) jo.get("password");
        String passwordEncrypted = (String) jo.get("passwordEncrypted");
        String token = userService.getUserPassword(email);
        String msg =" Click the link for reset your password! Your new password will be: " + password
                + "     http://localhost:8080/req/user/reset-password?email=" + email + "&token=" +token + "&pas=" +passwordEncrypted;
        MailSender.sendEmail(email,"PublicTransport account reset password", msg);
        return new ResponseHandler("OK", jo.get("email"));
    }

    @RequestMapping(path = "/reset-password", method = RequestMethod.GET)
    @ResponseBody
    public String confirm(@RequestParam(name = "email") String email, @RequestParam(name = "token") String token, @RequestParam(name = "pas") String pas) {
        userService.resetPassword(email,token,pas);
        return "<script > window.location.replace(window.location.origin + \"/login\"); </script>";
    }

    @RequestMapping(value = "/use-ticket", method = RequestMethod.PUT)
    public User useTicket(@RequestBody IdUniversalDTO userId) {
        return userService.useTicket(userId.getId());
    }
}
