package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                  - enter a natural number to know its properties;\s
                  - enter two natural numbers to obtain the properties of the list:
                    * the first parameter represents a starting number;
                    * the second parameter shows how many consecutive numbers are to be printed;
                  - two natural numbers and a property to search for;
                  - two natural numbers and two properties to search for;
                  - separate the parameters with one space;
                  - enter 0 to exit.""");

        do {
            System.out.println("Enter a request:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");

            Number number = new Number();
            Property firstProperty = null;
            Property secondProperty = null;
            if (inputArray.length == 3){
                try {
                    firstProperty = Property.valueOf(inputArray[2].toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("The property [" + inputArray[2].toUpperCase() + "] is wrong.\n" +
                            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                }
            }

            if (inputArray.length == 4){
                try {
                    firstProperty = Property.valueOf(inputArray[2].toUpperCase());
                    secondProperty = Property.valueOf(inputArray[3].toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("The properties [" + inputArray[2].toUpperCase() + ", "
                            + inputArray[3].toUpperCase() + "] are wrong.\n" +
                            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                }
            }

            /**
             * W tym miejscu trzebo dodać porównanie enumów/inputu, czy aby przypadkiem nie tworzą zakazanych par.
             * Prawdopodobnie trzeba polecieć na IFie. Ale może jest jakaś gotowa metoda do enumów?
             * Trzeba by poszperać na necie.
             */



            switch (inputArray.length) {
                case 1 -> number.setChosenNumber(Long.parseLong(inputArray[0]));
                case 2 -> {
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                }
                case 3 -> {
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                    number.setFirstProperty(firstProperty);
                }
                case 4 -> {
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                    number.setFirstProperty(firstProperty);
                    number.setSecondProperty(secondProperty);
                }
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
                CheckingNumber.properties(number);
            }
            if (natural && inputArray.length == 2) {
                CheckingMultipleNumbers.properties2(number);
            }
            if (natural && inputArray.length == 3 && firstProperty != null){
                CheckingNumberWithProperty.properties3(CheckingNumberWithProperty.selectingNumbers(number, firstProperty));
            }
        } while (!exit);
    }
}
