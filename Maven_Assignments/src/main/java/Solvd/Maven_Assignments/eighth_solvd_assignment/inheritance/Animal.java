package eighth_solvd_assignment.inheritance;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Random;

import eighth_solvd_assignment.battle.IFighter;
import eighth_solvd_assignment.enums.Diet;
import eighth_solvd_assignment.enums.Intelligence;
import eighth_solvd_assignment.enums.Locomotion;
import eighth_solvd_assignment.enums.Respiration;
import eighth_solvd_assignment.enums.SpecialTrait;
import eighth_solvd_assignment.enums.Stat;
import eighth_solvd_assignment.exceptions.DefeatedException;
import eighth_solvd_assignment.exceptions.ExcessRankException;
import eighth_solvd_assignment.exceptions.ExhaustedException;
import eighth_solvd_assignment.exceptions.MissException;
import eighth_solvd_assignment.genetics.IBreeding;
import eighth_solvd_assignment.utilities.Randomizer;

public abstract class Animal implements IFighter, IBreeding {
	// BASIC TRAITS
	protected String name = "";
	protected int rank;
	protected Respiration respiration;
	protected Locomotion locomotion;
	protected Intelligence intelligence;
	protected Diet diet;
	// SPECIAL
	protected EnumMap<SpecialTrait, Boolean> specialTraits;
	// STAT BLOCK
	protected EnumMap<Stat, Integer> statBlock;

	public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
		this.name = Randomizer.animalNameGenerator(this);
		this.specialTraits = new EnumMap<>(SpecialTrait.class);
		// LAMBDA IMPLEMENTATION
		Arrays.asList(SpecialTrait.values()).forEach((value) -> this.specialTraits.put(value, false));

		this.respiration = respiration;
		this.locomotion = locomotion;
		this.intelligence = intelligence;
		this.diet = diet;
	}

	protected void evolve(SpecialTrait trait) {
		specialTraits.put(trait, true);
	}

	// DESCRIPTIVE METHODS
	public String breathe() {
		return this.respiration.getDescription();
	}

	public String move() {
		return this.locomotion.getDescription();
	}

	public String think() {
		return this.intelligence.getDescription();
	}

	public String eat() {
		return this.diet.getDescription();
	}

	// IFighter METHODS
	public void rankUP() throws ExcessRankException {
		// IDENTITY
		this.rank++;
		if (this.rank > 4) {
			throw new ExcessRankException();
		}

		this.name = Randomizer.animalNameGenerator(this);
		// SURVIVAL STATS INCREASE
		this.statBlock.put(Stat.MAX_HEALTH,
				(int) (this.statBlock.get(Stat.MAX_HEALTH) * (this.rank * (1.1 + new Random().nextFloat()))));
		this.statBlock.put(Stat.MAX_ENERGY, this.statBlock.get(Stat.MAX_ENERGY) + 1 * this.rank);
		// DAMAGE STATS INCREASE
		this.statBlock.put(Stat.HIT_DAMAGE,
				this.statBlock.get(Stat.HIT_DAMAGE) + (new Random().nextInt(4) + 2) * this.rank);
		this.statBlock.put(Stat.CRITICAL_CHANCE,
				this.statBlock.get(Stat.CRITICAL_CHANCE) + (new Random().nextInt(8) + 4) * this.rank);
		// DEFENSE STATS INCREASE
		this.statBlock.put(Stat.EVASION_CHANCE,
				this.statBlock.get(Stat.EVASION_CHANCE) + (new Random().nextInt(4) + 2) * this.rank);
		this.statBlock.put(Stat.DEFENSE, this.statBlock.get(Stat.DEFENSE) + (new Random().nextInt(2) + 1) * this.rank);
		// RESET HEALTH AND ENERGY
		this.statBlock.put(Stat.HEALTH_POINTS, this.statBlock.get(Stat.MAX_HEALTH));
		this.statBlock.put(Stat.ENERGY_POINTS, this.statBlock.get(Stat.MAX_ENERGY));
	}

	public void generateStatBlock() {
		this.rank = 0;

		this.statBlock = new EnumMap<>(Stat.class);

		int maxHealth = 100;
		int maxEnergy = 8;
		int speed = 30;
		int hitRolls = 1;
		int hitDamage = 8;
		int criticalChance = 10;
		int evasionChance = 10;
		int defense = 3;

		if (specialTraits.get(SpecialTrait.FLEXIBLE_BODY_PLAN)) {
			maxHealth -= 20;
			speed -= 5;
			hitDamage -= 1;
			evasionChance += 8;
		}
		if (specialTraits.get(SpecialTrait.EXOSKELETON)) {
			maxHealth += 10;
			maxEnergy -= 1;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.IRRITANT_STINGS)) {
			hitDamage += 2;
			criticalChance += 12;
		}
		if (specialTraits.get(SpecialTrait.COMPOUND_EYES)) {
			evasionChance += 15;
		}
		if (specialTraits.get(SpecialTrait.HYDROSKELETON)) {
			maxHealth -= 20;
			maxEnergy += 3;
			speed -= 10;
			evasionChance += 12;
			defense -= 1;
		}
		if (specialTraits.get(SpecialTrait.DEADLY_POISON)) {
			defense += 4;
		}
		if (specialTraits.get(SpecialTrait.BIOLUMINESCENCE)) {
			maxEnergy -= 1;
			evasionChance += 8;
		}
		if (specialTraits.get(SpecialTrait.SHELLED_BODY)) {
			maxHealth += 15;
			speed -= 5;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.JET_PROPULSION)) {
			maxEnergy -= 1;
			speed += 5;
			hitDamage += 2;
			evasionChance += 10;
		}
		if (specialTraits.get(SpecialTrait.CAMOUFLAGE)) {
			maxEnergy -= 1;
			hitRolls += 1;
			evasionChance += 8;
		}
		if (specialTraits.get(SpecialTrait.ENDOSKELETON)) {
			maxHealth += 8;
			maxEnergy += 2;
			evasionChance += 5;
			defense -= 1;
		}
		if (specialTraits.get(SpecialTrait.FUR)) {
			maxEnergy += 1;
			evasionChance -= 4;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.SINGLE_BONED_JAW)) {
			hitDamage += 3;
			hitRolls += 1;
			criticalChance += 8;
		}
		if (specialTraits.get(SpecialTrait.FOUR_CHAMBERED_HEART)) {
			maxEnergy += 4;
		}
		if (specialTraits.get(SpecialTrait.SCALED_BODY)) {
			maxHealth += 15;
			speed -= 6;
			defense += 1;
		}
		if (specialTraits.get(SpecialTrait.HYDRODYNAMISM)) {
			maxEnergy += 1;
			speed += 15;
			criticalChance += 10;
		}
		if (specialTraits.get(SpecialTrait.UNDERWATER_VISION)) {
			maxEnergy -= 1;
			evasionChance += 12;
		}
		if (specialTraits.get(SpecialTrait.ROUGH_SCALES)) {
			maxHealth += 30;
			speed -= 8;
			defense += 4;
		}
		if (specialTraits.get(SpecialTrait.COLD_BLOODED)) {
			maxEnergy += 2;
		}
		if (specialTraits.get(SpecialTrait.DEADLY_VENOM)) {
			hitDamage += 2;
			hitRolls += 1;
			criticalChance += 20;
		}

		this.statBlock.put(Stat.MAX_HEALTH, maxHealth);
		this.statBlock.put(Stat.HEALTH_POINTS, maxHealth);
		this.statBlock.put(Stat.MAX_ENERGY, maxEnergy);
		this.statBlock.put(Stat.ENERGY_POINTS, maxEnergy);
		this.statBlock.put(Stat.SPEED, speed);
		this.statBlock.put(Stat.HIT_DAMAGE, hitDamage);
		this.statBlock.put(Stat.HIT_ROLLS, hitRolls);
		this.statBlock.put(Stat.CRITICAL_CHANCE, criticalChance);
		this.statBlock.put(Stat.EVASION_CHANCE, evasionChance);
		this.statBlock.put(Stat.DEFENSE, defense);
	}

	public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException {
		this.statBlock.put(Stat.ENERGY_POINTS, this.statBlock.get(Stat.ENERGY_POINTS) - 1);
		if (this.statBlock.get(Stat.ENERGY_POINTS) < 0) {
			// TELLS THE EXCEPTION THAT THE ATTACKER DIED
			throw new ExhaustedException();
		}

		int damageDealt = 0;
		for (int hits = 0; hits < this.statBlock.get(Stat.HIT_ROLLS); hits++) {
			if (new Random().nextInt(100) + 1 > competitor.getStat(Stat.EVASION_CHANCE)) {
				// DAMAGE & CRITICAL HIT CALCULATION
				int damage = (new Random().nextInt(100) + 1 < this.statBlock.get(Stat.CRITICAL_CHANCE)
						? this.statBlock.get(Stat.HIT_DAMAGE) * 2
						: this.statBlock.get(Stat.HIT_DAMAGE));

				damageDealt = competitor.receiveHit(damage);
			} else {
				// TELLS THE EXCEPTION THAT THE OPONENT DODGED
				throw new MissException();
			}
		}

		return damageDealt;
	}

	public int receiveHit(int damage) throws DefeatedException {
		this.statBlock.put(Stat.HEALTH_POINTS,
				this.statBlock.get(Stat.HEALTH_POINTS) - (damage - this.getStat(Stat.DEFENSE)));
		if (this.getStat(Stat.HEALTH_POINTS) <= 0) {
			// TELLS THE EXCEPTION THAT THE RECEIVER DIED FOR HOW MUCH DAMAGE
			throw new DefeatedException(damage - this.getStat(Stat.DEFENSE));
		}
		return damage;
	}

	public String getName() {
		return this.name;
	}

	public int getRank() {
		return this.rank;
	}

	public int getStat(Stat stat) {
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
