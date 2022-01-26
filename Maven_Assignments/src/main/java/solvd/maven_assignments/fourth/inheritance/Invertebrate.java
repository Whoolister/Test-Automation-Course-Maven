package inheritance;

public abstract class Invertebrate extends Animal {
    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        this.healthPoints -= 20;
        this.energyPoints -= 2;
        this.hitDamage += 4;
        this.evasionChance += 8;
        this.defense -= 3;

        evolve("Flexible Body Plan");
    }
}
