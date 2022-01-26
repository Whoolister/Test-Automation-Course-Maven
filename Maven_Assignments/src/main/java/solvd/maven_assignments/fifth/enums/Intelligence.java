package enums;

public enum Intelligence {
    POPULATION_BASED("This being is as smart as their kin are numerous, working off an eusocial network of pheromones and chemical trails."),
    NONE("*Elevator Music*"),
    SOME("This being is concerned only with matters of acquiring food, and staying away from predators."),
    INTERMEDIATE("This being can form social bonds, and even learn through trial and error."),
    HIGH("This being is a natural at complex problem solving, even going out of their way to satisfy a primal sense of curiosity."),
    SAPIENT("This being has no limit to their potential, and is capable of surpassing their biology, and start creating or advancing technology."),
    ELDRITCH("This being is, by all means, incomprehensible to mere creatures of the flesh.");

    private final String description;

    Intelligence(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
