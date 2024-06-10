package projektPC2;

import java.util.Scanner;

public class Inputs {

    public static int onlyNumbers(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                }
            } else {
                System.out.println("Enter an integer in the range " + min + "-" + max + ":");
                sc.next();
            }
        }
        return number;
    }

    public static String onlyName() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Name cannot be null or empty.");
            } else if (!input.matches("[a-zA-Z\\s-]+")) {
                System.out.println("Name can only contain letters, spaces and dashes. Try again:");
            } else {
                break;
            }
        }
        return input;
    }

    public static String nameAndDigit() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Name cannot be null or empty. Try again:");
            } else if (!input.matches("[a-zA-Z][a-zA-Z\\s-\\d]*")) {
                System.out.println("Name can only contain letters, spaces, dashes, and digits. Try again:");
            } else {
                break;
            }
        }
        return input;
    }
}
