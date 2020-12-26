package com.spring.utils;

import com.spring.entity.Route;
import com.spring.entity.User;
import com.spring.repository.RouteRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

public class Utils {
    private static User loggedUser = null;

    public static byte[] extractBytes (String imagePath) throws IOException {
        File fi = new File(imagePath);
        return Files.readAllBytes(fi.toPath());
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        Utils.loggedUser = loggedUser;
    }

    public static Collection<Route> getRoutes(){
        RouteRepo routeRepo = new RouteRepo();
        return routeRepo.getAllRoutes();
    }
}
