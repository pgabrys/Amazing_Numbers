package numbers;

public class CheckingMultipleProperties {
    static long[] multipleProperties(Number number, Property properties[]) {
        int counterNumbers = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] selectedNumbers = new long[(int) repeat];
        boolean dadad = false;

        do {
            for (Property property : properties) {
                int counterProperties = 0;
                if (checkingNumber(number, property)) {
                    counterProperties++;
                }

                if (counterProperties == properties.length) {
                    selectedNumbers[counterNumbers] = numberUnderCheck;
                    counterNumbers++;
                }

                numberUnderCheck++;
                number.setChosenNumber(numberUnderCheck);
            }

            if (counterNumbers == repeat) {
                dadad = true;
            }
        } while (!dadad);

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

}
