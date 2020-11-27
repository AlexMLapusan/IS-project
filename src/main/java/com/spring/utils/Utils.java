package com.spring.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Utils {

    public static byte[] extractBytes (String imagePath) throws IOException {
        File fi = new File(imagePath);
        return Files.readAllBytes(fi.toPath());
    }
}
