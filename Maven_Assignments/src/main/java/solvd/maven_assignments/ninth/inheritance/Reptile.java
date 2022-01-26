package solvd.maven_assignments.ninth.inheritance;

import ninth_solvd_assignment.enums.*;
import solvd.maven_assignments.ninth.interfaces.IEctothermy;
import ninth_solvd_assignment.interfaces.IEndothermy;

import java.util.Random;

public class Reptile extends Vertebrate implements IEctothermy, IEndothermy {
    private final String bodyPlan;

    public Reptile() {
        super(Respiration.LUNGS, new Random().nextInt(2) < 1 ? Locomotion.QUADRUPEDAL : Locomotion.SLITHERING,
                Intelligence.SOME, new Random().nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS,
                new Random().nextInt(2) < 1 ? CyrcadianRythm.DIURNAL : CyrcadianRythm.NOCTURNAL);

        bodyPlan = new Random().nextInt(2) < 1 ? "Wide" : "Long";

        evolve(SpecialTrait.ROUGH_SCALES);
        evolve(SpecialTrait.COLD_BLOODED);
        evolve(SpecialTrait.DEADLY_VENOM);
    }

    public Reptile(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                   CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);

        bodyPlan = new Random().nextInt(2) < 1 ? "Wide" : "Long";
    }

    @Override
    public String produceHeat() {
        return "This being can increase their metabolism to exude greater amounts of energy, this may be a limiting factor to their physical ability.\n";
    }

    @Override
    public String releaseHeat() {
        return "This being needs to push excess heat out of their bodies through panting, sweating, or a mixture of both.\n";
    }

    @Override
    public String regulateTemperature() {
        return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.\n";
    }

    @Override
    public String toString() {
        return "Reptile [Name: " + getName() + " | Respiration: " + getRespiration() + " | Locomotion: "
                + getLocomotion() + " | Intelligence: " + getIntelligence() + " | Diet: " + getDiet()
                + " | Cyrcadian Rythm: " + getCyrcadianRythm() + " | Body Plan: " + bodyPlan + "]";
    }
}
