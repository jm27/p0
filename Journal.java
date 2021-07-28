/**
 * Imports
 */
import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Journal{
    public static void main(String[] args){

        logic();
//        Journal mb = new Journal();
//        mb.ListFiles();

    }

    public void ListFiles() {
        /// List files
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File f = new File("C:\\Users\\jme27\\Documents\\Revature\\SakuraMatrix\\p0");

        File[] files = f.listFiles(txtFilter);
        System.out.println("Please type File:");
        for (File file : files) {
            if(file.isDirectory()){
                System.out.print("directory");
            } else {
                System.out.print("\tfile:");
            }
            System.out.println(file.getName());
        }
        System.out.println("Please type File:\n");
    }

    public String Time(){
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh-mm");
        String text = date.format(formatter);
        return text;
    }

    public static void logic(){

        //// Fix input scan to check input in case not matching options !!
        try {
            System.out.println("Welcome to your personal journal please type: create, write or read entry");
            Scanner action = new Scanner(System.in);
            String input = action.nextLine();
            while(input != "create" || input != "read" || input != "write" ){
                System.out.println(input);
                System.out.println("Please type type one of these: create, write or read");
                input = action.nextLine();
            }
            action.close();
            Journal mb = new Journal();
            String time = mb.Time();
            switch (input.toLowerCase()){
                case "create": mb.Create(time+".txt");
                    break;
                case "write": mb.Write(true);
                    break;
                case "read": mb.Read();
                    break;
                default: break;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }


    }

    public void Create(String fileName){
        // Create new File
        File newFile = new File(fileName);

        try{
            // If file was created successfully.
            if(newFile.createNewFile()){
                System.out.println("File " + fileName + " Created Successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public void Write(boolean append){
        // Get File
        try {
            ListFiles();
            Scanner inFile = new Scanner(System.in);
            String file = inFile.nextLine();
            System.out.println("Please enter text: ");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            FileWriter entry = new FileWriter(file, append);
            entry.write(text);
            entry.close();
            in.close();
            inFile.close();
            System.out.println("Successfully wrote to file!");
        } catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    public void Read(){
        try {
            ListFiles();
            Scanner inFile = new Scanner(System.in);
            String file = inFile.nextLine();
            File entry = new File(file);
            Scanner entryReader = new Scanner(entry);
            while( entryReader.hasNextLine()){
                String data = entryReader.nextLine();
                System.out.println(data);
            }
            entryReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
