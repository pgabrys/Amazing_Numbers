package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                 - enter a natural number to know its properties;
                 - enter two natural numbers to obtain the properties of the list:
                    * the first parameter represents a starting number;
                    * the second parameters show how many consecutive numbers are to be processed;
                 - two natural numbers and a property to search for;
                 - separate the parameters with one space;
                 - enter 0 to exit.""");

        do {
            System.out.println("Enter a request:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            long firstParameter = Long.parseLong(inputArray[0]);

            Number number = new Number();
            Property property = null;
            if (inputArray.length == 3){
                try {
                    property = Property.valueOf(inputArray[2].toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("The property [" + inputArray[2].toUpperCase() + "] is wrong.\n" +
                            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                }
            }

            switch (inputArray.length) {
                case 1:
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    break;
                case 2:
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                    break;
                case 3:
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                    number.setProperty(property);
                    break;
            }

            boolean natural = true;

            if (inputArray.length == 1 && number.getChosenNumber() == 0) {
                exit = true;
                System.out.println("Goodbye!");
            }

            if (inputArray.length == 2 || inputArray.length == 3) {
                if (number.getRepeats() < 1) {
                    natural = false;
                    System.out.println("The second parameter should be a natural number.");
                }
            } else {
                if (number.getChosenNumber() < 1) {
                    natural = false;
                    System.out.println("The first parameter should be a natural number or zero.");
                }
            }

            if (natural && inputArray.length == 1) {
                CheckingNumber.properties(firstParameter);
            }
            if (natural && inputArray.length == 2) {
                CheckingMultipleNumbers.properties2(inputArray);
            }
            if (natural && inputArray.length == 3 && property != null){
                CheckingNumberWithProperty.properties3(CheckingNumberWithProperty.selectingNumbers(inputArray, property));
            }
        } while (!exit);
    }
}
