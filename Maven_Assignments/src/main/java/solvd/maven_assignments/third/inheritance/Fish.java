package inheritance;

import java.util.Random;

public class Fish extends Vertebrate implements Ectothermy, Swarm {
    private final String tailPlan;

    public Fish() {
        super("Gilled",
                "Finned",
                (new Random()).nextInt(20) < 10 ? "Low" : "Intermediate",
                (new Random()).nextInt(20) < 10 ? "Herbivorous" : "Carnivorous");

        tailPlan = (new Random()).nextInt(40) < 20 ? new Random().nextInt(20) < 10 ? "Heterocercal" : "Protocercal" : new Random().nextInt(20) < 10 ? "Homoceral" : "Diphyceral";

        evolve("Scaled Body");
        evolve("Hydrodynamism");
        evolve("Underwater Vision");
    }

    @Override
    public void congregate() {
        System.out.println("This being forms massive groups of it's own species, known as schools, to have a better chance at surviving attacks from predators.");
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.");
    }

    @Override
    public String toString() {
        return "Fish [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "| Tail Plan: " + this.tailPlan + "]";
    }
}
