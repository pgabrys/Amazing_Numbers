package numbers;

public class Number {
    long chosenNumber;
    long repeats;
    Property property;

    public Number() {
    }

    public Number(long number) {
        this.chosenNumber = number;
    }

    public Number(long number, long repeats) {
        this.chosenNumber = number;
        this.repeats = repeats;
    }

    public Number(long number, long repeats, Property property) {
        this.chosenNumber = number;
        this.repeats = repeats;
        this.property = property;
    }

    public long getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(long chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    public long getRepeats() {
        return repeats;
    }

    public void setRepeats(long repeats) {
        this.repeats = repeats;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
