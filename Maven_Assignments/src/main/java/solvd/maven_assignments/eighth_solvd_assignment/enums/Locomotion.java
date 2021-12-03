package eighth_solvd_assignment.enums;

public enum Locomotion {
	BIPEDAL("This being walks on two legs, and a mostly upright posture."),
	QUADRUPEDAL("This being walks on four legs, possibly the most efficient method of terrestrial locomotion."),
	MULTI_LEGGED(
			"This being walks on a myriad of legs, allowing them to both walk and grip onto surfaces at the same time."),
	WINGED("This being can lift off the ground and soar!"),
	FINNED("This being swims through the water, using their fins."),
	TENTACLES("This being moves through the use of several prehensile arms, granting them unmatched versatility."),
	SLITHERING("This being lacks legs, and yet they propel themselves forwards by rythmic movements."),
	NONE("This being just... sorta stays there...");

	private String description;

	private Locomotion(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}
