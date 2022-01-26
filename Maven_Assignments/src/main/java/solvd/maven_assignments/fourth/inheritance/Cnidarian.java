package inheritance;

import java.util.Random;

public class Cnidarian extends Invertebrate implements IEctothermy, ISwarm {
    public Cnidarian() {
        super(Respiration.SKIN_DIFFUSION,
                (new Random()).nextInt(20) < 10 ? Locomotion.FINNED : Locomotion.NONE,
                Intelligence.NONE,
                Diet.CARNIVOROUS);

        this.healthPoints -= 20;
        this.hitDamage += 1;
        this.criticalChance += 10;
        this.evasionChance -= 5;
        this.defense -= 3;

        evolve("Deadly Poison");
        evolve("Bioluminescence");
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
        return "Cnidaria [Name:" + this.name +
                " | Rank: " + this.rank +
                " | Respiration: " + this.respiration +
                " | Locomotion: " + this.locomotion +
                " | Intelligence: " + this.intelligence +
                " | Diet: " + this.diet + "]";
    }
}
