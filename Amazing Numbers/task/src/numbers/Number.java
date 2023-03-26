package numbers;

public class Number {
    long number;
    long repeats;
    String property;


    String even = "EVEN";
    String odd = "ODD";
    String buzz = "BUZZ";
    String duck = "DUCK";
    String palindromic = "PALINDROMIC";
    String gapful = "GAPFUL";
    String spy = "SPY";

    public Number(long number) {
        assert (number >= 0) : "The first parameter should be a natural number or zero.";
        this.number = number;
    }

    public Number(long number, long repeats) {
        assert (number >= 0) : "The first parameter should be a natural number or zero.";
        assert (repeats > 0) : "The second parameter should be a natural number.";
        this.number = number;
        this.repeats = repeats;
    }

    public Number(long number, long repeats, String property) {
        assert (number >= 0) : "The first parameter should be a natural number or zero.";
        assert (repeats > 0) : "The second parameter should be a natural number.";
        assert (property.equals(even)
                || property.equals(odd))
                || property.equals(buzz)
                || property.equals(duck)
                || property.equals(palindromic)
                || property.equals(gapful)
                || property.equals(spy) : "The property " + property + " is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]";
        this.number = number;
        this.repeats = repeats;
        this.property = property;
    }
}
