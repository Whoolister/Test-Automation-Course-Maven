package inheritance;

import java.util.Random;

public class Mammal extends Vertebrate implements Endothermy, Agriculture, Hibernation {
    private final String furColor;

    public Mammal() {
        super("Lungs",
                (new Random()).nextInt(20) < 10 ? "Quadrupedal" : "Finned",
                (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Intermediate" : "High") : "Sapient",
                (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "Herbivorous" : "Carnivorous") : "Omnivorous");

        furColor = (new Random()).nextInt(30) < 20 ? ((new Random()).nextInt(20) < 10 ? "White" : "Brown") : "Black";

        evolve("Fur");
        evolve("Four Chambered Heart");
        evolve("Live Births");
    }

    @Override
    public void hibernate() {
        System.out.println("This being can enter a state of extremely low metabolism, to sleep through periods with unfavorable conditions.");
    }

    @Override
    public void cultivate() {
        if (this.intelligence == "Intermediate") {
            System.out.println("This being can pick apart certain plants with healing effects on it's body, but not much else.");
        } else if (this.intelligence == "High") {
            System.out.println("This being knows to wait for the growth or ripening of plants and fruits, to enjoy better and safer meals.");
        } else if (this.intelligence == "Sapient") {
            System.out.println("This being has the mental acquity to learn to carefully plan and aid the growth of plant matter, either for medicinal or nutritional purposes.");
        }
    }

    @Override
    public void raiseAnimals() {
        if (this.intelligence == "Intermediate") {
            System.out.println("This being can participate in symbiotic relationships with other animals, be it for protection or hunting aid.");
        } else if (this.intelligence == "High") {
            System.out.println("This being can learn the behaviors of different species and use the knowledge to hunt or find food and water.");
        } else if (this.intelligence == "Sapient") {
            System.out.println("This being has the mental capacity to raise, train, and even selectively breed other animal species.");
        }
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
                this.intelligence + "| Diet: " + this.diet + "| Fur Color: " + this.furColor + "]";
    }
}
