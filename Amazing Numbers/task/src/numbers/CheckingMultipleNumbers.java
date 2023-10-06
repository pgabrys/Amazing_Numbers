package numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

    static String isSquare(long number) {
        double toCheck = Math.sqrt(number);
        String stringSquare = "";
        if (toCheck % 1 == 0) {
            stringSquare = "square";
        }
        return stringSquare;
    }

    static String isSunny(long number) {
        double toCheck = Math.sqrt(number + 1);
        String stringSunny = "";
        if (toCheck % 1 == 0) {
            stringSunny = "sunny";
        }
        return stringSunny;
    }

    static String isJumping(long number) {
        String stringJumping = "";
        boolean jumping = true;
        String stringNumber = Long.toString(number);
        String[] parts = stringNumber.split("");
        int size = parts.length;
        long[] digits = new long[size];
        for (int i = 0; i < size; i++) {
            digits[i] = Integer.parseInt(parts[i]);
        }

        if (number > 10){
            for (int i = 0; i < digits.length - 1; i++) {
                long result = digits[i + 1] - digits[i];
                if (Math.abs(result) != 1) {
                    jumping = false;
                }
            }
        }

        if (jumping) {
            stringJumping = "jumping";
        }
        return stringJumping;
    }

    static String isHappy(long number) {
        String stringHappyOrSad = "";

        Set<Long> unique_num = new HashSet<Long>();

        while (unique_num.add(number))
        {
            int value = 0;
            while (number > 0)
            {
                value += Math.pow(number % 10, 2);
                number /= 10;
            }
            number = value;
        }

        if (number == 1) {
            stringHappyOrSad = "happy";
        } else {
            stringHappyOrSad = "sad";
        }

        return stringHappyOrSad;
    }


    static void properties2(Number number) {
        long startNumber = number.getChosenNumber();
        long repeat = number.getRepeats();

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
            if (isSquare(startNumber).length() > 2) {
                result.add(isSquare(startNumber));
            }
            if (isSunny(startNumber).length() > 2) {
                result.add(isSunny(startNumber));
            }
            if (isJumping(startNumber).length() > 2) {
                result.add(isJumping(startNumber));
            }
            if (isHappy(startNumber).length() > 2) {
                result.add(isHappy(startNumber));
            }

            System.out.println(startNumber + " is " + result);
            startNumber++;
        }
    }
}
