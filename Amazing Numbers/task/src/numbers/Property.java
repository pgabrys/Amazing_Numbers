package numbers;

public enum Property {
    EVEN("EVEN"), NEGATIVE_EVEN("-EVEN"),
    ODD("ODD"), NEGATIVE_ODD("-ODD"),
    BUZZ("BUZZ"), NEGATIVE_BUZZ("-BUZZ"),
    DUCK("DUCK"), NEGATIVE_DUCK("-DUCK"),
    PALINDROMIC("PALINDROMIC"), NEGATIVE_PALINDROMIC("-PALINDROMIC"),
    GAPFUL("GAPFUL"), NEGATIVE_GAPFUL("-GAPFUL"),
    SPY("SPY"), NEGATIVE_SPY("-SPY"),
    SQUARE("SQUARE"), NEGATIVE_SQUARE("-SQUARE"),
    SUNNY("SUNNY"), NEGATIVE_SUNNY("-SUNNY"),
    JUMPING("JUMPING"), NEGATIVE_JUMPING("-JUMPING"),
    HAPPY("HAPPY"), NEGATIVE_HAPPY("-HAPPY"),
    SAD("SAD"), NEGATIVE_SAD("-SAD");

    public final String label;

    Property (String label) { this.label = label; }

    @Override
    public String toString() { return label; }


    public String getLabel() {
        return label;
    }

    public static Property getPropertyFromString (String inputProperty) {
        Property property = null;
        for (Property value: values()) {
            if (value.label.equalsIgnoreCase(inputProperty)) {
                property = value;
            }
        }
        return property;
    }
}
