package numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckingNumber {

    protected static boolean isOdd(Number number) {
        return number.getChosenNumber() % 2 != 0;
    }

    protected static boolean isEven(Number number) {
        return number.getChosenNumber() % 2 == 0;
    }

    protected static boolean isBuzz(Number number) {
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

    protected static boolean isDuck(Number number) {
        return String.valueOf(number.getChosenNumber()).contains("0");
    }

    protected static boolean isPalindromic(Number number) {
        boolean palindromic = false;
        String numberToString = String.valueOf(number.getChosenNumber());
        StringBuffer reversedNumber = new StringBuffer(numberToString);
        String reversed = reversedNumber.reverse().toString();

        if (numberToString.equals(reversed)) {
            palindromic = true;
        }

        return palindromic;
    }

    protected static boolean isGapful(Number number) {
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

    protected static boolean isSpy(Number number) {
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

    protected static boolean isSunny(Number number) {
        double sqrt = Math.sqrt(number.getChosenNumber() + 1);
        return sqrt % 1 == 0;
    }

    protected static boolean isSquare(Number number) {
        double sqrt = Math.sqrt(number.getChosenNumber());
        return sqrt % 1 == 0;
    }

    protected static boolean isJumping(Number number) {
        boolean jumping = true;

        if (number.getChosenNumber() > 10) {
            String stringNumber = Long.toString(number.getChosenNumber());
            String[] parts = stringNumber.split("");
            int size = parts.length;
            long[] digits = new long[size];
            for (int i = 0; i < size; i++) {
                digits[i] = Integer.parseInt(parts[i]);
            }

            for (int i = 0; i < digits.length - 1; i++) {
                long result = digits[i + 1] - digits[i];
                if (Math.abs(result) != 1) {
                    jumping = false;
                }
            }
        }
        return jumping;
    }

    protected static boolean isHappy (Number number) {
        boolean happy = false;
        long num = number.getChosenNumber();
        Set<Long> unique_num = new HashSet<Long>();

        while (unique_num.add(num))
        {
            int value = 0;
            while (num > 0)
            {
                value += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = value;
        }

        if (num == 1) {
            happy = true;
        }

        return happy;
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
                "      square: " + isSquare(number) + "\n" +
                "     jumping: " + isJumping(number) + "\n" +
                "       happy: " + isHappy(number) + "\n" +
                "         sad: " + !isHappy(number));
    }


}
