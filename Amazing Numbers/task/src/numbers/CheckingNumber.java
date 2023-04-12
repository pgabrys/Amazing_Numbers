package numbers;

import java.util.Arrays;

public class CheckingNumber {

    private static boolean isOdd(Number number) {
        return number.getChosenNumber() % 2 != 0;
    }

    private static boolean isEven(Number number) {
        return number.getChosenNumber() % 2 == 0;
    }

    private static boolean isBuzz(Number number) {
        boolean buzz = false;
        long firstPart = number.getChosenNumber() / 10;
        long secondPart = number.getChosenNumber() % 10;
        long secondPartMultiply = secondPart * 2;
        long subtract = firstPart - secondPartMultiply;

        if (subtract % 7 == 0 || secondPart == 7) {
            buzz = true;
        }
        return buzz;
    }

    private static boolean isDuck(Number number) {
        return String.valueOf(number.getChosenNumber()).contains("0");
    }

    private static boolean isPalindromic(Number number) {
        boolean palindromic = false;
        String numberToString = String.valueOf(number.getChosenNumber());
        StringBuffer reversedNumber = new StringBuffer(numberToString);
        String reversed = reversedNumber.reverse().toString();

        if (numberToString.equals(reversed)) {
            palindromic = true;
        }

        return palindromic;
    }

    private static boolean isGapful(Number number) {
        boolean gapful = false;
        String stringNumber = Long.toString(number.getChosenNumber());
        String[] parts = stringNumber.split("");
        long isGapful = -1;

        if (stringNumber.length() > 2) {
            String dividedBy = parts[0] + parts[parts.length - 1];
            long dividedByNumber = Long.parseLong(dividedBy);
            isGapful = number.getChosenNumber() % dividedByNumber;
        }
        if (isGapful == 0) {
            gapful = true;
        }
        return gapful;
    }

    private static boolean isSpy(Number number) {
        boolean spy = false;
        long sum;
        long product = 1;
        String stringNumber = Long.toString(number.getChosenNumber());
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
        return spy;
    }

    private static boolean isSunny(Number number) {
        double sqrt = Math.sqrt(number.getChosenNumber() + 1);
        return sqrt % 1 == 0;
    }

    private static boolean isSquare(Number number) {
        double sqrt = Math.sqrt(number.getChosenNumber());
        return sqrt % 1 == 0;
    }
    


    static void properties(Number number) {
        System.out.println("Properties of " + number.getChosenNumber() + "\n" +
                "        even: " + isEven(number) + "\n" +
                "         odd: " + isOdd(number) + "\n" +
                "        buzz: " + isBuzz(number) + "\n" +
                "        duck: " + isDuck(number) + "\n" +
                "      gapful: " + isGapful(number) + "\n" +
                " palindromic: " + isPalindromic(number) + "\n" +
                "         spy: " + isSpy(number) + "\n" +
                "       sunny: " + isSunny(number) + "\n" +
                "      square: " + isSquare(number));
    }


}
