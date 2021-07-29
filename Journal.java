/**
 * Imports
 */
import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/// TODO:  Refactor, add to maven, add tests, Simplify file input by index. NTH: SQL database, Server, UI ;

class Journal{
    public static void main(String[] args){
        logic();
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

    public static void logic(){

        try {
            System.out.println("Welcome to your personal journal please type: create, write or read");
            Scanner action = new Scanner(System.in);
            String input = action.nextLine();

            while((!input.equals("create")) && (!input.equals("write"))  && (!input.equals("read"))){
                System.out.println("Please type type one of these: create, write or read");
                input = action.nextLine();
            }

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

            action.close();
        } catch (Exception e) {
            System.out.println("Something went wrong logic");
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
            System.out.println("Something went wrong creating");
            e.printStackTrace();
        }
    }

    public void Write(boolean append){
        // Get File
        try {
            ListFiles();
            System.out.println("Please type File to write to:\n");
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
            System.out.println("Something went wrong writing");
            e.printStackTrace();
        }

    }

    public void Read(){
        try {
            ListFiles();
            System.out.println("Please type File to read:\n");
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
            System.out.println("Something went wrong reading");
            e.printStackTrace();
        }
    }
}
