package numbers;

public class CheckingRequest {

    static boolean isExclusive(Property[] properties, boolean notExclusive) {
        boolean even = false;
        boolean odd = false;
        boolean duck = false;
        boolean spy = false;
        boolean sunny = false;
        boolean square = false;
        for (int i = 0; i < properties.length; i++){
            switch (properties[i]) {
                case EVEN -> {even = true;}
                case ODD -> {odd = true;}
                case DUCK -> {duck = true;}
                case SPY -> {spy = true;}
                case SUNNY -> {sunny = true;}
                case SQUARE -> {square = true;}
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
        }
        return notExclusive;
    }
}
