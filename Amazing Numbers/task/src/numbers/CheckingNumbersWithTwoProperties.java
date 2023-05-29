package numbers;

public class CheckingNumbersWithTwoProperties {

    static long[] selectingTwoProperties(Number number, Property firstProperty, Property secondProperty) {
        int counter = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] selectedNumbers = new long[(int) repeat];


        do {
            if (checkingFirstProperty(number, firstProperty)
                    && checkingSecondProperty(number, secondProperty)) {
                selectedNumbers[counter] = numberUnderCheck;
                counter++;
            }
            numberUnderCheck++;
            number.setChosenNumber(numberUnderCheck);
        } while (counter != repeat);
        return selectedNumbers;
    }

    private static boolean checkingNumber(Number number, Property property) {
        boolean propertyOk = false;
        switch (property) {
            case EVEN -> propertyOk = CheckingNumber.isEven(number);
            case ODD -> propertyOk = CheckingNumber.isOdd(number);
            case BUZZ -> propertyOk = CheckingNumber.isBuzz(number);
            case DUCK -> propertyOk = CheckingNumber.isDuck(number);
            case PALINDROMIC -> propertyOk = CheckingNumber.isPalindromic(number);
            case GAPFUL -> propertyOk = CheckingNumber.isGapful(number);
            case SPY -> propertyOk = CheckingNumber.isSpy(number);
            case SQUARE -> propertyOk = CheckingNumber.isSquare(number);
            case SUNNY -> propertyOk = CheckingNumber.isSunny(number);
            case JUMPING -> propertyOk = CheckingNumber.isJumping(number);
        }
        return propertyOk;
    }

    private static boolean checkingFirstProperty(Number number, Property property) {
        return checkingNumber(number, number.getFirstProperty());
    }

    private static boolean checkingSecondProperty(Number number, Property property) {
        return checkingNumber(number, number.getSecondProperty());
    }

}
