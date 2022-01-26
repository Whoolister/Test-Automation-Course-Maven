package sixth_solvd_assignment.enums;

public enum BaseStat {
    MAX_HEALTH("Maximum amount of HP this creature can own at any given moment."),
    HEALTH_POINTS("The amount of hitpoints you can take out of this creature before it perishes."),
    MAX_ENERGY("Maximum amount of EP this creature can own at any given moment."),
    ENERGY_POINTS("The amount of attacks this creature can dish out before falling exhausted."),
    SPEED("The stat that defines wether this creature attacks first or last."),
    HIT_ROLLS("The amount of hits this creature can dish out per turn."),
    HIT_DAMAGE("The amount of damage dealt per hit by this creature."),
    CRITICAL_CHANCE("The chance that this creature will score a critical hit, doubling their damage."),
    EVASION_CHANCE("The chance that this creature will dodge an incoming attack."),
    DEFENSE("The amount of damage points this creature negates out of every attack.");

    private final String description;

    BaseStat(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
