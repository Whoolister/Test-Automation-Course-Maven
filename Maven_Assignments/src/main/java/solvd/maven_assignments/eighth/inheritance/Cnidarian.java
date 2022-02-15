package solvd.maven_assignments.eighth.inheritance;

import solvd.maven_assignments.eighth.enums.*;
import solvd.maven_assignments.eighth.interfaces.IEctothermy;
import solvd.maven_assignments.eighth.interfaces.ISwarm;
import solvd.maven_assignments.eighth.utilities.Randomizer;

import java.util.Random;

public class Cnidarian extends Invertebrate implements IEctothermy, ISwarm {
    public Cnidarian() {
        super(Respiration.SKIN_DIFFUSION, new Random().nextInt(2) < 1 ? Locomotion.FINNED : Locomotion.NONE,
                Intelligence.NONE, Diet.CARNIVOROUS, CyrcadianRythm.METATURNAL);

        evolve(SpecialTrait.HYDROSKELETON);
        evolve(SpecialTrait.DEADLY_POISON);
        evolve(SpecialTrait.BIOLUMINESCENCE);

        // RANDOMIZES THE MISSING GENETIC MATERIAL
        this.genes = Randomizer.nucleotideRandomizer(genes);
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
        return "Cnidaria [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
                + this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet
                + " | Cyrcadian Rythm: " + this.cyrcadianRythm + "]";
    }
}
