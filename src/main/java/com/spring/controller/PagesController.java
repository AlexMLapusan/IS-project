package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/home")
    public String home(){ return "home_user"; }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/register")
    public String register() { return "register"; }

    @RequestMapping("/buy")
    public String buy() { return "buy"; }
    @RequestMapping("/user_account ")
    public String user_account() {return "user_account";}
    @RequestMapping("/home_admin")
    public String homeForAdmin(){ return "home_admin"; }



}
