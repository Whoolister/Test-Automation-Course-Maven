package ninth_solvd_assignment.inheritance;

import java.util.Random;

import ninth_solvd_assignment.enums.CyrcadianRythm;
import ninth_solvd_assignment.enums.Diet;
import ninth_solvd_assignment.enums.Intelligence;
import ninth_solvd_assignment.enums.Locomotion;
import ninth_solvd_assignment.enums.Respiration;
import ninth_solvd_assignment.enums.SpecialTrait;
import ninth_solvd_assignment.interfaces.IEctothermy;
import ninth_solvd_assignment.interfaces.ISwarm;

public class Cnidarian extends Invertebrate implements IEctothermy, ISwarm {
	public Cnidarian() {
		super(Respiration.SKIN_DIFFUSION, new Random().nextInt(2) < 1 ? Locomotion.FINNED : Locomotion.NONE,
				Intelligence.NONE, Diet.CARNIVOROUS, CyrcadianRythm.METATURNAL);

		evolve(SpecialTrait.HYDROSKELETON);
		evolve(SpecialTrait.DEADLY_POISON);
		evolve(SpecialTrait.BIOLUMINESCENCE);
	}

	public Cnidarian(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
	}

	@Override
	public String congregate() {
		return "This being tends to create large swarms of its own species, giving them a greater chance of surviving attacks.\n";

	}

	@Override
	public String regulateTemperature() {
		return "This being depends on its surroundings having a viable temperature range to survive.\n";
	}

	@Override
	public String toString() {
		return "Cnidaria [Name: " + getName() + " | Respiration: " + getRespiration() + " | Locomotion: "
				+ getLocomotion() + " | Intelligence: " + getIntelligence() + " | Diet: " + getDiet()
				+ " | Cyrcadian Rythm: " + getCyrcadianRythm() + "]";
	}
}
