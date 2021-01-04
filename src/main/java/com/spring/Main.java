package com.spring;

import com.spring.entity.PriceTable;
import com.spring.repository.PriceTableRepo;
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
        /*User u = new User(UUID.randomUUID().toString(),"Mihai","Ionel");
        u.setEmail("mihai@gmail.com");
        u.setPassword("123");

        UserRepo ur = new UserRepo();

        ur.insertNewUser(u);
        */

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
