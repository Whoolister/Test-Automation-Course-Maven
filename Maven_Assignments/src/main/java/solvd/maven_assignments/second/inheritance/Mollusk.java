package solvd.maven_assignments.second.inheritance;

import java.util.Random;

public class Mollusk extends Invertebrate implements Ectothermy {
    public Mollusk() {
        super("Gills",
                (new Random()).nextInt(20) < 10 ? "None" : "Tentacles",
                (new Random()).nextInt(20) < 10 ? "None" : "High",
                (new Random()).nextInt(20) < 10 ? "Carnivorous" : "Omnivorous");

        evolve("Jet Propulsion");
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may limit their physical capabilities.");
    }

    @Override
    public String toString() {
        return "Mollusk [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
