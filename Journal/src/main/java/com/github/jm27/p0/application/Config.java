package com.github.jm27.p0.application;
/*
 * Imports
 */

import com.github.jm27.p0.domain.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Config {

    static final Logger LOG = LoggerFactory.getLogger("logger");

    public void logic(Journal mb, Scanner action) {

        try {
            LOG.info("Starting Journal logic waiting for user input");
            System.out.println("Welcome to your personal journal please type: create, write, read, delete or exit");
            String input = action.nextLine().trim().toLowerCase();
            LOG.info("user input " + input);
            while ((!input.equals("delete")) && (!input.equals("create")) && (!input.equals("write")) && (!input.equals("read")) && (!input.equals("exit"))) {
                System.out.println("Please type one of these: create, write, read, delete or exit");
                input = action.nextLine();
            }

            switch (input) {
                case "create":
                    mb.createEntry(action);
                    logic(mb, action);
                    break;
                case "write":
                    mb.writeEntry(true, action);
                    logic(mb, action);
                    break;
                case "read":
                    mb.readEntry(action);
                    logic(mb, action);
                    break;
                case "delete":
                    mb.deleteEntry(action);
                    logic(mb, action);
                    break;
                case "exit":
                    System.out.println("Closing Journal, Have a great day!");
                    action.close();
                    LOG.info("Closing Journal");
                default:
                    break;
            }
        } catch (Exception e) {
            LOG.error("Something went wrong logic");
            e.printStackTrace();
        }
    }
}
