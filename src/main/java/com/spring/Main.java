package com.spring;

import com.spring.entity.Route;
import com.spring.entity.Station;
import com.spring.entity.User;
import com.spring.repository.RouteRepo;
import com.spring.repository.StationRepo;
import com.spring.repository.UserRepo;
import com.spring.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
public class Main {

//        public static void main(String[] args) throws IOException {
//        UserRepo ur = new UserRepo();
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setFirstName("Zara");
//        user.setLastName("Popa");
//        user.setEmail("zaat@gmail.com");
//        user.setPassword("aad");
//        user.setAddress("Bucuresti");
//        user.setConfirmed(true);
//        user.setPhoneNumber("08765434567");
//        user.setImage("https://hot969boston.com/wp-content/uploads/sites/20/2020/08/whatever.png");
//        ur.insertNewUser(user);
//        System.out.println(ur.getAllUsers());
//            StationRepo sr = new StationRepo();
//            Station st1 = new Station();
//            st1.setId(UUID.randomUUID().toString());
//            st1.setAddress("Calea Turzii");
//            st1.setName("Zoltan");
//
//            Station st2 = new Station();
//            st2.setId(UUID.randomUUID().toString());
//            st2.setAddress("Strada Fericirii");
//            st2.setName("Baruch");
//
//            RouteRepo rr = new RouteRepo();
//            Route rt = new Route();
//            rt.setAlias("35");
//            rt.setId(UUID.randomUUID().toString());
//            rt.setEndingHour("23:00");
//            rt.setStartingHour("05:00");
//            rt.setRouteInterval(11);
//
//            Route rt1 = new Route();
//            rt1.setAlias("36");
//            rt1.setId(UUID.randomUUID().toString());
//            rt1.setEndingHour("23:00");
//            rt1.setStartingHour("05:00");
//            rt1.setRouteInterval(25);
//
//
//            Route rt2 = new Route();
//            rt2.setAlias("37");
//            rt2.setId(UUID.randomUUID().toString());
//            rt2.setEndingHour("23:00");
//            rt2.setStartingHour("05:00");
//            rt2.setRouteInterval(15);
//
//            rr.insertNewRoute(rt1);
//            rr.insertNewRoute(rt2);

//    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
