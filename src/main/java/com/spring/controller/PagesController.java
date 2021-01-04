package com.spring.controller;

import com.spring.entity.Route;
import com.spring.entity.Station;
import com.spring.repository.StationRepo;
import com.spring.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class PagesController {

    @RequestMapping("/home_user")
    public String home() {
        //User loggedUser = Utils.getLoggedUser();
        //if (loggedUser == null) {
        //    return "login";
        //}
        return "home_user";
    }

    @RequestMapping("/user_account")
    public String myAccount() {
        //public String myAccount(ModelMap modelMap) {
        //User loggedUser = Utils.getLoggedUser();

        //if (loggedUser == null) {
        //    return "login";
        //}
        //modelMap.addAttribute("loggedUser", loggedUser);
        return "user_account";
    }

    @RequestMapping("/login")
    public String login() {
        //Utils.setLoggedUser(null);
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        //Utils.setLoggedUser(null);
        return "register";
    }

    @RequestMapping("/buy")
    public String buy(ModelMap modelMap) {
        //todo schimba luarea rutelor folosind utils cu instantiere de RouteService sau repo sau ceva
        Collection<Route> routes = Utils.getRoutes();
        modelMap.addAttribute("routes", routes);
        return "buy";
    }

    @RequestMapping("/home_admin")
    public String homeForAdmin(){ return "home_admin"; }

    @RequestMapping("/routes")
    public String routes(ModelMap modelMap){
        modelMap.addAttribute("routes", Utils.getRoutes());
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

    @RequestMapping("/manage_routes")
    public String manageRoutes(ModelMap modelMap){
        StationRepo stationRepo= new StationRepo();

        Collection<Station> stations = stationRepo.getAllStations();
        modelMap.addAttribute("stations", stations);

        return "manage_routes";
    }
    @RequestMapping("/admin_register")
    public String adminRegister(){return "admin_register";}

    @RequestMapping("/admin_account")
    public String adminAccount(){return "/admin_account";}

    @RequestMapping("/transactions")
    public String getAllTransactions(){return "/transactions";}

    @RequestMapping("/manage_prices")
    public String managePrices(){return "/manage_prices";}
}
