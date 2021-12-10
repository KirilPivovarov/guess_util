package ua.com.devEducation.applicationGuess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ApplicationGuess {

    private final Random random = new Random();
    private final Scanner scanner;

    public ApplicationGuess(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getYourRandomNumber(int firstNumber, int lastNumber) {
        if (lastNumber > 200 || firstNumber < 0) {
            System.out.println("Incorrect input.");
            return 0;
        }
        if (firstNumber > lastNumber) {
            int i = lastNumber;
            lastNumber = firstNumber;
            firstNumber = i;
        }
        int diff = lastNumber - firstNumber;
        int randomNumber = random.nextInt(diff + 1);
        return randomNumber + firstNumber;
    }

    public int validationForValAttempts(int valAttantion){
        boolean start = true;
        while (start) {
            if (valAttantion > 15 || valAttantion < 0) {
                System.out.println("This number is not validated. Enter a new number");
                valAttantion = scanner.nextInt();
            }else{
                start = false;
            }
        }
        return valAttantion;
    }

    public void guessNumber(int unknownNumber, int valAttempts) {
        for (int i = 0; i < valAttempts + 1; i++) {
            try {
                System.out.println("if you want to know the hidden number enter number ");
                System.out.println("Enter your number or exit: ");
                String userNumber = scanner.next();
                if(userNumber.equals("number")){
                    System.out.println("Your number " + unknownNumber + "! You lose");
                    break;
                }else if (userNumber.equals("exit")) {
                    System.exit(0);
                }else if (i == valAttempts) {
                    System.out.println("Opppps!You lose. Your unknown number " + unknownNumber);
                    break;
                } else if (Integer.parseInt(userNumber) == unknownNumber) {
                    System.out.println("Congratulations! You guessed the intended number in " + (i + 1)+ " attempts");
                    break;
                } else if (Math.abs(unknownNumber - Integer.parseInt(userNumber)) < 5) {
                    System.out.println("Very hot! But you still have " + (valAttempts- i));
                } else if (Math.abs(unknownNumber - Integer.parseInt(userNumber)) < 15) {
                    System.out.println("You are already close! But you`ve got " + (valAttempts - i) + " of attempts left");
                } else if (Math.abs(unknownNumber - Integer.parseInt(userNumber)) < 25) {
                    System.out.println("You are somewhere close, but you have " + (valAttempts - i) + " attempts left");
                } else if (Math.abs(unknownNumber - Integer.parseInt(userNumber)) < 35) {
                    System.out.println("You are so far! But you have " + (valAttempts - i) + " attempts left");
                } else if (Math.abs(unknownNumber - Integer.parseInt(userNumber)) < 50) {
                    System.out.println("You flew to Antarctica from the date you need, think!But you have " + (valAttempts - i) + " attempts left");
                }else{
                    System.out.println("Did you enter the number exactly? But you have " + (valAttempts - i) + " attempts left\"");
                }
            }catch (InputMismatchException e){
                System.out.println("Enter exit or your number!");
            }
        }
    }
}
