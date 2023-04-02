package numbers;

import java.util.Arrays;
import java.util.StringJoiner;

public class CheckingNumberWithProperty {

    static long[] selectingNumbers (Number number, Property property){
        int counter = 0;
        long numberUnderCheck = number.chosenNumber;
        long repeat = number.repeats;
        long[] selectedNumbers = new long[(int) repeat];

        switch (property) {
            case EVEN -> {
                do {
                    if (numberUnderCheck % 2 == 0) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case ODD -> {
                do {
                    if (numberUnderCheck % 2 != 0) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case BUZZ -> {
                do {
                    long firstPart = numberUnderCheck / 10;
                    long secondPart = numberUnderCheck % 10;
                    long secondPartMultiply = secondPart * 2;
                    long subtract = firstPart - secondPartMultiply;

                    if (subtract % 7 == 0 || secondPart == 7) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case DUCK -> {
                do {
                    if (String.valueOf(numberUnderCheck).contains("0")) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case PALINDROMIC -> {
                do {
                    String numberToString = String.valueOf(numberUnderCheck);
                    StringBuffer reversedNumber = new StringBuffer(numberToString);
                    String reversed = reversedNumber.reverse().toString();

                    if (numberToString.equals(reversed)) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case GAPFUL -> {
                do {
                    String stringNumber = Long.toString(numberUnderCheck);
                    String[] parts = stringNumber.split("");
                    long isGapful = -1;

                    if (stringNumber.length() > 2) {
                        String dividedBy = parts[0] + parts[parts.length - 1];
                        long dividedByNumber = Long.parseLong(dividedBy);
                        isGapful = numberUnderCheck % dividedByNumber;
                    }
                    if (isGapful == 0) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
            case SPY -> {
                do {
                    long sum;
                    long product = 1;
                    String stringNumber = Long.toString(numberUnderCheck);
                    String[] parts = stringNumber.split("");
                    long[] digits = new long[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        digits[i] = Long.parseLong(parts[i]);
                    }
                    sum = Arrays.stream(digits).sum();

                    for (long digit : digits) {
                        product = product * digit;
                    }

                    if (sum == product) {
                        selectedNumbers[counter] = numberUnderCheck;
                        counter++;
                    }
                    numberUnderCheck++;
                } while (counter != repeat);
            }
        }
        return selectedNumbers;
    }

    static void properties3 (long[] selectedNumbers){

        for (long x : selectedNumbers) {
            StringJoiner result = new StringJoiner(", ");
            if (CheckingMultipleNumbers.isEven(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isEven(x));
            }
            if (CheckingMultipleNumbers.isOdd(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isOdd(x));
            }
            if (CheckingMultipleNumbers.isBuzz(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isBuzz(x));
            }
            if (CheckingMultipleNumbers.isDuck(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isDuck(x));
            }
            if (CheckingMultipleNumbers.isPalindromic(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isPalindromic(x));
            }
            if (CheckingMultipleNumbers.isGapful(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isGapful(x));
            }
            if (CheckingMultipleNumbers.isSpy(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isSpy(x));
            }

            System.out.println(x + " is " + result);
        }
    }



}
