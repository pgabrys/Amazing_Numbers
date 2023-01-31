package numbers;

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
            String dividedBy = parts[0] + parts[parts.length -1];
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

    static void properties2 (String[] inputArray) {
        long startNumber = Long.parseLong(inputArray[0]);
        long repeat = Long.parseLong(inputArray[1]);
//        String result = "";
        /** Próba na upgrade StringJoinera, to zamiast użyć .add i fuckji if,
         * to użyć .merge. To powinno pozwolić na usunięcie if'a, bo to działa tylko
         * na nie nulle
         */

        for (long i = startNumber; i <= repeat; i++ ){
            StringJoiner result = new StringJoiner(", ");
            if (isEven(i).length() > 2) {result.add(isEven(i));}
            if (isOdd(i).length() > 2) {result.add(isOdd(i));}
            if (isBuzz(i).length() > 2) {result.add(isBuzz(i));}
            if (isDuck(i).length() > 2) {result.add(isDuck(i));}
            if (isPalindromic(i).length() > 2) {result.add(isPalindromic(i));}
            if (isGapful(i).length() > 2) {result.add(isGapful(i));}

//            result.add(isEven(i));
//            result.add(isOdd(i));
//            result.add(isBuzz(i));
//            result.add(isDuck(i));
//            result.add(isPalindromic(i));
//            result.add(isGapful(i));

            System.out.println(i + " is " + result);


//            result = isOdd(i).concat(", ")
//                    .concat(isBuzz(i)).concat(" ,")
//                    .concat(isDuck(i)).concat(" ,")
//                    .concat(isEven(i)).concat(" ,")
//                    .concat(isPalindromic(i)).concat(" ,")
//                    .concat(isGapful(i));
//            System.out.println(i + " is " + result);
        }


    }
}
