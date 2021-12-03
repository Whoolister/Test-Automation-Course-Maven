package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.enums.CyrcadianRythm;
import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;
import eighth_solvd_assignment.enums.SpecialTrait;

public abstract class Vertebrate extends Animal {
	protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm);

		evolve(SpecialTrait.ENDOSKELETON);
	}

	protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
	}
}
