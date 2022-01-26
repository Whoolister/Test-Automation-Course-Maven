package inheritance;

import exceptions.BadVariableException;

import java.util.Random;

public class Mammal extends Vertebrate implements IEndothermy, IAgriculture, IHibernation {
    private final String furColor;

    public Mammal() {
        super(Respiration.LUNGS,
                (new Random()).nextInt(2) < 1 ? Locomotion.QUADRUPEDAL : Locomotion.FINNED,
                (new Random()).nextInt(3) < 2 ? ((new Random()).nextInt(2) < 1 ? Intelligence.INTERMEDIATE : Intelligence.HIGH) : Intelligence.SAPIENT,
                (new Random()).nextInt(3) < 2 ? ((new Random()).nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS) : Diet.OMNIVOROUS);

        furColor = (new Random()).nextInt(3) < 2 ? ((new Random()).nextInt(2) < 1 ? "White" : "Brown") : "Black";

        this.healthPoints += 20;
        this.energyPoints += 3;
        this.hitRolls += 1;
        this.hitDamage += 1;
        this.criticalChance += 50;
        this.evasionChance -= 10;
        this.defense += 1;

        evolve("Fur");
        evolve("Four Chambered Heart");
        evolve("Live Births");
    }

    @Override
    public String hibernate() {
        return "This being can enter a state of extremely low metabolism, to sleep through periods with unfavorable conditions.\n";
    }

    @Override
    public String cultivate() throws BadVariableException {
        if (this.intelligence == Intelligence.INTERMEDIATE) {
            return "This being can pick apart certain plants with healing effects on it's body, but not much else.";
        } else if (this.intelligence == Intelligence.HIGH) {
            return "This being knows to wait for the growth or ripening of plants and fruits, to enjoy better and safer meals.";
        } else if (this.intelligence == Intelligence.SAPIENT) {
            return "This being has the mental acquity to learn to carefully plan and aid the growth of plant matter, either for medicinal or nutritional purposes.";
        }

        throw new BadVariableException("In Cultivation");
    }

    @Override
    public String raiseAnimals() throws BadVariableException {
        if (this.intelligence == Intelligence.INTERMEDIATE) {
            return "This being can participate in symbiotic relationships with other animals, be it for protection or hunting aid.";
        } else if (this.intelligence == Intelligence.HIGH) {
            return "This being can learn the behaviors of different species and use the knowledge to hunt or find food and water.";
        } else if (this.intelligence == Intelligence.SAPIENT) {
            return "This being has the mental capacity to raise, train, and even selectively breed other animal species.";
        }

        throw new BadVariableException("In Husbandry");
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
    public String toString() {
        return "Mammal [Name: " + this.name +
                " | Rank: " + this.rank +
                " | Respiration: " + this.respiration +
                " | Locomotion: " + this.locomotion +
                " | Intelligence: " + this.intelligence +
                " | Diet: " + this.diet +
                " | Fur Color: " + this.furColor + "]";
    }
}
