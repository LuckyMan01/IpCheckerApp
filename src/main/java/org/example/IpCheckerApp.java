package org.example;

import org.example.exception.BlacklistServiceException;
import org.example.service.BlackListService;
import org.example.util.IPValidator;

import java.util.Scanner;

public class App {

    public static final String STOP_WORD = "quit";

    public static void main(String[] args) {
        BlackListService blackListService = new BlackListService("/blacklist.txt");
        IPValidator ipValidator = new IPValidator();
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        System.out.println("Welcome to the Test program");

        try {
            do {
                System.out.println("Enter IP address or 'quit' to exit");
                inputLine = scanner.next();
                if (inputLine.equals(STOP_WORD)) return;

                if (!ipValidator.isValid(inputLine)) {
                    System.out.println("Invalid IP address");
                } else {
                    System.out.println(blackListService.containsAddress(inputLine) ? "Access disallowed" : "Access allowed");
                }
            } while (true);
        } catch (BlacklistServiceException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
