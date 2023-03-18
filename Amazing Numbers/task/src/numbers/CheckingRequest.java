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
}
