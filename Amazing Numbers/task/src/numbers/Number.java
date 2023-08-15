package numbers;

public class Number {
    private long chosenNumber;
    private long repeats;
    private Property properties[];

    public Number() {
    }

    public Number(long number) {
        this.chosenNumber = number;
    }

    public Number(long number, long repeats) {
        this.chosenNumber = number;
        this.repeats = repeats;
    }


    public Number(long chosenNumber, long repeats, Property[] properties) {
        this.chosenNumber = chosenNumber;
        this.repeats = repeats;
        this.properties = properties;
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

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }
}
