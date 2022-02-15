package solvd.maven_assignments.fifth.inheritance;

import solvd.maven_assignments.fifth.enums.*;
import solvd.maven_assignments.fifth.interfaces.IEctothermy;
import solvd.maven_assignments.fifth.interfaces.ISwarm;

import java.util.Random;

public class Cnidarian extends Invertebrate implements IEctothermy, ISwarm {
    public Cnidarian() {
        super(Respiration.SKIN_DIFFUSION,
                (new Random()).nextInt(20) < 10 ? Locomotion.FINNED : Locomotion.NONE,
                Intelligence.NONE,
                Diet.CARNIVOROUS);

        evolve(SpecialTrait.HYDROSKELETON);
        evolve(SpecialTrait.DEADLY_POISON);
        evolve(SpecialTrait.BIOLUMINESCENCE);
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
        return "Cnidaria [Name: " + this.name +
                " | Rank: " + this.rank +
                " | Respiration: " + this.respiration +
                " | Locomotion: " + this.locomotion +
                " | Intelligence: " + this.intelligence +
                " | Diet: " + this.diet + "]";
    }
}
