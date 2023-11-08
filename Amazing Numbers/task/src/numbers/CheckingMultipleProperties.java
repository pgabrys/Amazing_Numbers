package numbers;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CheckingMultipleProperties {
    static long[] multipleProperties(Number number, Property properties[]) {
        int counterNumbers = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] selectedNumbers = new long[(int) repeat];
        boolean finished = false;
        int howManyPropertyWithMinus = 0;

        for (Property property : properties) {
            if (property.getLabel().charAt(0) == '-') {
                howManyPropertyWithMinus++;
            }
        }

        do {
            int counterProperties = 0;
            for (Property property : properties) {

                if (checkingNumber(number, property)) {
                    if (property.getLabel().charAt(0) == '-') {
                        break;
                    } else {
                        counterProperties++;
                    }
                }

                if (counterProperties == properties.length - howManyPropertyWithMinus) {
                    selectedNumbers[counterNumbers] = numberUnderCheck;
                    counterNumbers++;
                }
            }
            numberUnderCheck++;
            number.setChosenNumber(numberUnderCheck);

            if (counterNumbers == repeat) {
                finished = true;
            }
        } while (!finished);

        return selectedNumbers;
    }

    static Set<Long> multipleProperties2(Number number, Property properties[]) {
        Set<Long> selectedNumbers = new TreeSet<Long>();
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        boolean finished = false;

        int howManyPropertyWithMinus = 0;

        for (Property property : properties) {
            if (property.getLabel().charAt(0) == '-') {
                howManyPropertyWithMinus++;
            }
        }


        /**
         * Z jakichs powodów, poniższy kod po modyfikacji znowu nie działa. Chuj wie dlaczego.
         * Wiec albo poświęcić czas na debugowanie, albo, jak już zaczłąłem, wdrożyć pomysł z listą:
         * - robić najpierw zgrubne sprawdzenie liczby, gdy spełni wszystkie warunki dodać ją do listy
         * - ale jak będzie spełniać minusową wartość, to następnie ją z tej listy usunąć
         * Najprawdopoboniej wiąże się to z koniecznością podwójnego przechodzenia/sprawdzania
         * <p>
         * Tricky part to w sprawdzaniu wywołać kolejne przechodzenie po liczbach, a nastepnie po właściwościach i ich
         * sprawdzania (lub na odwrót).
         */

        do {
            boolean negativePropertyFound = false;
            int counterProperties = 0;

            for (Property property : properties) {
                boolean propertyMet = false;
                if (checkingNumber(number, property)) {
                    propertyMet = true;
                    if (property.getLabel().charAt(0) == '-') {
                        negativePropertyFound = true;
                    } else {
                        counterProperties++;
                    }
                }

                if (counterProperties == properties.length - howManyPropertyWithMinus) {
                    selectedNumbers.add(numberUnderCheck);
                    if (negativePropertyFound) {
                        selectedNumbers.remove(numberUnderCheck);
                    }
                }
            }
            numberUnderCheck++;
            number.setChosenNumber(numberUnderCheck);

            if (selectedNumbers.size() == repeat) {
                finished = true;
            }
        } while (!finished);

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
