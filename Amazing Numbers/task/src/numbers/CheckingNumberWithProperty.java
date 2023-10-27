package numbers;
import java.util.StringJoiner;

public class CheckingNumberWithProperty {



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
            if (CheckingMultipleNumbers.isSunny(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isSunny(x));
            }
            if (CheckingMultipleNumbers.isSquare(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isSquare(x));
            }
            if (CheckingMultipleNumbers.isJumping(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isJumping(x));
            }
            if (CheckingMultipleNumbers.isHappy(x).length() > 2) {
                result.add(CheckingMultipleNumbers.isHappy(x));
            }

            System.out.println(x + " is " + result);
        }
    }



}
