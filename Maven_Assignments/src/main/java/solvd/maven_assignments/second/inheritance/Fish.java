package solvd.maven_assignments.second.inheritance;

import java.util.Random;

public class Fish extends Vertebrate implements Ectothermy {
    public Fish() {
        super("Gilled",
                "Finned",
                (new Random()).nextInt(20) < 10 ? "Low" : "Intermediate",
                (new Random()).nextInt(20) < 10 ? "Herbivorous" : "Carnivorous");

        evolve("Scaled Body");
        evolve("Hydrodynamism");
        evolve("Underwater Vision");
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.");
    }

    @Override
    public String toString() {
        return "Fish [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
