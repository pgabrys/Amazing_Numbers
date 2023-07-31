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

    static void printFirstPropertyWrong(String[] inputArray) {
        System.out.println("The property [" + inputArray[2].toUpperCase() + "] is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }

    static void printSecondPropertyWrong(String[] inputArray) {
        System.out.println("The property [" + inputArray[3].toUpperCase() + "] is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }

    static void printBothPropertiesWrong(String[] inputArray) {
        System.out.println("The properties [" + inputArray[2].toUpperCase() + ", " + inputArray[3].toUpperCase() + "] are wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }


    static boolean isExclusive(Property[] properties, boolean notExclusive) {
        boolean even = false;
        boolean odd = false;
        boolean duck = false;
        boolean spy = false;
        boolean sunny = false;
        boolean square = false;
        for (int i = 0; i < properties.length; i++){
//            if (properties[i] == Property.EVEN) {
//                even = true;
//            }
            switch (properties[i]) {
                case EVEN -> {even = true;}
                case ODD -> {odd = true;}
                case DUCK -> {duck = true;}
                case SPY -> {spy = true;}
                case SUNNY -> {sunny = true;}
                case SQUARE -> {square = true;}
            }
        }

        if (even && odd) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
        } else if (duck && spy) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
        } else if (sunny && square) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                    "There are no numbers with these properties.");
        }
        return notExclusive;
    }
}
