package com.spring.utils;

import com.spring.entity.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
}
