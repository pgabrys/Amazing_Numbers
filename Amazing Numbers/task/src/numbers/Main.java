package numbers;

import java.util.Scanner;
import static numbers.CheckingRequest.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Jest logika dla Jumping, ale przy sprawdzany kilku liczb z jedną własciwością wpada w nieskończoną pętlę - do sprawdzenia.
         *
         * Pozostaje zaimplementowanie sprawdzania wielu (powyżej dwóch) właściwości naraz.
         * Tutaj trzeba raczej stworzyć w objekcie parametr tablicę właściwości do sprawdzenia,
         * a w logice za pomocą pętli for/for each przechadzaćsię po tej tablicy i sprawdzać właściwość dla danej liczby - coś w ten deseń
         */

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
            boolean notExclusive = true;

            Property[] properties = new Property[0];
            boolean propertyWrong = false;

            switch (inputArray.length) {
                case 1 -> number.setChosenNumber(Long.parseLong(inputArray[0]));
                case 2 -> {
                    number.setChosenNumber(Long.parseLong(inputArray[0]));
                    number.setRepeats(Long.parseLong(inputArray[1]));
                }
                default -> {
                    if (inputArray.length >= 3) {
                        number.setChosenNumber(Long.parseLong(inputArray[0]));
                        number.setRepeats(Long.parseLong(inputArray[1]));
                        properties = new Property[inputArray.length - 2];
                        for (int i = 2; i < inputArray.length; i++) {
                            try {
                                properties[i - 2] = Property.valueOf(inputArray[i].toUpperCase());
                            } catch (IllegalArgumentException e) {
                                propertyWrong = true;
                                System.out.println("The property [" + inputArray[i] + "] is wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
                            }
                        }
                        if (!propertyWrong) {
                            CheckingRequest.isExclusive(properties,notExclusive);
                            if (notExclusive) {
                                number.setProperties(properties);
                            }
                        }
                    }
                }
            }

            boolean natural = true;

            if (inputArray.length == 1 && number.getChosenNumber() == 0) {
                exit = true;
                System.out.println("Goodbye!");
            }

            if (inputArray.length >= 2) {
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

            if (natural) {
                if (inputArray.length == 1) {
                    CheckingNumber.properties(number);
                }
                if (inputArray.length == 2) {
                    CheckingMultipleNumbers.properties2(number);
                }
                if (inputArray.length >= 3 && notExclusive && !propertyWrong) {
                    CheckingNumberWithProperty.properties3(CheckingMultipleProperties.multipleProperties(number, properties));
                }
            }


//            if (natural && inputArray.length == 3 && firstProperty != null){
//                CheckingNumberWithProperty.properties3(CheckingNumberWithProperty.selectingNumbers(number, firstProperty));
//            }
//            if (natural && inputArray.length == 4 && firstProperty != null && secondProperty != null && notExclusive) {
//                CheckingNumberWithProperty.properties3(CheckingNumbersWithTwoProperties.selectingTwoProperties(number, firstProperty, secondProperty));
//            }
        } while (!exit);
    }
}
