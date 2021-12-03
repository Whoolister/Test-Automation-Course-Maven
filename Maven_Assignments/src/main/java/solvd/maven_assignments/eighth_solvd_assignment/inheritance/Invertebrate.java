package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;
import eighth_solvd_assignment.enums.SpecialTrait;

public abstract class Invertebrate extends Animal {
	protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
		super(respiration, locomotion, intelligence, diet);

		evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
	}

	protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			String geneSequence) {
		super(respiration, locomotion, intelligence, diet);

	}
}
