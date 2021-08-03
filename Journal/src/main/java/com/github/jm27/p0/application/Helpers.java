package com.github.jm27.p0.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
import java.util.Scanner;

public class Helpers {

    static final Logger LOG = LoggerFactory.getLogger(Helpers.class);

    public void ListFiles(String PATH_NAME) {

        /// List files
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File f = new File(PATH_NAME);

        File[] files = f.listFiles(txtFilter);
        for (File file : files) {
            if(file.isDirectory()){
                System.out.print("directory");
            } else {
                System.out.print("\tfile: ");
            }
            System.out.println(file.getName());
        }
//        Boolean contains = Arrays.stream(files).anyMatch(file -> file.getName().equals("newEntry.txt"));
//        System.out.println(contains);
    }

    public File createFile(Scanner input, String action, String PATH_NAME){
        ListFiles(PATH_NAME);
        System.out.println("Please type file to " + action + ":\n");
        String fileName = input.nextLine();
        File file = new File(PATH_NAME + "\\" + fileName);
        return file;
    }

    public String getTime(){
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh-mm");
        String text = date.format(formatter);
        return text;
    }
}
