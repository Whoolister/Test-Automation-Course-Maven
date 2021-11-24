package sixth_solvd_assignment.inheritance;

import sixth_solvd_assignment.enums.Diet;
import sixth_solvd_assignment.enums.Intelligence;
import sixth_solvd_assignment.enums.Locomotion;
import sixth_solvd_assignment.enums.Respiration;
import sixth_solvd_assignment.enums.SpecialTrait;

public abstract class Vertebrate extends Animal {
	protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
		super(respiration, locomotion, intelligence, diet);

		evolve(SpecialTrait.ENDOSKELETON);
	}
}
