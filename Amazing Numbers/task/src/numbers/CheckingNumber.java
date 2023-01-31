package numbers;

import javax.swing.*;

public class CheckingNumber {

    static boolean isOdd(long number) {
        boolean odd = false;
        if (number % 2 != 0) {
            odd = true;
        }
        return odd;
    }

    static boolean isEven(long number) {
        boolean even = false;
        if (number % 2 == 0) {
            even = true;
        }
        return even;
    }

    static boolean isBuzz(long number) {
        boolean buzz = false;
        long firstPart = number / 10;
        long secondPart = number % 10;
        long secondPartMultiply = secondPart * 2;
        long subtract = firstPart - secondPartMultiply;

        if (subtract % 7 == 0 || secondPart == 7) {
            buzz = true;
        }
        return buzz;
    }

    static boolean isDuck(long number) {
        boolean duck = false;
        if (String.valueOf(number).contains("0")) {
            duck = true;
        }
        return duck;
    }

    static boolean isPalindromic(long number) {
        boolean palindromic = false;
        String numberToString = String.valueOf(number);
        StringBuffer reversedNumber = new StringBuffer(numberToString);
        String reversed = reversedNumber.reverse().toString();

        if (numberToString.equals(reversed)) {
            palindromic = true;
        }

        return palindromic;
    }

    static boolean isGapful(long number) {
        boolean gapful = false;
        String stringNumber = Long.toString(number);
        String[] parts = stringNumber.split("");
        long isGapful = -1;

        if (stringNumber.length() > 2) {
            String dividedBy = parts[0] + parts[parts.length -1];
            long dividedByNumber = Long.parseLong(dividedBy);
            isGapful = number % dividedByNumber;
        }
        if (isGapful == 0) {
            gapful = true;
        }
        return gapful;
    }

    static void properties(long number) {
        System.out.println("Properties of " + number + "\n" +
                "        even: " + isEven(number)+ "\n" +
                "         odd: " + isOdd(number) + "\n" +
                "        buzz: " + isBuzz(number) + "\n" +
                "        duck: " + isDuck(number) + "\n" +
                "        gapful: " + isGapful(number) + "\n" +
                " palindromic: " + isPalindromic(number));
    }




}
