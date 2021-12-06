package ninth_solvd_assignment.inheritance;

import ninth_solvd_assignment.enums.CyrcadianRythm;
import ninth_solvd_assignment.enums.Diet;
import ninth_solvd_assignment.enums.Intelligence;
import ninth_solvd_assignment.enums.Locomotion;
import ninth_solvd_assignment.enums.Respiration;

public class Hybrid extends Animal {
	public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
	}

	@Override
	public String toString() {
		return "Hybrid [Name: " + getName() + " | Respiration: " + getRespiration() + " | Locomotion: "
				+ getLocomotion() + " | Intelligence: " + getIntelligence() + " | Diet: " + getDiet()
				+ " | Cyrcadian Rythm: " + getCyrcadianRythm() + "]";
	}
}
