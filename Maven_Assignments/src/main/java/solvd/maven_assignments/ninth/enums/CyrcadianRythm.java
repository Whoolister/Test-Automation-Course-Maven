package solvd.maven_assignments.ninth.enums;

public enum CyrcadianRythm {
    DIURNAL("This being remains active while the sun stays up, useful at staying safe while the light reveals all."),
    METATURNAL("This being has a highly irregular sleeping pattern, making it hard to avoid or hunt."),
    CREPUSCULAR("This being is active at dawn and dusk, never fully exposed but never fully in the dark."),
    NOCTURNAL("This being is active at night, and goes to sleep during the day, fit for hiding and ambushing alike."),
    NONE("This being rarely needs more than a few minutes of sleep a day.");

    private final String description;

    CyrcadianRythm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
