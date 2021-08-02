package com.github.jm27.p0; /**
 * Imports
 */

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/// TODO:  Refactor!, add tests, Simplify file input by index. NTH: SQL database, Server, UI ;

class Journal {

    final String PATH_NAME = Paths.get("Journal_Entries").toAbsolutePath().toString();

    public static void main(String[] args){
//         final Path PATH_NAME = Paths.get("Journal_Entries").toAbsolutePath();
        Journal mb = new Journal();
        Scanner action = new Scanner(System.in);
        logic(mb, action);
//        System.out.println(PATH_NAME);
    }

    public void ListFiles() {

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

    }

    public File createFile(Scanner input, String action){
        ListFiles();
        System.out.println("Please type file to " + action + ":\n");
        String fileName = input.nextLine();
        File file = new File(PATH_NAME + "\\" + fileName);
        return file;
    }

    public String Time(){
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh-mm");
        String text = date.format(formatter);
        return text;
    }

    public static void logic(Journal mb, Scanner action){


        String time = mb.Time();

        try {
            System.out.println("Welcome to your personal journal please type: create, write, read, delete or exit");
            String input = action.nextLine().toLowerCase();

            while((!input.equals("delete")) && (!input.equals("create")) && (!input.equals("write"))  && (!input.equals("read")) && (!input.equals("exit"))){
                System.out.println("Please type type one of these: create, write, read, delete or exit");
                input = action.nextLine();
            }

            switch (input){
                case "create": mb.Create(time+".txt", action);
                                logic(mb, action);
                    break;
                case "write": mb.Write(true, action);
                                logic(mb, action);
                    break;
                case "read": mb.Read(action);
                            logic(mb, action);
                    break;
                case "delete": mb.Delete(action);
                                logic(mb, action);
                     break;
                case "exit": System.out.println("Closing Journal, Have a great day!");
                            action.close();
                default: break;
            }


        } catch (Exception e) {
            System.out.println("Something went wrong logic");
            e.printStackTrace();
        }


    }

    public void Create(String fileName, Scanner input){
        try{
            System.out.println("Please type your new file's name, if no name a default will be provided!");
            String userInput = !input.next().equals("") ? fileName : input.nextLine() +".txt"; //// FIX!
            System.out.println(userInput);
            // Create new File
//            File newFile = new File(PATH_NAME +"\\"+ userInput);
            // If file was created successfully.
//            if(newFile.createNewFile()){
//                System.out.println("File " + userInput + " Created Successfully!");
//            } else {
//                System.out.println("File already exists!");
//            }
        } catch (Exception e) {
            System.out.println("Something went wrong creating");
            e.printStackTrace();
        }
    }

    public void Write(boolean append, Scanner input){
        // Get File
        try {
            File file = createFile(input, "write to");
            System.out.println("Please enter text: ");
            String text = input.nextLine();
            FileWriter entry = new FileWriter(file, append);
            entry.write(text);
            entry.close();
//            input.close();
            System.out.println("Successfully wrote to file!");
        } catch (IOException e){
            System.out.println("Something went wrong writing");
            e.printStackTrace();
        }

    }

    public void Read(Scanner input){
        try {
            File entry = createFile(input, "read");
            Scanner entryReader = new Scanner(entry);
            while( entryReader.hasNextLine()){
                String data = entryReader.nextLine();
                System.out.println(data);
            }
            entryReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong reading");
            e.printStackTrace();
        }
    }

    public void Delete(Scanner input){
        try {
            File entry = createFile(input, "delete");
            String output = entry.delete() ? "File " +
                    entry.getName() +
                    " Deleted successfully" : "Could not delete file, make sure there are no typos, or this file actually exists!";
            System.out.println(output);

        } catch (Exception e){
            System.err.println("Something went wrong while deleting file!");
            e.printStackTrace();
        }
    }
}
