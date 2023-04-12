package numbers;

public class Number {
    private long chosenNumber;
    private long repeats;
    private Property firstProperty;
    private Property secondProperty;

    public Number() {
    }

    public Number(long number) {
        this.chosenNumber = number;
    }

    public Number(long number, long repeats) {
        this.chosenNumber = number;
        this.repeats = repeats;
    }

    public Number(long number, long repeats, Property firstProperty) {
        this.chosenNumber = number;
        this.repeats = repeats;
        this.firstProperty = firstProperty;
    }

    public Number(long chosenNumber, long repeats, Property firstProperty, Property secondProperty) {
        this.chosenNumber = chosenNumber;
        this.repeats = repeats;
        this.firstProperty = firstProperty;
        this.secondProperty = secondProperty;
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

    public Property getFirstProperty() {
        return firstProperty;
    }

    public void setFirstProperty(Property firstProperty) {
        this.firstProperty = firstProperty;
    }

    public Property getSecondProperty() {
        return secondProperty;
    }

    public void setSecondProperty(Property secondProperty) {
        this.secondProperty = secondProperty;
    }
}
