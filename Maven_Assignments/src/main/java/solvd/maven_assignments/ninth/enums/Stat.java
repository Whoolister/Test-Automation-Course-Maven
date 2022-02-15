package solvd.maven_assignments.ninth.enums;

public enum Stat {
    HEALTH_POINTS("The amount of damage this creature can take."),
    ENERGY_POINTS("The amount of attacks this creature can dish out."),
    SPEED("Defines the order of attack between creatures, and marks how apt it is at dodging."),
    HIT_ROLLS("The amount of hits this creature can deal  per turn."),
    HIT_DAMAGE("The amount of damage dealt per hit by this creature."),
    CRITICAL_CHANCE("The chance that this creature will score a critical hit, doubling their damage."),
    DEFENSE("The amount of damage points this creature negates out of every attack.");

    private final String description;

    Stat(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
