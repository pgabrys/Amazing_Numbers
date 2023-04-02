package numbers;

import java.util.Arrays;
import java.util.StringJoiner;

public class CheckingMultipleNumbers {

    static String isOdd(long number) {
        boolean odd = false;
        String stringOdd = "";
        if (number % 2 != 0) {
            odd = true;
        }
        if (odd) {
            stringOdd = "odd";
        }
        return stringOdd;
    }


    static String isEven(long number) {
        boolean even = false;
        String stringEven = "";
        if (number % 2 == 0) {
            even = true;
        }

        if (even) {
            stringEven = "even";
        }
        return stringEven;
    }

    static String isBuzz(long number) {
        boolean buzz = false;
        String stringBuzz = "";
        long firstPart = number / 10;
        long secondPart = number % 10;
        long secondPartMultiply = secondPart * 2;
        long subtract = firstPart - secondPartMultiply;

        if (subtract % 7 == 0 || secondPart == 7) {
            buzz = true;
        }

        if (buzz) {
            stringBuzz = "buzz";
        }
        return stringBuzz;
    }

    static String isDuck(long number) {
        boolean duck = false;
        String stringDuck = "";
        if (String.valueOf(number).contains("0")) {
            duck = true;
        }
        if (duck) {
            stringDuck = "duck";
        }
        return stringDuck;
    }

    static String isPalindromic(long number) {
        boolean palindromic = false;
        String stringPalindromic = "";
        String numberToString = String.valueOf(number);
        StringBuffer reversedNumber = new StringBuffer(numberToString);
        String reversed = reversedNumber.reverse().toString();

        if (numberToString.equals(reversed)) {
            palindromic = true;
        }

        if (palindromic) {
            stringPalindromic = "palindromic";
        }
        return stringPalindromic;
    }

    static String isGapful(long number) {
        boolean gapful = false;
        String stringGapful = "";
        String stringNumber = Long.toString(number);
        String[] parts = stringNumber.split("");
        long isGapful = -1;

        if (stringNumber.length() > 2) {
            String dividedBy = parts[0] + parts[parts.length - 1];
            long dividedByNumber = Long.parseLong(dividedBy);
            isGapful = number % dividedByNumber;
        }
        if (isGapful == 0) {
            gapful = true;
        }
        if (gapful) {
            stringGapful = "gapful";
        }
        return stringGapful;
    }

    static String isSpy(long number) {
        boolean spy = false;
        String stringSpy = "";
        long sum;
        long product = 1;
        String stringNumber = Long.toString(number);
        String[] parts = stringNumber.split("");
        long[] digits = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            digits[i] = Long.parseLong(parts[i]);
        }
        sum = Arrays.stream(digits).sum();

        for (long digit : digits) {
            product = product * digit;
        }

        if (sum == product){
            spy = true;
        }
        if (spy) {
            stringSpy = "spy";
        }
        return stringSpy;
    }

    static void properties2(Number number) {
        long startNumber = number.chosenNumber;
        long repeat = number.repeats;

        /** Próba na upgrade StringJoinera, to zamiast użyć .add i fuckji if,
         * to użyć .merge. To powinno pozwolić na usunięcie if'a, bo to działa tylko
         * na nie nulle
         */

        for (long i = 1; i <= repeat; i++) {
            StringJoiner result = new StringJoiner(", ");
            if (isEven(startNumber).length() > 2) {
                result.add(isEven(startNumber));
            }
            if (isOdd(startNumber).length() > 2) {
                result.add(isOdd(startNumber));
            }
            if (isBuzz(startNumber).length() > 2) {
                result.add(isBuzz(startNumber));
            }
            if (isDuck(startNumber).length() > 2) {
                result.add(isDuck(startNumber));
            }
            if (isPalindromic(startNumber).length() > 2) {
                result.add(isPalindromic(startNumber));
            }
            if (isGapful(startNumber).length() > 2) {
                result.add(isGapful(startNumber));
            }
            if (isSpy(startNumber).length() > 2) {
                result.add(isSpy(startNumber));
            }

            System.out.println(startNumber + " is " + result);
            startNumber++;
        }
    }
}
