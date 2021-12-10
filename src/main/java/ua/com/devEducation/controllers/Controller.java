package ua.com.devEducation.controllers;

import ua.com.devEducation.applicationGuess.ApplicationGuess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner= new Scanner(System.in);
    private final ApplicationGuess application = new ApplicationGuess(scanner);
    private final Random random = new Random();

    public void run() {
        System.out.println("Hello in guess application! Choose your option:");
        boolean startProgram = true;
        while (startProgram) {
            System.out.println("1 - enter new boundaries\n"
            + "2 - guess a number from 0 to 100\n"
            + "exit - for exit");
           String choose = scanner.nextLine();

           int from = 0;
           int to = 100;
            int valAttempts = 5;
            switch (choose) {
                case "1":
                    try {
                        System.out.println("Hi, I am guessing a number from min to max of your range. Try to guess it in x tries!");
                        System.out.println("Enter your number of attempts:");
                        valAttempts = scanner.nextInt();
                        valAttempts = application.validationForValAttempts(valAttempts);
                        System.out.println("Enter your boundaries:");
                        System.out.print("from: ");
                        from = scanner.nextInt();
                        System.out.print("to: ");
                        to = scanner.nextInt();
                        int unknownNumber = application.getYourRandomNumber(from,to);
                            application.guessNumber(unknownNumber, valAttempts);
                    }catch (InputMismatchException e){
                        System.out.println("Incorrect input!");
                    }
                    break;
                case "2" :{
                    System.out.println("Hi, I am guessing a number from 0 to 100 of your range. Try to guess it in 5 tries!");
                    int unknownNumber = application.getYourRandomNumber(from,to);
                    application.guessNumber(unknownNumber, valAttempts);
                    break;
                }
                case "exit":
                    startProgram = false;
                    System.exit(0);
            }
            }
        }
    }
