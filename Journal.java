/**
 * Imports
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;

class Journal{
    public static void main(String[] args){
        System.out.println(args[0]);
        Journal mb = new Journal();
        mb.Create("test2.txt");
        mb.Write("test2.txt", " HEllo buen amigo! como estas?", true );
        mb.Read("test2.txt");
    }

//    public void logic(String input){
//        switch (input){
//            case 1:
//        }
//    }

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

    public void Write(String fileName, String text, boolean append){
        // Get File
        try {
            FileWriter entry = new FileWriter(fileName, append);
            entry.write(text);
            entry.close();
            System.out.println("Successfully wrote to file!");
        } catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    public void Read(String fileName){
        try {
            File entry = new File(fileName);
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
