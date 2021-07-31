/**
 * Imports
 */

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/// TODO:  Refactor!, add tests, Simplify file input by index. NTH: SQL database, Server, UI ;

class Journal {
    public static void main(String[] args){
        Journal mb = new Journal();
        Scanner action = new Scanner(System.in);
        logic(mb, action);
    }

    public void ListFiles() {
        /// List files
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File f = new File("C:\\Users\\jme27\\Documents\\Revature\\SakuraMatrix\\p0\\Journal");

        File[] files = f.listFiles(txtFilter);
        for (File file : files) {
            if(file.isDirectory()){
                System.out.print("directory");
            } else {
                System.out.print("\tfile:");
            }
            System.out.println(file.getName());
        }

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
            String input = action.nextLine();

            while((!input.equals("delete")) && (!input.equals("create")) && (!input.equals("write"))  && (!input.equals("read")) && (!input.equals("exit"))){
                System.out.println("Please type type one of these: create, write, read, delete or exit");
                input = action.nextLine();
            }

            switch (input.toLowerCase()){
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
            String userInput = input.nextLine() == "" ? fileName : input.nextLine() +".txt"; //// FIX!
            // Create new File
            File newFile = new File(userInput);
            // If file was created successfully.
            if(newFile.createNewFile()){
                System.out.println("File " + userInput + " Created Successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong creating");
            e.printStackTrace();
        }
    }

    public void Write(boolean append, Scanner input){
        // Get File
        try {
            ListFiles();
            System.out.println("Please type File to write to:\n");
            String file = input.nextLine();
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
            ListFiles();
            System.out.println("Please type File to read:\n");
            String file = input.nextLine();
            File entry = new File(file);
            Scanner entryReader = new Scanner(entry);
            while( entryReader.hasNextLine()){
                String data = entryReader.nextLine();
                System.out.println(data);
            }
            entryReader.close();
//            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong reading");
            e.printStackTrace();
        }
    }

    public void Delete(Scanner input){
        try {
            ListFiles();
            System.out.println("Please type file to delete:\n");
            String file = input.nextLine();
            File entry = new File(file);
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
