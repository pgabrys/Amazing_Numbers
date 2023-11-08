package numbers;

public class CheckingRequest {

    static boolean isExclusive(Property[] properties, boolean notExclusive) {
        boolean even = false;
        boolean odd = false;
        boolean duck = false;
        boolean spy = false;
        boolean sunny = false;
        boolean square = false;
        boolean happy = false;
        boolean sad = false;
        boolean buzz = false;
        boolean palindromic = false;
        boolean gapful = false;
        boolean jumping = false;
        boolean negativeEven = false;
        boolean negativeOdd = false;
        boolean negativeDuck = false;
        boolean negativeSpy = false;
        boolean negativeSunny = false;
        boolean negativeSquare = false;
        boolean negativeHappy = false;
        boolean negativeSad = false;
        boolean negativeBuzz = false;
        boolean negativePalindromic = false;
        boolean negativeGapful = false;
        boolean negativeJumping = false;

        for (Property property : properties) {
            switch (property.label) {
                case "EVEN" -> even = true;
                case "ODD" -> odd = true;
                case "DUCK" -> duck = true;
                case "SPY" -> spy = true;
                case "SUNNY" -> sunny = true;
                case "SQUARE" -> square = true;
                case "HAPPY" -> happy = true;
                case "SAD" -> sad = true;
                case "BUZZ" -> buzz = true;
                case "PALINDROMIC" -> palindromic = true;
                case "GAPFUL" -> gapful = true;
                case "JUMPING" -> jumping = true;
                case "-EVEN" -> negativeEven = true;
                case "-ODD" -> negativeOdd = true;
                case "-DUCK" -> negativeDuck = true;
                case "-SPY" -> negativeSpy = true;
                case "-SUNNY" -> negativeSunny = true;
                case "-SQUARE" -> negativeSquare = true;
                case "-HAPPY" -> negativeHappy = true;
                case "-SAD" -> negativeSad = true;
                case "-BUZZ" -> negativeBuzz = true;
                case "-PALINDROMIC" -> negativePalindromic = true;
                case "-GAPFUL" -> negativeGapful = true;
                case "-JUMPING" -> negativeJumping = true;

            }
        }

        if (even && odd) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
        } else if (duck && spy) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
        } else if (sunny && square) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                    "There are no numbers with these properties.");
        } else if (happy && sad) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                    "There are no numbers with these properties.");
        }else if (negativeDuck && negativeSpy) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]\n" +
                    "There are no numbers with these properties.");
        } else if (negativeSunny && negativeSquare) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [-SQUARE, -SUNNY]\n" +
                    "There are no numbers with these properties.");
        } else if (negativeHappy && negativeSad) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                    "There are no numbers with these properties.");
        } else if (negativeEven && negativeOdd) {
            notExclusive = false;
            System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]\n" +
                    "There are no numbers with these properties.");
        } else if (even && negativeEven) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [EVEN, -EVEN]\n" +
                "There are no numbers with these properties.");
    } else if (odd && negativeOdd) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [ODD, -ODD]\n" +
                "There are no numbers with these properties.");
    }else if (buzz && negativeBuzz) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [BUZZ, -BUZZ]\n" +
                "There are no numbers with these properties.");
    } else if (duck && negativeDuck) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [DUCK, -DUCK]\n" +
                "There are no numbers with these properties.");
    } else if (palindromic && negativePalindromic) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [PALINDROMIC, -PALINDROMIC]\n" +
                "There are no numbers with these properties.");
    } else if (gapful && negativeGapful) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [GAPFUL, -GAPFUL]\n" +
                "There are no numbers with these properties.");
    }else if (spy && negativeSpy) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [SPY, -SPY]\n" +
                "There are no numbers with these properties.");
    } else if (sunny && negativeSunny) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [SUNNY, -SUNNY]\n" +
                "There are no numbers with these properties.");
    }else if (square && negativeSquare) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [SQUARE, -SQUARE]\n" +
                "There are no numbers with these properties.");
    } else if (jumping && negativeJumping) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [JUMPING, -JUMPING]\n" +
                "There are no numbers with these properties.");
    } else if (sad && negativeSad) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                "There are no numbers with these properties.");
    } else if (happy && negativeHappy) {
        notExclusive = false;
        System.out.println("The request contains mutually exclusive properties: [HAPPY, -HAPPY]\n" +
                "There are no numbers with these properties.");
    }
        return notExclusive;
    }
}
