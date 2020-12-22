package com.spring.controller;

import com.spring.entity.User;
import com.spring.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/home_user")
    public String home() {
        User loggedUser = Utils.getLoggedUser();
        if (loggedUser == null) {
            return "login";
        }
        return "home_user";
    }

    @RequestMapping("/user_account ")
    public String myAccount(ModelMap modelMap) {
        User loggedUser = Utils.getLoggedUser();

        if (loggedUser == null) {
            return "login";
        }
        modelMap.addAttribute("loggedUser", loggedUser);
        return "user_account";
    }

    @RequestMapping("/login")
    public String login() {
        Utils.setLoggedUser(null);
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        Utils.setLoggedUser(null);
        return "register";
    }

    @RequestMapping("/buy")
    public String buy() { return "buy"; }

    @RequestMapping("/home_admin")
    public String homeForAdmin(){ return "home_admin"; }



}
