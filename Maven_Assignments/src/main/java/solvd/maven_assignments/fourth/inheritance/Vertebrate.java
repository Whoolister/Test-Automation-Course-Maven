package inheritance;

public abstract class Vertebrate extends Animal {
    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        this.healthPoints += 10;
        this.energyPoints += 2;
        this.hitRolls += 1;
        this.hitDamage -= 3;
        this.evasionChance += 5;
        this.defense += 1;

        evolve("Endoskeleton");
        evolve("Central Nervous System");
    }
}
