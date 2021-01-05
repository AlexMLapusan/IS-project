package com.spring;


import com.spring.entity.Admin;
import com.spring.entity.Route;
import com.spring.entity.Station;
import com.spring.entity.User;
import com.spring.repository.AdminRepo;
import com.spring.repository.RouteRepo;
import com.spring.repository.StationRepo;
import com.spring.repository.UserRepo;
import com.spring.utils.MailSender;
import com.spring.utils.Utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Main {

//    public static void main(String[] args) throws IOException {
//        RouteRepo rr = new RouteRepo();
//
//        Route rt = rr.findRoute("67c7c4cb-9720-4215-8b86-95439c68ca33");
//        rt.setStartingHour("07:00");
//        rt.setRouteInterval(69);;
//
//    }

    public static void main(String[] args) {
        /*Admin u = new Admin();
        u.setId(UUID.randomUUID().toString());
        u.setEmail("cristian.berengea@gmail.com");
        u.setPassword("202cb962ac59075b964b07152d234b70");
        u.setConfirmed(true);

        AdminRepo ur = new AdminRepo();

        ur.insertNewAdmin(u);*/



        //MailSender m = new MailSender();
        //m.senddEmail();
        //String to = "cristian.berengea@gmail.com";
        //MailSender.sendEmail(to,"subject","ZZZZZZZZZZZZZZZZZZZZZZZZz");

//        PriceTableRepo tp = new PriceTableRepo();
//        PriceTable pt = new PriceTable();
//        pt.setId(UUID.randomUUID().toString());
//        pt.setType(PriceTable.Type._1_ROUTE_SUBSCRIPTION);
//        pt.setPrice(30);
//
//        tp.insertNewPrice(pt);
        SpringApplication.run(Main.class, args);
    }
}
