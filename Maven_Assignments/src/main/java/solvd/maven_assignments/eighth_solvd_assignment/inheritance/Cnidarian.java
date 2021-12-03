package eighth_solvd_assignment.inheritance;

import java.util.Random;

import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;
import eighth_solvd_assignment.enums.SpecialTrait;
import eighth_solvd_assignment.interfaces.IEctothermy;
import eighth_solvd_assignment.interfaces.ISwarm;
import eighth_solvd_assignment.utilities.Randomizer;

public class Cnidarian extends Invertebrate implements IEctothermy, ISwarm {
	public Cnidarian() {
		super(Respiration.SKIN_DIFFUSION, (new Random()).nextInt(20) < 10 ? Locomotion.FINNED : Locomotion.NONE,
				Intelligence.NONE, Diet.CARNIVOROUS);

		evolve(SpecialTrait.HYDROSKELETON);
		evolve(SpecialTrait.DEADLY_POISON);
		evolve(SpecialTrait.BIOLUMINESCENCE);

		// RANDOMIZES THE MISSING GENETIC MATERIAL
		this.genes = Randomizer.nucleotideRandomizer(genes);
	}

	public Cnidarian(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			String geneSequence) {
		super(respiration, locomotion, intelligence, diet, geneSequence);
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
		return "Cnidaria [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
				+ this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet + "]";
	}
}
