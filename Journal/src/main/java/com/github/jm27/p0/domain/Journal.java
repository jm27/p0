package com.github.jm27.p0.domain;

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

    final String PATH_NAME = Paths.get("Journal_Entries").toAbsolutePath().toString();
    static final Logger LOG = LoggerFactory.getLogger(Journal.class);
    final Helpers helpers = new Helpers();

    public void Create(Scanner input){
        try{
            System.out.println("Please type your new file's name, if no name a default will be provided!");
            String time = helpers.getTime();
            String userInput = input.nextLine().length() <= 0 ?
                    time + ".txt":
                    input.nextLine() +".txt"; //// FIX!
            // Create new File
            File newFile = new File(PATH_NAME +"\\"+ userInput);
            // If file was created successfully.
            if(newFile.createNewFile()){
                System.out.println("File " + userInput + " Created Successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (Exception e) {
            LOG.error("Something went wrong creating");
            e.printStackTrace();
        }
    }

    public void Write(boolean append, Scanner input){
        // Get File
        try {
            File file = helpers.createFile(input, "write to", PATH_NAME);
            System.out.println("Please enter text: ");
            String text = input.nextLine();
            FileWriter entry = new FileWriter(file, append);
            entry.write(text);
            entry.close();
            System.out.println("Successfully wrote to file!");
        } catch (IOException e){
            LOG.error("Something went wrong writing");
            e.printStackTrace();
        }

    }

    public void Read(Scanner input){
        try {
            File entry = helpers.createFile(input, "read", PATH_NAME);
            Scanner entryReader = new Scanner(entry);
            while( entryReader.hasNextLine()){
                String data = entryReader.nextLine();
                System.out.println(data);
            }
            entryReader.close();
        } catch (FileNotFoundException e) {
            LOG.error("Something went wrong reading");
            e.printStackTrace();
        }
    }

    public void Delete(Scanner input){
        try {
            File entry = helpers.createFile(input, "delete", PATH_NAME);
            String output = entry.delete() ?
                    "File " + entry.getName() + " Deleted successfully" :
                    "Could not delete file, make sure there are no typos, or this file actually exists!";
            System.out.println(output);

        } catch (Exception e){
            LOG.error("Something went wrong while deleting file!");
            e.printStackTrace();
        }
    }
}
