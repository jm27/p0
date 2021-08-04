package com.github.jm27.p0.application;
/*
 * Imports
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Helpers {

    static final Logger LOG = LoggerFactory.getLogger("logger");

    public File[] getFiles(String PATH_NAME) {
        // Get files from path.
        LOG.info("Getting Files from " + PATH_NAME);
        FilenameFilter txtFilter = (dir, name) -> name.toLowerCase().endsWith(".txt");
        File f = new File(PATH_NAME);
        File[] files = f.listFiles(txtFilter); // Populate files array
        return files;
    }

    public boolean listFiles(File[] files) {
        // Loop trough files and Print them.
        try {
            LOG.info("Displaying files");
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.print("directory");
                } else {
                    System.out.print("\tfile: ");
                }
                System.out.println(file.getName());
            }
        } catch (Exception e) {
            LOG.error("Something went wrong listing files");
            return false;
        }
        return true;
    }

    public boolean checkFile(String fileName, String PATH_NAME) {
        // Check if file exists on directory.
        LOG.info("Checking if " + fileName + " exists in files array");
        File[] files = getFiles(PATH_NAME);
        boolean contains = Arrays.stream(files).anyMatch(file -> file.getName().equals(fileName));
        if (contains) {
            LOG.info("File found in array");
        } else {
            LOG.warn("File not found in array");
        }
        return contains;
    }

    public File createFile(Scanner input, String action, String PATH_NAME) {
        // Create file from user input
        LOG.info("Creating file");
        File[] files = getFiles(PATH_NAME);
        listFiles(files);
        System.out.println("Please type file to " + action + ":");
        String fileName = input.nextLine();
        // If file is not in directory ask for correct input
        while (!checkFile(fileName, PATH_NAME)) {
            listFiles(files);
            System.out.println("Please double check your spelling. remember to add .txt to file name");
            fileName = input.nextLine();
        }
        // Create new file in directory and return it
        File file = new File(PATH_NAME + "\\" + fileName);
        return file;
    }

    public String getTime() {
        // Get Local date and time, return in format.
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh-mm");
        String text = date.format(formatter);
        LOG.info("Getting time and format " + text);
        return text;
    }
}
