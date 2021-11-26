/*
* This program generate random number between 1 to 6,
* get user number, check these two numbers are correct.
*
* @author  Donggeun Lim
* @version 1.0
* @since   2021-11-23
*/
// package ca.mths.unit1.unit05.java.main;

import java.util.Random;
import java.util.Scanner;

/**
* This is the standard dice game program.
*/
public final class DiceGame {
    // constant
    /** Max number of normal dice. */
    static final int NORMAL_DICE = 6;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private DiceGame() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final Scanner myObj = new Scanner(System.in);
        final Random random = new Random();
        // counter
        int counter = 0;
        // Genrate random number between 1 to 6
        final int randomNumber = random.nextInt(NORMAL_DICE) + 1;

        while (true) {
            System.out.print("Guess the number between 1 to 6: ");
            counter += 1;
            try {
                // condition
                final float userNumber = myObj.nextFloat();
                if (userNumber >= 1 && userNumber <= NORMAL_DICE) {
                    if (userNumber >= randomNumber) {
                        if (userNumber <= randomNumber) {
                            break;
                        }
                        else {
                            System.out.print("You guessed too high.");
                        }

                    }
                    else {
                        System.out.print("You guessed too low.");
                    }
                }
                else {
                    System.out.print("Out of range!");
                }

            }
            catch (java.util.InputMismatchException errorCode) {
                System.err.print("This number is not an integer.\n\nDone\n");
                System.exit(0);
            }
            System.out.println("\nTry again!\n");
        }
        System.out.println("Correct! The number is " + randomNumber
                           + "!\nIt took you " + counter + " tries.");
        System.out.println("\nDone.");
    }
}
