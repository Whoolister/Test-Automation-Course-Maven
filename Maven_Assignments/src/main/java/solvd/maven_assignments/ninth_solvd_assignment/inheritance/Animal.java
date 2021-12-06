package ninth_solvd_assignment.inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import ninth_solvd_assignment.battle.IFighter;
import ninth_solvd_assignment.enums.CyrcadianRythm;
import ninth_solvd_assignment.enums.Diet;
import ninth_solvd_assignment.enums.Intelligence;
import ninth_solvd_assignment.enums.Locomotion;
import ninth_solvd_assignment.enums.Respiration;
import ninth_solvd_assignment.enums.SpecialTrait;
import ninth_solvd_assignment.enums.Stat;
import ninth_solvd_assignment.exceptions.DefeatedException;
import ninth_solvd_assignment.exceptions.ExcessRankException;
import ninth_solvd_assignment.exceptions.ExhaustedException;
import ninth_solvd_assignment.exceptions.MissException;
import ninth_solvd_assignment.genetics.IBreeding;
import ninth_solvd_assignment.genetics.Mutator;
import ninth_solvd_assignment.utilities.Randomizer;

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
	private String name = Randomizer.animalNameGenerator(this);
	private int rank;
	private Respiration respiration;
	private Locomotion locomotion;
	private Intelligence intelligence;
	private Diet diet;
	private CyrcadianRythm cyrcadianRythm;
	private EnumMap<SpecialTrait, Boolean> specialTraits = new EnumMap<>(SpecialTrait.class);
	// BASE STAT BLOCK
	private EnumMap<Stat, Integer> baseStatBlock;
	// ACTIVE STAT BLOCK
	private EnumMap<Stat, Integer> statBlock;
	// GENETICS
	private String genes = "";

	public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm) {
		// POPULATES ENUMMAP WITH VALUES
		Arrays.asList(SpecialTrait.values()).forEach((value) -> this.specialTraits.put(value, false));

		this.respiration = respiration;
		this.locomotion = locomotion;
		this.intelligence = intelligence;
		this.diet = diet;
		this.cyrcadianRythm = cyrcadianRythm;

		this.genes = Randomizer.nucleotideRandomizer(genes);
	}

	public Animal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
			CyrcadianRythm cyrcadianRythm, String geneSequence) {
		// POPULATES ENUMMAP WITH VALUES
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

	protected Respiration getRespiration() {
		return this.respiration;
	}

	public String move() {
		return "[" + this.locomotion.getDescription() + "]";
	}

	protected Locomotion getLocomotion() {
		return this.locomotion;
	}

	public String think() {
		return "[" + this.intelligence.getDescription() + "]";
	}

	protected Intelligence getIntelligence() {
		return this.intelligence;
	}

	public String eat() {
		return "[" + this.diet.getDescription() + "]";
	}

	protected Diet getDiet() {
		return this.diet;
	}

	// NOT TO BE CONFUSED WITH THREAD SLEEPING
	public String sleep() {
		return "[" + this.cyrcadianRythm.getDescription() + "]";
	}

	protected CyrcadianRythm getCyrcadianRythm() {
		return this.cyrcadianRythm;
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
				(int) (this.baseStatBlock.get(Stat.HEALTH_POINTS) * (this.rank * (1.2 + new Random().nextFloat()))));
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

		this.baseStatBlock.put(Stat.HEALTH_POINTS, 100);
		this.baseStatBlock.put(Stat.ENERGY_POINTS, 8);
		this.baseStatBlock.put(Stat.SPEED, 20);
		this.baseStatBlock.put(Stat.HIT_DAMAGE, 1);
		this.baseStatBlock.put(Stat.HIT_ROLLS, 8);
		this.baseStatBlock.put(Stat.CRITICAL_CHANCE, 10);
		this.baseStatBlock.put(Stat.DEFENSE, 3);

		this.specialTraits.forEach((key, value) -> {
			if (value) {
				key.getStatMutator().mutateStat(this);
			}
		});

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
	public void changeBaseStat(Stat stat, int change) {
		this.baseStatBlock.put(stat, baseStatBlock.get(stat) + change);
	}

	@Override
	public void changeStat(Stat stat, int change) {
		this.statBlock.put(stat, statBlock.get(stat) + change);
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
				return this.getClass()
						.getConstructor(Respiration.class, Locomotion.class, Intelligence.class, Diet.class,
								CyrcadianRythm.class, String.class)
						.newInstance(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
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
