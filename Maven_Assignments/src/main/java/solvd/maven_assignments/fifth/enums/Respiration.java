package enums;

public enum Respiration {
    LUNGS("This being takes air into their lungs, to then extract molecular oxygen from the atmoshpere."),
    GILLS("This being filters the water for oxygen, the stronger the water flow, the more efficient the oxygen intake."),
    SKIN_DIFFUSION("This being takes in air from the air through their skin, letting oxygen diffuse straight into their cells.");

    private final String description;

    Respiration(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
