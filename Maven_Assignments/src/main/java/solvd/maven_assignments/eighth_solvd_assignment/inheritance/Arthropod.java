package eighth_solvd_assignment.inheritance;

import java.util.Random;

import eighth_solvd_assignment.enums.CyrcadianRythm;
import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;
import eighth_solvd_assignment.enums.SpecialTrait;
import eighth_solvd_assignment.interfaces.IAgriculture;
import eighth_solvd_assignment.interfaces.IEctothermy;
import eighth_solvd_assignment.interfaces.ISwarm;
import eighth_solvd_assignment.utilities.Randomizer;

public class Arthropod extends Invertebrate implements IEctothermy, IAgriculture, ISwarm {
	private static boolean hardened = true;

	public Arthropod() {
		super(Respiration.SKIN_DIFFUSION, new Random().nextInt(2) < 1 ? Locomotion.WINGED : Locomotion.MULTI_LEGGED,
				new Random().nextInt(2) < 1 ? Intelligence.POPULATION_BASED : Intelligence.SOME,
				new Random().nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS,
				new Random().nextInt(3) < 2
						? new Random().nextInt(2) < 1 ? CyrcadianRythm.NOCTURNAL : CyrcadianRythm.NONE
						: CyrcadianRythm.DIURNAL);

		evolve(SpecialTrait.EXOSKELETON);
		evolve(SpecialTrait.IRRITANT_STINGS);
		evolve(SpecialTrait.COMPOUND_EYES);

		// RANDOMIZES THE MISSING GENETIC MATERIAL
		this.genes = Randomizer.nucleotideRandomizer(genes);
	}

	public Arthropod(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
	}

	public final String molt() {
		if (hardened) {
			// LAMBDA IMPLEMENTATION
			new Thread(() -> {
				try {
					Arthropod.setHardened(false);
					Thread.sleep(35000);
					Arthropod.setHardened(true);
				} catch (InterruptedException e) {
					// Nothing
				}
			}).start();

			return "A successful molt! Now, to hide and wait for the body to harden...";
		} else {
			return "It isn't even done hardening from it's last molt!";
		}
	}

	public static final boolean getHardened() {
		return hardened;
	}

	public static final void setHardened(boolean input) {
		hardened = input;
	}

	@Override
	public String congregate() {
		return "This being can join into medium to large groups of it's own species, sometimes to devastating effect on the environment.";
	}

	@Override
	public String cultivate() {
		if (this.intelligence == Intelligence.SOME) {
			return "This being can participate in a mutualistic relationship with different plant species, protecting them in exchange for a steady source of nutrition.";
		} else {
			return "This being dedicates a part of its colony to feeding and growing nutritious mycelium, although it may not understand what it's really doing.";
		}
	}

	@Override
	public String raiseAnimals() {
		if (this.intelligence == Intelligence.SOME) {
			return "This being doesn't yet have the capacity to raise other animals, maybe in a further evolution.\n";
		} else {
			return "This being can enter a mutualistic relationship with certain other species, by protecting them and feeding on their residues.\n";
		}
	}

	@Override
	public String regulateTemperature() {
		return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.\n";
	}

	@Override
	public String toString() {
		return "Arthropod [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
				+ this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet
				+ " | Cyrcadian Rythm: " + this.cyrcadianRythm + "]";
	}
}
