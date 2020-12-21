package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/home")
    public String home(){ return "pageForUser"; }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/register")
    public String register() { return "createAccount"; }
    @RequestMapping("/buyTickets")
    public String buy() { return "buy"; }
    @RequestMapping("/myAccount")
    public String myAccount() {return "myAccount";}
    @RequestMapping("/homeAdmin")
    public String homeForAdmin(){ return "pageForAdmin"; }



}
