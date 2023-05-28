package numbers;

import java.util.Scanner;
import static numbers.CheckingRequest.*;

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

            switch (inputArray.length) {
                case 3 -> {
                    try {
                        firstProperty = Property.valueOf(inputArray[2].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        printFirstPropertyWrong(inputArray);
                    }
                }
                case 4 -> {
                    boolean firstPropertyWrong = false;
                    boolean secondPropertyWrong = false;
                    try {
                        firstProperty = Property.valueOf(inputArray[2].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        firstPropertyWrong = true;
                    }

                    try {
                        secondProperty = Property.valueOf(inputArray[3].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        secondPropertyWrong = true;
                    }

                    if (firstPropertyWrong && secondPropertyWrong == false) {
                        printFirstPropertyWrong(inputArray);
                    } else if (secondPropertyWrong && firstPropertyWrong == false) {
                        printSecondPropertyWrong(inputArray);
                    } else if (firstPropertyWrong && secondPropertyWrong) {
                        printBothPropertiesWrong(inputArray);
                    }
                }
            }


            boolean notExclusive = true;

            if (firstProperty == Property.EVEN && secondProperty == Property.ODD) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            } else if (firstProperty == Property.ODD && secondProperty == Property.EVEN) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            } else if (firstProperty == Property.DUCK && secondProperty == Property.SPY) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            } else if (firstProperty == Property.SPY && secondProperty == Property.DUCK) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            } else if (firstProperty == Property.SUNNY && secondProperty == Property.SQUARE) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            } else if (firstProperty == Property.SQUARE && secondProperty == Property.SUNNY) {
                notExclusive = false;
                printMutuallyExclusive(inputArray);
            }




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
            if (natural && inputArray.length == 4 && firstProperty != null && secondProperty != null && notExclusive) {
                CheckingNumberWithProperty.properties3(CheckingNumbersWithTwoProperties.selectingTwoProperties(number, firstProperty, secondProperty));

            }
        } while (!exit);
    }
}
