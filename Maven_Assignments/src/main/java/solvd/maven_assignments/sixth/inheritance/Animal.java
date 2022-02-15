package solvd.maven_assignments.sixth.inheritance;

import solvd.maven_assignments.sixth.battle.IFighter;
import solvd.maven_assignments.sixth.enums.*;
import solvd.maven_assignments.sixth.exceptions.*;
import solvd.maven_assignments.sixth.genetics.IBreeding;
import solvd.maven_assignments.sixth.utilities.Randomizer;

import java.util.EnumMap;
import java.util.Objects;
import java.util.Random;

public abstract class Animal implements IFighter, IBreeding {
    // BASIC TRAITS
    protected String name = "";
    protected int rank = 0;
    protected Respiration respiration;
    protected Locomotion locomotion;
    protected Intelligence intelligence;
    protected Diet diet;
    // SPECIAL
    protected EnumMap<SpecialTrait, Boolean> specialTraits;
    // STAT BLOCK
    protected EnumMap<BaseStat, Integer> statBlock;

    public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        this.name = Randomizer.animalNameGenerator(this);
        this.rank = 0;
        this.specialTraits = new EnumMap<>(SpecialTrait.class);
        this.respiration = respiration;
        this.locomotion = locomotion;
        this.intelligence = intelligence;
        this.diet = diet;
    }

    protected void evolve(SpecialTrait trait) {
        specialTraits.put(trait, true);
    }

    // DESCRIPTIVE METHODS
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

    // IFighter METHODS INCOMPLETE
    public void rankUP() throws ExcessRankException {
        // IDENTITY
        this.rank++;
        if (this.rank > 4) {
            throw new ExcessRankException();
        }

        this.name = Randomizer.animalNameGenerator(this);
        // SURVIVAL STATS INCREASE
        this.statBlock.put(BaseStat.MAX_HEALTH,
                (int) (this.statBlock.get(BaseStat.MAX_HEALTH) * (this.rank * (1.1 + new Random().nextFloat()))));
        this.statBlock.put(BaseStat.MAX_ENERGY, this.statBlock.get(BaseStat.MAX_ENERGY) + 1 * this.rank);
        // DAMAGE STATS INCREASE
        this.statBlock.put(BaseStat.HIT_DAMAGE,
                this.statBlock.get(BaseStat.HIT_DAMAGE) + (new Random().nextInt(4) + 2) * this.rank);
        this.statBlock.put(BaseStat.CRITICAL_CHANCE,
                this.statBlock.get(BaseStat.CRITICAL_CHANCE) + (new Random().nextInt(8) + 4) * this.rank);
        // DEFENSE STATS INCREASE
        this.statBlock.put(BaseStat.EVASION_CHANCE,
                this.statBlock.get(BaseStat.EVASION_CHANCE) + (new Random().nextInt(4) + 2) * this.rank);
        this.statBlock.put(BaseStat.DEFENSE, this.statBlock.get(BaseStat.DEFENSE) + (new Random().nextInt(2) + 1) * this.rank);
        // RESET HEALTH AND ENERGY
        this.statBlock.put(BaseStat.HEALTH_POINTS, this.statBlock.get(BaseStat.MAX_HEALTH));
        this.statBlock.put(BaseStat.ENERGY_POINTS, this.statBlock.get(BaseStat.MAX_ENERGY));
    }

    public void generateStatBlock() {
        this.statBlock = new EnumMap<>(BaseStat.class);

        int maxHealth = 100;
        int maxEnergy = 8;
        int speed = 30;
        int hitRolls = 1;
        int hitDamage = 8;
        int criticalChance = 10;
        int evasionChance = 10;
        int defense = 3;

        if (specialTraits.containsKey(SpecialTrait.FLEXIBLE_BODY_PLAN)
                && specialTraits.get(SpecialTrait.FLEXIBLE_BODY_PLAN)) {
            maxHealth -= 20;
            speed -= 5;
            hitDamage -= 1;
            evasionChance += 8;
        }
        if (specialTraits.containsKey(SpecialTrait.EXOSKELETON) && specialTraits.get(SpecialTrait.EXOSKELETON)) {
            maxHealth += 10;
            maxEnergy -= 1;
            defense += 2;
        }
        if (specialTraits.containsKey(SpecialTrait.IRRITANT_STINGS)
                && specialTraits.get(SpecialTrait.IRRITANT_STINGS)) {
            hitDamage += 2;
            criticalChance += 12;
        }
        if (specialTraits.containsKey(SpecialTrait.COMPOUND_EYES) && specialTraits.get(SpecialTrait.COMPOUND_EYES)) {
            evasionChance += 15;
        }
        if (specialTraits.containsKey(SpecialTrait.HYDROSKELETON) && specialTraits.get(SpecialTrait.HYDROSKELETON)) {
            maxHealth -= 20;
            maxEnergy += 3;
            speed -= 10;
            evasionChance += 12;
            defense -= 1;
        }
        if (specialTraits.containsKey(SpecialTrait.DEADLY_POISON) && specialTraits.get(SpecialTrait.DEADLY_POISON)) {
            defense += 4;
        }
        if (specialTraits.containsKey(SpecialTrait.BIOLUMINESCENCE)
                && specialTraits.get(SpecialTrait.BIOLUMINESCENCE)) {
            maxEnergy -= 1;
            evasionChance += 8;
        }
        if (specialTraits.containsKey(SpecialTrait.SHELLED_BODY) && specialTraits.get(SpecialTrait.SHELLED_BODY)) {
            maxHealth += 15;
            speed -= 5;
            defense += 2;
        }
        if (specialTraits.containsKey(SpecialTrait.JET_PROPULSION) && specialTraits.get(SpecialTrait.JET_PROPULSION)) {
            maxEnergy -= 1;
            speed += 5;
            hitDamage += 2;
            evasionChance += 10;
        }
        if (specialTraits.containsKey(SpecialTrait.CAMOUFLAGE) && specialTraits.get(SpecialTrait.CAMOUFLAGE)) {
            maxEnergy -= 1;
            hitRolls += 1;
            evasionChance += 8;
        }
        if (specialTraits.containsKey(SpecialTrait.ENDOSKELETON) && specialTraits.get(SpecialTrait.ENDOSKELETON)) {
            maxHealth += 8;
            maxEnergy += 2;
            evasionChance += 5;
            defense -= 1;
        }
        if (specialTraits.containsKey(SpecialTrait.FUR) && specialTraits.get(SpecialTrait.FUR)) {
            maxEnergy += 1;
            evasionChance -= 4;
            defense += 2;
        }
        if (specialTraits.containsKey(SpecialTrait.SINGLE_BONED_JAW)
                && specialTraits.get(SpecialTrait.SINGLE_BONED_JAW)) {
            hitDamage += 3;
            hitRolls += 1;
            criticalChance += 8;
        }
        if (specialTraits.containsKey(SpecialTrait.FOUR_CHAMBERED_HEART)
                && specialTraits.get(SpecialTrait.FOUR_CHAMBERED_HEART)) {
            maxEnergy += 4;
        }
        if (specialTraits.containsKey(SpecialTrait.SCALED_BODY) && specialTraits.get(SpecialTrait.SCALED_BODY)) {
            maxHealth += 15;
            speed -= 6;
            defense += 1;
        }
        if (specialTraits.containsKey(SpecialTrait.HYDRODYNAMISM) && specialTraits.get(SpecialTrait.HYDRODYNAMISM)) {
            maxEnergy += 1;
            speed += 15;
            criticalChance += 10;
        }
        if (specialTraits.containsKey(SpecialTrait.UNDERWATER_VISION)
                && specialTraits.get(SpecialTrait.UNDERWATER_VISION)) {
            maxEnergy -= 1;
            evasionChance += 12;
        }
        if (specialTraits.containsKey(SpecialTrait.ROUGH_SCALES) && specialTraits.get(SpecialTrait.ROUGH_SCALES)) {
            maxHealth += 30;
            speed -= 8;
            defense += 4;
        }
        if (specialTraits.containsKey(SpecialTrait.COLD_BLOODED) && specialTraits.get(SpecialTrait.COLD_BLOODED)) {
            maxEnergy += 2;
        }
        if (specialTraits.containsKey(SpecialTrait.DEADLY_VENOM) && specialTraits.get(SpecialTrait.DEADLY_VENOM)) {
            hitDamage += 2;
            hitRolls += 1;
            criticalChance += 20;
        }

        this.statBlock.put(BaseStat.MAX_HEALTH, maxHealth);
        this.statBlock.put(BaseStat.HEALTH_POINTS, maxHealth);
        this.statBlock.put(BaseStat.MAX_ENERGY, maxEnergy);
        this.statBlock.put(BaseStat.ENERGY_POINTS, maxEnergy);
        this.statBlock.put(BaseStat.SPEED, speed);
        this.statBlock.put(BaseStat.HIT_DAMAGE, hitDamage);
        this.statBlock.put(BaseStat.HIT_ROLLS, hitRolls);
        this.statBlock.put(BaseStat.CRITICAL_CHANCE, criticalChance);
        this.statBlock.put(BaseStat.EVASION_CHANCE, evasionChance);
        this.statBlock.put(BaseStat.DEFENSE, defense);
    }

    public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException {
        this.statBlock.put(BaseStat.ENERGY_POINTS, this.statBlock.get(BaseStat.ENERGY_POINTS) - 1);
        if (this.statBlock.get(BaseStat.ENERGY_POINTS) < 0) {
            // TELLS THE EXCEPTION THAT THE ATTACKER DIED
            throw new ExhaustedException();
        }

        int damageDealt = 0;
        for (int hits = 0; hits < this.statBlock.get(BaseStat.HIT_ROLLS); hits++) {
            if (new Random().nextInt(100) + 1 > competitor.getStat(BaseStat.EVASION_CHANCE)) {
                // DAMAGE & CRITICAL HIT CALCULATION
                int damage = (new Random().nextInt(100) + 1 < this.statBlock.get(BaseStat.CRITICAL_CHANCE)
                        ? this.statBlock.get(BaseStat.HIT_DAMAGE) * 2
                        : this.statBlock.get(BaseStat.HIT_DAMAGE));

                damageDealt = competitor.receiveHit(damage);
            } else {
                // TELLS THE EXCEPTION THAT THE OPONENT DODGED
                throw new MissException();
            }
        }

        return damageDealt;
    }

    public int receiveHit(int damage) throws DefeatedException {
        this.statBlock.put(BaseStat.HEALTH_POINTS,
                this.statBlock.get(BaseStat.HEALTH_POINTS) - (damage - this.getStat(BaseStat.DEFENSE)));
        if (this.getStat(BaseStat.HEALTH_POINTS) <= 0) {
            // TELLS THE EXCEPTION THAT THE RECEIVER DIED FOR HOW MUCH DAMAGE
            throw new DefeatedException(damage - this.getStat(BaseStat.DEFENSE));
        }
        return damage;
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public int getStat(BaseStat stat) {
        return this.statBlock.get(stat);
    }

    // IBreeding METHODS INCOMPLETE
    public void mixGenes() {

    }

    public Animal offspring(Animal parent) {
        return this;
    }

    // Object METHODS
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
