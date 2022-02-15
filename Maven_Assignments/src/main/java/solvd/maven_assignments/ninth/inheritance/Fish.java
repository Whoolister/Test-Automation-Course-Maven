package solvd.maven_assignments.ninth.inheritance;

import solvd.maven_assignments.ninth.enums.*;
import solvd.maven_assignments.ninth.interfaces.IEctothermy;
import solvd.maven_assignments.ninth.interfaces.ISwarm;

import java.util.Random;

public class Fish extends Vertebrate implements IEctothermy, ISwarm {
    private final String tailPlan;

    public Fish() {
        super(Respiration.GILLS, Locomotion.FINNED,
                new Random().nextInt(2) < 1 ? Intelligence.SOME : Intelligence.INTERMEDIATE,
                new Random().nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS,
                new Random().nextInt(2) < 1 ? CyrcadianRythm.DIURNAL : CyrcadianRythm.CREPUSCULAR);

        tailPlan = (new Random()).nextInt(4) < 3 ? new Random().nextInt(2) < 1 ? "Heterocercal" : "Protocercal"
                : new Random().nextInt(2) < 1 ? "Homoceral" : "Diphyceral";

        evolve(SpecialTrait.SCALED_BODY);
        evolve(SpecialTrait.HYDRODYNAMISM);
        evolve(SpecialTrait.UNDERWATER_VISION);
    }

    public Fish(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);

        tailPlan = (new Random()).nextInt(4) < 3 ? new Random().nextInt(2) < 1 ? "Heterocercal" : "Protocercal"
                : new Random().nextInt(2) < 1 ? "Homoceral" : "Diphyceral";
    }

    @Override
    public String congregate() {
        return "This being forms massive groups of it's own species, known as schools, to have a better chance at surviving attacks from predators.\n";
    }

    @Override
    public String regulateTemperature() {
        return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.\n";
    }

    @Override
    public String toString() {
        return "Fish [Name: " + getName() + " | Respiration: " + getRespiration() + " | Locomotion: " + getLocomotion()
                + " | Intelligence: " + getIntelligence() + " | Diet: " + getDiet() + " | Cyrcadian Rythm: "
                + getCyrcadianRythm() + " | Tail Plan: " + tailPlan + "]";
    }
}
