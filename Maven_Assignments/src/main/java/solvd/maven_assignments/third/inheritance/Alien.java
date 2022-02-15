package solvd.maven_assignments.third.inheritance;

import java.util.Random;

public final class Alien extends Animal {
    public Alien() {
        super((new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Lungs" : "Gills") : "Skin Diffusion",
                //I know this particular piece of code is hell to read through, I was just testing a possibility
                (new Random()).nextInt(70) < 30 ? ((new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Bipedal" : "Quadrupedal") : "Multi-Legged") : ((new Random()).nextInt(40) < 20 ? ((new Random()).nextInt(20) < 10 ? "Winged" : "Finned") : ((new Random()).nextInt(20) < 10 ? "Tentacles" : "None")),
                (new Random()).nextInt(70) < 30 ? ((new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Population Based" : "None") : "Some") : ((new Random()).nextInt(40) < 20 ? ((new Random()).nextInt(20) < 10 ? "Intermediate" : "High") : ((new Random()).nextInt(20) < 10 ? "Sapient" : "Eldritch")),
                (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Herbivore" : "Carnivore") : "Omnivore");
    }

    @Override
    public String toString() {
        return "Alien [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
