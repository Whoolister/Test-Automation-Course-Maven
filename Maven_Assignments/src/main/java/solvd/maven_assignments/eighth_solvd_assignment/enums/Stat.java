package eighth_solvd_assignment.enums;

public enum Stat {
	MAX_HEALTH("Maximum amount of HP this creature can own at any given moment."),
	MAX_ENERGY("Maximum amount of EP this creature can own at any given moment."),
	SPEED("The stat that defines wether this creature attacks first or last, and decides how apt it is at dodging."),
	HIT_ROLLS("The amount of hits this creature can dish out per turn."),
	HIT_DAMAGE("The amount of damage dealt per hit by this creature."),
	CRITICAL_CHANCE("The chance that this creature will score a critical hit, doubling their damage."),
	DEFENSE("The amount of damage points this creature negates out of every attack.");

	private String description;

	private Stat(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
