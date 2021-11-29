package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;

public class Hybrid extends Animal {
	public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
		super(respiration, locomotion, intelligence, diet);
	}
}