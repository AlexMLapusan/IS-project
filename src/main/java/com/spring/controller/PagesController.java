package com.spring.controller;

import com.spring.entity.Route;
import com.spring.entity.User;
import com.spring.service.RouteService;
import com.spring.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

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

    @RequestMapping("/user_account")
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
    public String buy(ModelMap modelMap) {
        Collection<Route> routes = Utils.getRoutes();
        modelMap.addAttribute("routes", routes);
        return "buy";
    }

    @RequestMapping("/home_admin")
    public String homeForAdmin(){ return "home_admin"; }

    @RequestMapping("/routes")
    public String routes(ModelMap modelMap){
        return "routes";
    }

    //admin page to manage users
    @RequestMapping("/manage_users")
    public String manageUserAccounts(){
        return "manage_users";
    }

    @RequestMapping("/manage_stations")
    public String manageStations(){
        return "manage_stations";
    }

}
