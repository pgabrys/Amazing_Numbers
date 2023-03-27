package numbers;

import java.util.Arrays;
import java.util.StringJoiner;

public class CheckingNumberWithProperty {

    static long[] selectingNumbers (String[] inputArray, Property property){
        int counter = 0;
        long startNumber = Long.parseLong(inputArray[0]);
        long number = startNumber;
        long repeat = Long.parseLong(inputArray[1]);
        long[] selectedNumbers = new long[(int) repeat];

        switch (property) {
            case EVEN:
                do {
                    if (number % 2 == 0) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case ODD:
                do {
                    if (number % 2 != 0) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case BUZZ:
                do {
                    long firstPart = number / 10;
                    long secondPart = number % 10;
                    long secondPartMultiply = secondPart * 2;
                    long subtract = firstPart - secondPartMultiply;

                    if (subtract % 7 == 0 || secondPart == 7) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case DUCK:
                do {
                    if (String.valueOf(number).contains("0")) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case PALINDROMIC:
                do {
                    String numberToString = String.valueOf(number);
                    StringBuffer reversedNumber = new StringBuffer(numberToString);
                    String reversed = reversedNumber.reverse().toString();

                    if (numberToString.equals(reversed)) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case GAPFUL:
                do {
                    long number = startNumber;
                    String stringNumber = Long.toString(number);
                    String[] parts = stringNumber.split("");
                    long isGapful = -1;

                    if (stringNumber.length() > 2) {
                        String dividedBy = parts[0] + parts[parts.length - 1];
                        long dividedByNumber = Long.parseLong(dividedBy);
                        isGapful = number % dividedByNumber;
                    }
                    if (isGapful == 0) {
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
            case SPY:
                do {
                    long number = startNumber;
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
                        selectedNumbers[counter] = number;
                        counter++;
                    }
                    number++;
                } while (counter != repeat);
                break;
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
