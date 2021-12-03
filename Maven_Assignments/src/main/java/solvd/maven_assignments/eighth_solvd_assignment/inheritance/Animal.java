package eighth_solvd_assignment.inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import eighth_solvd_assignment.battle.IFighter;
import eighth_solvd_assignment.enums.CyrcadianRythm;
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
import eighth_solvd_assignment.genetics.Mutator;
import eighth_solvd_assignment.utilities.Randomizer;

public abstract class Animal implements IFighter, IBreeding {
	// SETTING UP DIFFERENT MUTATIONS
	protected static ArrayList<Mutator<String>> mutators = new ArrayList<>();
	static {
		mutators.add((base) -> {
			return StringUtils.rotate(base, new Random().nextInt());
		});
		mutators.add((base) -> {
			char[] aux = base.toCharArray();
			ArrayUtils.shuffle(aux);
			return StringUtils.valueOf(aux);
		});
		mutators.add((base) -> {
			char[] aux = base.toCharArray();
			ArrayUtils.reverse(aux);
			return StringUtils.valueOf(aux);
		});
	}

	// TRAITS
	protected String name = "";
	protected int rank;
	protected Respiration respiration;
	protected Locomotion locomotion;
	protected Intelligence intelligence;
	protected Diet diet;
	protected CyrcadianRythm cyrcadianRythm;
	protected EnumMap<SpecialTrait, Boolean> specialTraits;
	// BASE STAT BLOCK
	protected EnumMap<Stat, Integer> baseStatBlock;
	// ACTIVE STAT BLOCK
	protected EnumMap<Stat, Integer> statBlock;
	// GENETICS
	protected String genes = "";

	public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm) {
		this.name = Randomizer.animalNameGenerator(this);
		this.specialTraits = new EnumMap<>(SpecialTrait.class);
		// LAMBDA IMPLEMENTATION
		Arrays.asList(SpecialTrait.values()).forEach((value) -> this.specialTraits.put(value, false));

		this.respiration = respiration;
		this.locomotion = locomotion;
		this.intelligence = intelligence;
		this.diet = diet;
		this.cyrcadianRythm = cyrcadianRythm;
	}

	// IMPLEMENT THIS AND OTHER GENE INCLUDING CONSTRUCTORS
	public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		this.name = Randomizer.animalNameGenerator(this);
		this.specialTraits = new EnumMap<>(SpecialTrait.class);
		// LAMBDA IMPLEMENTATION
		Arrays.asList(SpecialTrait.values()).forEach((value) -> this.specialTraits.put(value, false));

		this.respiration = respiration;
		this.locomotion = locomotion;
		this.intelligence = intelligence;
		this.diet = diet;
		this.cyrcadianRythm = cyrcadianRythm;
		// RANDOMIZES THE MISSING GENETIC MATERIAL
		this.genes = Randomizer.nucleotideRandomizer(geneSequence);
		// FOR EACH SPECIAL TRAIT, CHECKS IF THE GENETIC CODE HAS THE REQUIRED LOCUS
		Arrays.asList(SpecialTrait.values())
				.forEach((value) -> this.specialTraits.put(value, value.getDecoder().decode(genes)));
	}

	protected void evolve(SpecialTrait trait) {
		specialTraits.put(trait, true);

		genes += trait.getLocus();
	}

	// DESCRIPTIVE METHODS
	public String breathe() {
		return "[" + this.respiration.getDescription() + "]";
	}

	public String move() {
		return "[" + this.locomotion.getDescription() + "]";
	}

	public String think() {
		return "[" + this.intelligence.getDescription() + "]";
	}

	public String eat() {
		return "[" + this.diet.getDescription() + "]";
	}

	// NOT TO BE CONFUSED WITH THREAD SLEEPING
	public String sleep() {
		return "[" + this.cyrcadianRythm.getDescription() + "]";
	}

	public Enum<?> getEnum(Class<?> target) {
		if (this.respiration.getClass() == target) {
			return this.respiration;
		} else if (this.locomotion.getClass() == target) {
			return this.locomotion;
		} else if (this.intelligence.getClass() == target) {
			return this.intelligence;
		} else if (this.diet.getClass() == target) {
			return this.diet;
		} else if (this.cyrcadianRythm.getClass() == target) {
			return this.cyrcadianRythm;
		} else {
			return null;
		}
	}

	public String getName() {
		return this.name;
	}

	// IFighter METHODS
	@Override
	public void rankUP() throws ExcessRankException {
		// IDENTITY
		this.rank++;
		if (this.rank > 4) {
			throw new ExcessRankException();
		}

		this.name = Randomizer.animalNameGenerator(this);
		// SURVIVAL STATS INCREASE
		this.baseStatBlock.put(Stat.HEALTH_POINTS,
				(int) (this.baseStatBlock.get(Stat.HEALTH_POINTS) * (this.rank * (1.1 + new Random().nextFloat()))));
		this.baseStatBlock.put(Stat.ENERGY_POINTS, this.baseStatBlock.get(Stat.ENERGY_POINTS) + 1 * this.rank);
		// SPEED INCREASE
		this.baseStatBlock.put(Stat.SPEED, this.baseStatBlock.get(Stat.SPEED) + 3 * this.rank);
		// DAMAGE STATS INCREASE
		this.baseStatBlock.put(Stat.HIT_DAMAGE,
				this.baseStatBlock.get(Stat.HIT_DAMAGE) + (new Random().nextInt(4) + 2) * this.rank);
		this.baseStatBlock.put(Stat.CRITICAL_CHANCE,
				this.baseStatBlock.get(Stat.CRITICAL_CHANCE) + (new Random().nextInt(8) + 4) * this.rank);
		// DEFENSE STATS
		this.baseStatBlock.put(Stat.DEFENSE,
				this.baseStatBlock.get(Stat.DEFENSE) + (new Random().nextInt(2) + 1) * this.rank);

		this.resetStatBlock();
	}

	@Override
	public void generateBaseStatBlock() {
		this.rank = 0;

		this.baseStatBlock = new EnumMap<>(Stat.class);

		int healthPoints = 100;
		int energyPoints = 8;
		int speed = 30;
		int hitRolls = 1;
		int hitDamage = 8;
		int criticalChance = 10;
		int defense = 3;

		if (specialTraits.get(SpecialTrait.FLEXIBLE_BODY_PLAN)) {
			healthPoints -= 20;
			speed -= 5;
			hitDamage -= 1;
		}
		if (specialTraits.get(SpecialTrait.EXOSKELETON)) {
			healthPoints += 10;
			energyPoints -= 1;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.IRRITANT_STINGS)) {
			hitDamage += 2;
			criticalChance += 12;
		}
		if (specialTraits.get(SpecialTrait.COMPOUND_EYES)) {
			criticalChance += 4;
		}
		if (specialTraits.get(SpecialTrait.HYDROSKELETON)) {
			healthPoints -= 20;
			energyPoints += 3;
			speed -= 10;
			defense -= 1;
		}
		if (specialTraits.get(SpecialTrait.DEADLY_POISON)) {
			defense += 4;
		}
		if (specialTraits.get(SpecialTrait.BIOLUMINESCENCE)) {
			energyPoints -= 1;
			defense += 1;
		}
		if (specialTraits.get(SpecialTrait.SHELLED_BODY)) {
			healthPoints += 15;
			speed -= 5;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.JET_PROPULSION)) {
			energyPoints -= 1;
			speed += 10;
			hitDamage += 2;
		}
		if (specialTraits.get(SpecialTrait.CAMOUFLAGE)) {
			energyPoints -= 1;
			hitRolls += 1;
			criticalChance += 8;
		}
		if (specialTraits.get(SpecialTrait.ENDOSKELETON)) {
			healthPoints += 8;
			energyPoints += 2;
			defense -= 1;
		}
		if (specialTraits.get(SpecialTrait.FUR)) {
			energyPoints += 1;
			defense += 2;
		}
		if (specialTraits.get(SpecialTrait.SINGLE_BONED_JAW)) {
			hitDamage += 3;
			hitRolls += 1;
			criticalChance += 8;
		}
		if (specialTraits.get(SpecialTrait.FOUR_CHAMBERED_HEART)) {
			energyPoints += 4;
		}
		if (specialTraits.get(SpecialTrait.SCALED_BODY)) {
			healthPoints += 15;
			speed -= 6;
			defense += 1;
		}
		if (specialTraits.get(SpecialTrait.HYDRODYNAMISM)) {
			energyPoints += 1;
			speed += 15;
			criticalChance += 10;
		}
		if (specialTraits.get(SpecialTrait.UNDERWATER_VISION)) {
			energyPoints -= 1;
			criticalChance += 12;
		}
		if (specialTraits.get(SpecialTrait.ROUGH_SCALES)) {
			healthPoints += 30;
			speed -= 8;
			defense += 4;
		}
		if (specialTraits.get(SpecialTrait.COLD_BLOODED)) {
			energyPoints += 2;
		}
		if (specialTraits.get(SpecialTrait.DEADLY_VENOM)) {
			hitDamage += 2;
			hitRolls += 1;
			criticalChance += 20;
		}

		this.baseStatBlock.put(Stat.HEALTH_POINTS, healthPoints);
		this.baseStatBlock.put(Stat.ENERGY_POINTS, energyPoints);
		this.baseStatBlock.put(Stat.SPEED, speed);
		this.baseStatBlock.put(Stat.HIT_DAMAGE, hitDamage);
		this.baseStatBlock.put(Stat.HIT_ROLLS, hitRolls);
		this.baseStatBlock.put(Stat.CRITICAL_CHANCE, criticalChance);
		this.baseStatBlock.put(Stat.DEFENSE, defense);

		this.resetStatBlock();
	}

	@Override
	public void resetStatBlock() {
		this.statBlock = this.baseStatBlock;
	}

	@Override
	public int hit(Animal competitor) throws DefeatedException, ExhaustedException, MissException {
		statBlock.put(Stat.ENERGY_POINTS, statBlock.get(Stat.ENERGY_POINTS) - 1);

		if (statBlock.get(Stat.ENERGY_POINTS) < 0) {
			// TELLS THE EXCEPTION THAT THE ATTACKER DIED
			throw new ExhaustedException();
		}

		int damageDealt = 0;
		for (int hits = 0; hits < baseStatBlock.get(Stat.HIT_ROLLS); hits++) {
			if (competitor.getStat(Stat.SPEED) > new Random().nextInt(100) + 1) {
				// TELLS THE EXCEPTION THAT THE OPONENT DODGED
				throw new MissException();
			} else {
				// DAMAGE & CRITICAL HIT CALCULATION
				int damage = (new Random().nextInt(100) + 1 < statBlock.get(Stat.CRITICAL_CHANCE)
						? statBlock.get(Stat.HIT_DAMAGE) * 2
						: statBlock.get(Stat.HIT_DAMAGE));

				damageDealt = competitor.receiveHit(damage);
			}
		}

		return damageDealt;
	}

	@Override
	public int receiveHit(int damage) throws DefeatedException {
		statBlock.put(Stat.HEALTH_POINTS, statBlock.get(Stat.HEALTH_POINTS) - (damage - statBlock.get(Stat.DEFENSE)));
		if (statBlock.get(Stat.HEALTH_POINTS) <= 0) {
			// TELLS THE EXCEPTION THAT THE RECEIVER DIED FOR HOW MUCH DAMAGE
			throw new DefeatedException(damage - this.getBaseStat(Stat.DEFENSE));
		}
		return damage;
	}

	@Override
	public int getRank() {
		return this.rank;
	}

	@Override
	public int getBaseStat(Stat baseStat) {
		return this.baseStatBlock.get(baseStat);
	}

	@Override
	public int getStat(Stat stat) {
		return this.statBlock.get(stat);
	}

	@Override
	public void changeStat(Stat stat, int change) {
		statBlock.put(stat, statBlock.get(stat) + change);
	}

	// IBreeding METHODS
	@Override
	public Animal breed(Animal partner) {
		String geneSequence = partner.splice() + this.splice();

		Respiration respiration = new Random().nextInt(2) == 1 ? this.respiration : partner.respiration;
		Locomotion locomotion = new Random().nextInt(2) == 1 ? this.locomotion : partner.locomotion;
		Intelligence intelligence = new Random().nextInt(2) == 1 ? this.intelligence : partner.intelligence;
		Diet diet = new Random().nextInt(2) == 1 ? this.diet : partner.diet;
		CyrcadianRythm cyrcadianRythm = new Random().nextInt(2) == 1 ? this.cyrcadianRythm : partner.cyrcadianRythm;

		// CUSTOM FUNCTIONAL INTERFACE IMPLEMENTATION
		// SELECT RANDOM MUTATION
		geneSequence = mutators.get(new Random().nextInt(mutators.size())).mutate(geneSequence);

		if (partner.getClass().getName() == this.getClass().getName()) {
			try {
				return this.getClass().getConstructor().newInstance(respiration, locomotion, intelligence, diet,
						cyrcadianRythm, geneSequence);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return new Hybrid(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
		}
	}

	@Override
	public String splice() {
		if (new Random().nextInt(2) == 1) {
			return this.genes.substring(this.genes.length() / 2);
		} else {
			return this.genes.substring(0, this.genes.length() / 2);
		}
	}

	@Override
	public String getGenes() {
		return this.genes;
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
