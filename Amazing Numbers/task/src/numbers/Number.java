package numbers;

public class Number {
    long number;
    long repeats;
    Property property;



    public Number(long number) {
        this.number = number;
    }

    public Number(long number, long repeats) {
        this.number = number;
        this.repeats = repeats;
    }

    public Number(long number, long repeats, Property property) {
        this.number = number;
        this.repeats = repeats;
        this.property = property;
    }
}
