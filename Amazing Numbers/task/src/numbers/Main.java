package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("" +
                "Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        do {
            System.out.println("Enter a request:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            long number = Long.parseLong(inputArray[0]);
            if (inputArray.length == 2) {
                long howManyConsecutive = Long.parseLong(inputArray[1]);
            }

            boolean natural = true;

            if (number == 0) {
                exit = true;
                System.out.println("Goodbye!");
            }

            if (inputArray.length == 2) {
                if (Long.parseLong(inputArray[1]) < 1) {
                    natural = false;
                    System.out.println("The second parameter should be a natural number.");
                }
            } else {
                if (number < 1) {
                    natural = false;
                    System.out.println("The first parameter should be a natural number or zero.");
                }
            }

            if (natural && inputArray.length == 1) {CheckingNumber.properties(number);}
            if (natural && inputArray.length == 2) {CheckingMultipleNumbers.properties2(inputArray);}

        } while (!exit);

    }
}
