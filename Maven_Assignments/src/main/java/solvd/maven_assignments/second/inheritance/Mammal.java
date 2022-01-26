package solvd.maven_assignments.second.inheritance;

import java.util.Random;

public class Mammal extends Vertebrate implements Endothermy {
    public Mammal() {
        super("Lungs",
                (new Random()).nextInt(20) < 10 ? "Quadrupedal" : "Finned",
                (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Intermediate" : "High") : "Sapient",
                (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Herbivorous" : "Carnivorous") : "Omnivorous");

        evolve("Fur");
        evolve("Four Chambered Heart");
        evolve("Live Births");
    }

    @Override
    public void produceHeat() {
        System.out.println("This being can increase their metabolism to exude greater amounts of energy, this may be a limiting factor to their physical ability.");
    }

    @Override
    public void releaseHeat() {
        System.out.println("This being needs to push excess heat out of their bodies through panting, sweating, or a mixture of both.");
    }

    @Override
    public String toString() {
        return "Mammal [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
