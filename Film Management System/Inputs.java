package projektPC2;

import java.util.Scanner;

// Class for validating inputs
public class Inputs {

    // Method to input an integer within a specified range
    public static int onlyNumbers(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        // Keep prompting until a valid input is provided
        while (!validInput) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                // Check if the input is within the specified range
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                }
            } else {
                // Display error message for non-integer input
                System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                sc.next();
            }
        }
        return number;
    }

    // Method to input a string containing only letters, spaces and dashes
    public static String onlyName() {
        Scanner sc = new Scanner(System.in);
        String input;

        // Keep prompting until a valid name is provided
        while (true) {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                // Display error message for empty input
                System.out.println("Name cannot be null or empty.");
            } else if (!input.matches("[a-zA-Z\\s-]+")) {
                // Display error message for invalid characters
                System.out.println("Name can only contain letters, spaces and dashes. Try again:");
            } else {
                break;
            }
        }
        return input;
    }

    // Method to input a string containing letters, spaces, dashes and digits
    public static String nameAndDigit() {
        Scanner sc = new Scanner(System.in);
        String input;

        // Keep prompting until a valid name is provided
        while (true) {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                // Display error message for empty input
                System.out.println("Name cannot be null or empty. Try again:");
            } else if (!input.matches("[a-zA-Z][a-zA-Z\\s-\\d]*")) {
                // Display error message for invalid characters
                System.out.println("Name can only contain letters, spaces, dashes, and digits. Try again:");
            } else {
                break;
            }
        }
        return input;
    }
}
