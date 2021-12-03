package ninth_solvd_assignment.inheritance;

import ninth_solvd_assignment.enums.CyrcadianRythm;
import ninth_solvd_assignment.enums.Diet;
import ninth_solvd_assignment.enums.Intelligence;
import ninth_solvd_assignment.enums.Locomotion;
import ninth_solvd_assignment.enums.Respiration;
import ninth_solvd_assignment.enums.SpecialTrait;

public abstract class Invertebrate extends Animal {
	protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm);

		evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
	}

	protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);

	}
}
