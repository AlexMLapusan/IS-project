package com.spring;

import com.spring.entity.User;
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
//    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
