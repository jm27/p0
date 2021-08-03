package com.github.jm27.p0.application;


import com.github.jm27.p0.domain.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Config {

    static final Logger LOG = LoggerFactory.getLogger(Config.class);

    public void logic(Journal mb, Scanner action){

        try {
            System.out.println("Welcome to your personal journal please type: create, write, read, delete or exit");
            String input = action.nextLine().trim().toLowerCase();

            while((!input.equals("delete")) && (!input.equals("create")) && (!input.equals("write"))  && (!input.equals("read")) && (!input.equals("exit"))){
                System.out.println("Please type one of these: create, write, read, delete or exit");
                input = action.nextLine();
            }

            switch (input){
                case "create": mb.Create(action);
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
            LOG.error("Something went wrong logic");
            e.printStackTrace();
        }


    }
}
