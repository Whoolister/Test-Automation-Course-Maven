package inheritance;

import java.util.Random;

public class Reptile extends Vertebrate implements Ectothermy, Endothermy {
    private final String bodyPlan;

    public Reptile() {
        super("Lungs",
                (new Random()).nextInt(20) < 10 ? "Quadrupedal" : "None",
                "Some",
                (new Random()).nextInt(20) < 10 ? "Herbivorous" : "Carnivorous");

        bodyPlan = new Random().nextInt(20) < 10 ? "Wide" : "Long";

        evolve("Rough Scales");
        evolve("Venom Production");
        evolve("Hard Eggs");
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
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.");
    }

    @Override
    public String toString() {
        return "Reptile [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "| Body Plan: " + this.bodyPlan + "]";
    }
}
