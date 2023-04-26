package numbers;

public class CheckingRequest {
    static boolean exit(boolean exit, long number) {
        if (number == 0) {
            exit = true;
        }
        return exit ;
    }

    static boolean isNatural(String[] inputArray, boolean natural, long number) {
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
        return natural;
    }

    static void printMutuallyExclusive(String[] inputArray) {
        System.out.println("The request contains mutually exclusive properties: [" + inputArray[2].toUpperCase() + ", " + inputArray[3].toUpperCase() + "]\n" +
                "There are no numbers with these properties.");
    }

    static void printFirstPropertyWrong(String[] inputArray) {
        System.out.println("The property [" + inputArray[2].toUpperCase() + "] is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
    }

    static void printSecondPropertyWrong(String[] inputArray) {
        System.out.println("The property [" + inputArray[3].toUpperCase() + "] is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
    }

    static void printBothPropertiesWrong(String[] inputArray) {
        System.out.println("The properties [" + inputArray[2].toUpperCase() + ", " + inputArray[3].toUpperCase() + "] are wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
    }
}
