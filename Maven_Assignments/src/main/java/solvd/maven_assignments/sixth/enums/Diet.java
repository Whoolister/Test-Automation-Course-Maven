package solvd.maven_assignments.sixth.enums;

public enum Diet {
    HERBIVOROUS("This being gets it's meals from plant matter."),
    CARNIVOROUS("This being only eats the remains of other animals."), OMNIVOROUS(
            "This being can feast on every type of organic matter, it's likely to have evolved with resilience as it's main strength.");

    private final String description;

    Diet(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
