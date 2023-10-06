package numbers;


import java.util.*;

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
                  - a property preceded by minus must not be present in numbers;
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
                        List<String> wrongProperties = new ArrayList<>();
                        for (int i = 2; i < inputArray.length; i++) {
                            properties[i - 2] = Property.getPropertyFromString(inputArray[i]);

                            if (properties[i - 2] == null) {
                                propertyWrong = true;
                                wrongProperties.add(inputArray[i]);
                            }


                        }
                        /**
                         w sekcji powyżej, w którejś formie pętli for trzeba porówbać input (String) do
                         zdefiniowanych label enumów za pomocą przeciążonej metody toString.

                         Pomocne linki w Sricky Notes
                         */
                        if (propertyWrong) {
                            if (wrongProperties.size() == 1) {
                                System.out.println("The property [" + wrongProperties.get(0) + "] is wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                            } else {
                                String list = wrongProperties.toString();
                                System.out.println("The properties " + list + " are wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                            }
                        }
                        if (!propertyWrong) {
                            notExclusive = CheckingRequest.isExclusive(properties, notExclusive);
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
            }
            while (!exit) ;
        }

    }



