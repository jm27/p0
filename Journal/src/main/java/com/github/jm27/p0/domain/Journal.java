package com.github.jm27.p0.domain;
/*
 * Imports
 */

import com.github.jm27.p0.application.Helpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Journal {

    static final Logger LOG = LoggerFactory.getLogger("logger.io");
    final String PATH_NAME = Paths.get("Journal_Entries").toAbsolutePath().toString();
    final Helpers helpers = new Helpers();

    // Create entry
    public boolean createEntry(Scanner input) {
        try {
            LOG.info("new Journal entry..");
            System.out.println("Please type your new file's name, if no name a default will be provided!");
            String time = helpers.getTime();
            String userInput = input.nextLine();
            // If user input is empty, add default name, else user input.
            userInput = userInput.length() <= 0 ?
                    time + ".txt" :
                    userInput + ".txt";
            // Create new File
            File newFile = new File(PATH_NAME + "\\" + userInput);
            // If file was created successfully.
            if (newFile.createNewFile()) {
                System.out.println("File " + userInput + " Created Successfully!");
                LOG.info("new Journal entry " + userInput + " Created Successfully!");
            } else {
                System.out.println("File already exists!");
                LOG.warn("Journal entry " + userInput + " already exists!");
                return false;
            }
        } catch (Exception e) {
            LOG.error("Something went wrong creating");
            e.printStackTrace();
        }
        return true;
    }

    // Write Entry
    public boolean writeEntry(boolean append, Scanner input) {
        // Get File
        try {
            File file = helpers.createFile(input, "write to", PATH_NAME);
            System.out.println("Please enter text: ");
            String text = input.nextLine();
            FileWriter entry = new FileWriter(file, append);
            entry.write(text);
            entry.close();
            System.out.println("Successfully wrote to file!");
            LOG.info("Successfully updated file " + file.getName());
        } catch (IOException e) {
            LOG.error("Something went wrong writing");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean readEntry(Scanner input) {
        try {
            File entry = helpers.createFile(input, "read", PATH_NAME);
            Scanner entryReader = new Scanner(entry);
            while (entryReader.hasNextLine()) {
                String data = entryReader.nextLine();
                System.out.println(data);
            }
            entryReader.close();
            LOG.info("Successfully read file " + entry.getName());
        } catch (FileNotFoundException e) {
            LOG.error("Something went wrong reading");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteEntry(Scanner input) {
        try {
            File entry = helpers.createFile(input, "delete", PATH_NAME);
            String output;
            if (entry.delete()) {
                output = "File " + entry.getName() + " Deleted successfully";
                LOG.info("Journal entry " + entry.getName() + " deleted successfully");
            } else {
                output = "Could not delete file, make sure there are no typos, or this file actually exists!";
                LOG.warn("Make sure file exists and there are no typos!");
                return false;
            }
            System.out.println(output);
        } catch (Exception e) {
            LOG.error("Something went wrong while deleting file!");
            e.printStackTrace();
        }
        return true;
    }
}
