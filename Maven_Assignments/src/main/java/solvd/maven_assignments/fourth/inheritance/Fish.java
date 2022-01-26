package inheritance;

import java.util.Random;

public class Fish extends Vertebrate implements IEctothermy, ISwarm {
    private final String tailPlan;

    public Fish() {
        super(Respiration.GILLS,
                Locomotion.FINNED,
                (new Random()).nextInt(2) < 1 ? Intelligence.SOME : Intelligence.INTERMEDIATE,
                (new Random()).nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS);

        tailPlan = (new Random()).nextInt(4) < 3 ? new Random().nextInt(2) < 1 ? "Heterocercal" : "Protocercal" : new Random().nextInt(2) < 1 ? "Homoceral" : "Diphyceral";

        this.healthPoints -= 30;
        this.energyPoints -= 3;
        this.hitDamage += 1;
        this.criticalChance += 8;
        this.evasionChance += 20;
        this.defense -= 4;

        evolve("Scaled Body");
        evolve("Hydrodynamism");
        evolve("Underwater Vision");
    }

    @Override
    public String congregate() {
        return "This being forms massive groups of it's own species, known as schools, to have a better chance at surviving attacks from predators.\n";
    }

    @Override
    public String regulateTemperature() {
        return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.\n";
    }

    @Override
    public String toString() {
        return "Fish [Name: " + this.name +
                " | Rank: " + this.rank +
                " | Respiration: " + this.respiration +
                " | Locomotion: " + this.locomotion +
                " | Intelligence: " + this.intelligence +
                " | Diet: " + this.diet +
                " | Tail Plan: " + this.tailPlan + "]";
    }
}
