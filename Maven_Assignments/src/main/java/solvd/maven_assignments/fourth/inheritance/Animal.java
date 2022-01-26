package inheritance;

import battle.IFighter;
import exceptions.BadVariableException;
import exceptions.DepletedHealthException;
import exceptions.NegativeStaminaException;
import genetics.IBreeding;
import utilities.Randomizer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Animal implements IFighter, IBreeding {
    protected ArrayList<String> specialTraits;
    protected String name = "";
    protected int rank = 0;
    protected Respiration respiration;
    protected Locomotion locomotion;
    protected Intelligence intelligence;
    protected Diet diet;
    //STAT BLOCK
    protected int healthPoints = 100;
    protected int energyPoints = 8;
    protected int speed = 30;
    protected int hitRolls = 1;
    protected int hitDamage = 8;
    protected int criticalChance = 10;
    protected int evasionChance = 10;
    protected int defense = 3;

    public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        this.name = Randomizer.animalNameGenerator(this);
        this.rank = 0;
        this.specialTraits = new ArrayList<>();
        this.respiration = respiration;
        this.locomotion = locomotion;
        this.intelligence = intelligence;
        this.diet = diet;
    }

    public String breathe() throws BadVariableException {
        switch (this.respiration) {
            case LUNGS:
                return this.respiration.getDescription();
            case GILLS:
                return this.respiration.getDescription();
            case SKIN_DIFFUSION:
                return this.respiration.getDescription();
        }

        throw new BadVariableException("In Breathing");
    }

    public String move() throws BadVariableException {
        switch (this.locomotion) {
            case BIPEDAL:
                return this.locomotion.getDescription();
            case QUADRUPEDAL:
                return this.locomotion.getDescription();
            case MULTI_LEGGED:
                return this.locomotion.getDescription();
            case WINGED:
                return this.locomotion.getDescription();
            case FINNED:
                return this.locomotion.getDescription();
            case TENTACLES:
                return this.locomotion.getDescription();
            case SLITHERING:
                return this.locomotion.getDescription();
            case NONE:
                return this.locomotion.getDescription();
        }

        throw new BadVariableException("In Movement");
    }

    public String think() throws BadVariableException {
        switch (this.intelligence) {
            case POPULATION_BASED:
                return this.intelligence.getDescription();
            case NONE:
                return this.intelligence.getDescription();
            case SOME:
                return this.intelligence.getDescription();
            case INTERMEDIATE:
                return this.intelligence.getDescription();
            case HIGH:
                return this.intelligence.getDescription();
            case SAPIENT:
                return this.intelligence.getDescription();
            case ELDRITCH:
                return this.intelligence.getDescription();
        }

        throw new BadVariableException("In Thought");
    }

    public String eat() throws BadVariableException {
        switch (this.diet) {
            case HERBIVOROUS:
                return this.diet.getDescription();
            case CARNIVOROUS:
                return this.diet.getDescription();
            case OMNIVOROUS:
                return this.diet.getDescription();
        }

        throw new BadVariableException("In Eating");
    }

    protected void evolve(String trait) {
        specialTraits.add(trait);
    }

    //IFighter METHODS INCOMPLETE
    public void rankUP() {
        //IDENTITY
        this.name = Randomizer.animalNameGenerator(this);
        this.rank++;
        //SURVIVAL STATS INCREASE
        this.healthPoints = (int) (this.healthPoints * (1.1 + new Random().nextFloat()));
        this.energyPoints++;
        //DAMAGE STATS INCREASE
        this.hitDamage += new Random().nextInt(4) + 2;
        this.criticalChance += new Random().nextInt(8) + 4;
        //DEFENSE STATS INCREASE
        this.evasionChance += new Random().nextInt(2) + 1;
        this.defense += new Random().nextInt(2) + 1;
    }

    public boolean hit(Animal competitor) throws DepletedHealthException, NegativeStaminaException {
        this.energyPoints--;

        if (this.energyPoints < 0) {
            competitor.rankUP();
            throw new NegativeStaminaException(this.getName() + " tried to attack, but has perished of Exhaustion!\n\n\t" + competitor.getName() + " has won the bout, and risen to Rank �" + competitor.getRank() + "!\n");
        }

        int damage = 0;

        for (int hits = 0; hits < this.hitRolls; hits++) {
            damage += (new Random()).nextInt(100) + 1 < this.criticalChance ? this.hitDamage * 2 : this.hitDamage;
        }
        try {
            return competitor.getHit(damage);
        } catch (DepletedHealthException e) {
            this.rankUP();
            throw new DepletedHealthException(e.getMessage() + this.getName() + " has won the bout, and risen to Rank �" + this.getRank() + " !\n");
        }
    }

    public boolean getHit(int damage) throws DepletedHealthException {
        if (new Random().nextInt(100) + 1 > this.evasionChance) {
            this.healthPoints -= (damage - this.defense);

            if (healthPoints <= 0) {
                throw new DepletedHealthException(this.getName() + " was hit for " + damage + " damage, and has perished from their injuries... \n\n\t");
            }

            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getHitRolls() {
        return this.hitRolls;
    }

    public int getHitDamage() {
        return this.hitDamage;
    }

    public int getCriticalChance() {
        return this.criticalChance;
    }

    public int getEvasionChance() {
        return this.evasionChance;
    }

    public int getDefense() {
        return this.defense;
    }

    //IBreeding METHODS INCOMPLETE
    public void mixGenes() {

    }

    public Animal offspring(Animal parent) {
        return this;
    }

    //Object METHODS
    @Override
    public int hashCode() {
        return Objects.hash(diet, intelligence, locomotion, respiration, specialTraits);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal))
            return false;
        Animal other = (Animal) obj;
        return Objects.equals(diet, other.diet) && Objects.equals(intelligence, other.intelligence)
                && Objects.equals(locomotion, other.locomotion) && Objects.equals(respiration, other.respiration)
                && Objects.equals(specialTraits, other.specialTraits);
    }
}
