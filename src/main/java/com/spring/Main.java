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

//    public static void main(String[] args) throws IOException {
//        RouteRepo rr = new RouteRepo();
//
//        Route rt = rr.findRoute("67c7c4cb-9720-4215-8b86-95439c68ca33");
//        rt.setStartingHour("07:00");
//        rt.setRouteInterval(69);;
//
//    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
