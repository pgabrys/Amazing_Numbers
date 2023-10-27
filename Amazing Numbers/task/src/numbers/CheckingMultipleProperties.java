package numbers;

public class CheckingMultipleProperties {
    static long[] multipleProperties(Number number, Property properties[]) {
        int counterNumbers = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] selectedNumbers = new long[(int) repeat];
        boolean dadad = false;

        do {
            int counterProperties = 0;
            for (Property property : properties) {

                /**
                 * Wstępny zamysł, to stworzenie if'a, który będzie sprawdzał, czy w nazwie właściwości jest '-',
                 * a następnie czy liczba spełnia daną właściwość.
                 * Jeśli tak, to pętla ma być przerwana (iteracja) i ma być sprawdzana następna liczba
                 */
//                if (property.getLabel().charAt(0) == '-') {
//                    if (!checkingNumber(number, property)) {
//                        counterProperties++;
//                    }
//                } else {
//                    if (checkingNumber(number, property)) {
//                        counterProperties++;
//                    }
//                }

                if (checkingNumber(number, property)) {
                    if (property.getLabel().charAt(0) == '-') {
                        break;
                    } else {
                        counterProperties++;
                    }

                }

                if (counterProperties == properties.length) {
                    selectedNumbers[counterNumbers] = numberUnderCheck;
                    counterNumbers++;
                }
            }
            numberUnderCheck++;
            number.setChosenNumber(numberUnderCheck);

            if (counterNumbers == repeat) {
                dadad = true;
            }
        } while (!dadad);

        return selectedNumbers;
    }

    private static boolean checkingNumber(Number number, Property property) {
        boolean propertyOk = false;
        switch (property) {
            case EVEN, NEGATIVE_EVEN -> propertyOk = CheckingNumber.isEven(number);
            case ODD, NEGATIVE_ODD -> propertyOk = CheckingNumber.isOdd(number);
            case BUZZ, NEGATIVE_BUZZ -> propertyOk = CheckingNumber.isBuzz(number);
            case DUCK, NEGATIVE_DUCK -> propertyOk = CheckingNumber.isDuck(number);
            case PALINDROMIC, NEGATIVE_PALINDROMIC -> propertyOk = CheckingNumber.isPalindromic(number);
            case GAPFUL, NEGATIVE_GAPFUL -> propertyOk = CheckingNumber.isGapful(number);
            case SPY, NEGATIVE_SPY -> propertyOk = CheckingNumber.isSpy(number);
            case SQUARE, NEGATIVE_SQUARE -> propertyOk = CheckingNumber.isSquare(number);
            case SUNNY, NEGATIVE_SUNNY -> propertyOk = CheckingNumber.isSunny(number);
            case JUMPING, NEGATIVE_JUMPING -> propertyOk = CheckingNumber.isJumping(number);
            case HAPPY, NEGATIVE_HAPPY -> propertyOk = CheckingNumber.isHappy(number);
            case SAD, NEGATIVE_SAD -> propertyOk = !CheckingNumber.isHappy(number);
        }
        return propertyOk;
    }

}
