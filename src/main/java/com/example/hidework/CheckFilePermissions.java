package com.example.hidework;

import java.io.File;

public class CheckFilePermissions {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Admin\\Downloads\\hidework\\src\\main\\resources\\logs\\log4j.log";

        File file = new File(filePath);

        if (file.exists()) {
            if (file.canWrite()) {
                System.out.println("У вас есть права на запись в файл.");
            } else {
                System.out.println("У вас нет прав на запись в файл.");
            }

            if (file.getParentFile().canWrite()) {
                System.out.println("У вас есть права на запись в каталог.");
            } else {
                System.out.println("У вас нет прав на запись в каталог.");
            }
        } else {
            System.out.println("Файл не существует.");
        }
    }
}
