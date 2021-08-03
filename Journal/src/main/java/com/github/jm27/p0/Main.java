package com.github.jm27.p0;
/*
 * Imports
 */
import com.github.jm27.p0.application.Config;
import com.github.jm27.p0.domain.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

// TODO:  Refactor!, add tests, Simplify file input. NTH: SQL database, Server, UI ;

public class Main {
    public static void main(String ...args){
        // SLF4J Logger
        final Logger LOG = LoggerFactory.getLogger(Main.class);
        LOG.info("Starting application...");

        Journal journal = new Journal();
        Config config = new Config();
        Scanner scanner = new Scanner(System.in);
        config.logic(journal, scanner);
    }
}
