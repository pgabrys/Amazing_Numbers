package numbers;

import java.util.StringJoiner;

public class CheckingNumberWithProperty {

    static long selectingNumbers (String[] inputArray){
        long[] selectedNumbers;
        int counter = 0;
        long startNumber = Long.parseLong(inputArray[0]);
        long repeat = Long.parseLong(inputArray[1]);
        String propertyOnDemand = inputArray[2].toLowerCase();

        /**
         * Dupa tam a nie pętla "for" w tym switchu. Trzeba zmienić to na pętlę "do-while",
         * która będzie szukała liczb. Gdy liczba zostanie znaleziona, podbijamy "counter"
         * do momentu, aż zrówna się on z "repeat"
         */

        switch (propertyOnDemand) {
            case even:
                for (long i = 1; i <= repeat; i++) {

                }
            case odd:
                for (long i = 1; i <= repeat; i++) {

                }
            case buzz:
                for (long i = 1; i <= repeat; i++) {

                }
            case duck:
                for (long i = 1; i <= repeat; i++) {

                }
            case palindromic:
                for (long i = 1; i <= repeat; i++) {

                }
            case gapful:
                for (long i = 1; i <= repeat; i++) {

                }
            case spy:
                for (long i = 1; i <= repeat; i++) {

                }
        }

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
