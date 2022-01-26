package solvd.maven_assignments.second.inheritance;

import java.util.Random;

public class Arthropod extends Invertebrate implements Ectothermy {
    public Arthropod() {
        super("Skin Diffusion",
                (new Random()).nextInt(20) < 10 ? "Winged" : "Multi-Legged",
                (new Random()).nextInt(20) < 10 ? "Some" : "Population Based",
                (new Random()).nextInt(20) < 10 ? "Carnivorous" : "Herbivorous");

        evolve("Exoskeleton");
        evolve("Limitless Offspring");
        evolve("Compound Eyes");
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.");
    }

    @Override
    public String toString() {
        return "Arthropod [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
