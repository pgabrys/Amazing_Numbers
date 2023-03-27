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
            long number = Long.parseLong(inputArray[0]);

            Property property = null;
            try {
                property = Property.valueOf(inputArray[2].toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("The property [SUN] is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
            }

            /**
             * Do tworzenia objektów number bazować na tablicy input. Stworzyć if'y lub switch, gdzie będzie
             * sprawdzany parametr długości tablicy. Na bazie tego, będzie wybrany odpowiedni konstruktor.
             *
             * A potem "wystarczy" tylko przerobić wszystko, aby sprawdzało obiekty xD
             */



            boolean natural = true;

            //CheckingRequest.exit(exit, number);
            //CheckingRequest.isNatural(inputArray,natural,number);

            if (number == 0) {
                exit = true;
                System.out.println("Goodbye!");
            }

            if (inputArray.length == 2 || inputArray.length == 3) {
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



            if (natural && inputArray.length == 1) {
                CheckingNumber.properties(number);
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
