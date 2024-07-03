package projektPC2_designpatterns;

import java.util.Scanner;

// Class for validating inputs
public final class Inputs {

    // Private constructor to avoid create a object
    private Inputs() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Method to input an integer within a specified range
    public static int onlyNumbers(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        // Keep prompting until a valid input is provided
        while (!validInput) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                // Check if the input is within the specified range
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                }
            } else {
                // Display error message for non-integer input
                System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                scanner.next();
            }
        }
        return number;
    }

    // Method to input a string containing only letters, spaces and dashes
    public static String onlyName() {
        Scanner scanner = new Scanner(System.in);
        String input;

        // Keep prompting until a valid name is provided
        while (true) {
            input = scanner.nextLine().trim();
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
        Scanner scanner = new Scanner(System.in);
        String input;

        // Keep prompting until a valid name is provided
        while (true) {
            input = scanner.nextLine().trim();
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
