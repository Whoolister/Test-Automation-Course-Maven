package ninth_solvd_assignment.enums;

import ninth_solvd_assignment.battle.StatMutator;
import ninth_solvd_assignment.genetics.Decoder;
import ninth_solvd_assignment.inheritance.Animal;

public enum SpecialTrait {
	// INVERTEBRATE TRAITS
	FLEXIBLE_BODY_PLAN(
			"This type of animal has developed a body that isn't bound to a small range of body types, instead, most physical adaptations are always on the table.",
			"ACTG", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, -12);
				base.changeBaseStat(Stat.HIT_DAMAGE, -1);
				base.changeBaseStat(Stat.HIT_ROLLS, 1);
				base.changeBaseStat(Stat.SPEED, -5);
			}),

	// ARTHROPOD TRAITS
	EXOSKELETON(
			"This type of animal keeps their hard structures on the outside, granting them great strength and resistance, at the cost of having to molt every time it needs to grow.",
			"CTCC", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 10);
				base.changeBaseStat(Stat.ENERGY_POINTS, -1);
				base.changeBaseStat(Stat.DEFENSE, 2);
			}),
	IRRITANT_STINGS(
			"This type of animal keeps an irritant cocktail of toxins within their stings, very disruptive for both prey and predator.",
			"TATT", (base) -> {
				base.changeBaseStat(Stat.HIT_DAMAGE, 2);
				base.changeBaseStat(Stat.CRITICAL_CHANCE, 12);
			}),
	COMPOUND_EYES(
			"This type of animal have eyes made up of 'pixel-like' units, increasing their range of vision to near 360 degrees, but decreasing resolution.",
			"CGGC", (base) -> {
				base.changeBaseStat(Stat.CRITICAL_CHANCE, 6);
			}),
	// CNIDARIAN TRAITS
	HYDROSKELETON(
			"This type of animal keeps their rigidity thanks to hydrostatic pressure, allowing them to float about and endure the crushing pressures of the deep.",
			"CAGG", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, -16);
				base.changeBaseStat(Stat.SPEED, -8);
				base.changeBaseStat(Stat.DEFENSE, -1);
			}),
	DEADLY_POISON(
			"This type of animal ensures it isn't preyed upon by filling it's body with an incredibly toxic chemical cocktail.",
			"AGGA", (base) -> {
				base.changeBaseStat(Stat.ENERGY_POINTS, 3);
				base.changeBaseStat(Stat.DEFENSE, 5);
			}),
	BIOLUMINESCENCE(
			"This type of animal glows in the absence of light, either to warn predators or to signal members of it's own species.",
			"TATA", (base) -> {
				base.changeBaseStat(Stat.DEFENSE, 1);
			}),
	// MOLLUSK TRAITS
	SHELLED_BODY(
			"This type of animal builds a calcium shell in or on their bodies, it helps to maintain rigidity and buoyancy, and in some cases it serves as a protective shield.",
			"CTTC", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 15);
				base.changeBaseStat(Stat.SPEED, -5);
				base.changeBaseStat(Stat.DEFENSE, 2);
			}),
	JET_PROPULSION(
			"This type of animal can eject fluid out of their bodies at a high enough velocity to propel them in their direction of choice.",
			"AACA", (base) -> {
				base.changeBaseStat(Stat.ENERGY_POINTS, -1);
				base.changeBaseStat(Stat.SPEED, 10);
			}),
	CAMOUFLAGE(
			"This type of animal can change it's surface to more closely match it's surroundings, great for hunting AND avoiding the hunters.",
			"CAGG", (base) -> {
				base.changeBaseStat(Stat.CRITICAL_CHANCE, 12);
			}),
	// VERTEBRATE TRAITS
	ENDOSKELETON(
			"This type of animal keeps their rigid structures inside their bodies, allowing for sturdy body types, while still keeping them mobile.",
			"GTCA", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 8);
				base.changeBaseStat(Stat.ENERGY_POINTS, 2);
				base.changeBaseStat(Stat.SPEED, -6);
				base.changeBaseStat(Stat.DEFENSE, -2);
			}),
	// MAMMAL TRAITS
	FUR("This type of animal tends to grow a coat of fur over their bodies, which they use to thermoregulate, attract mates, intimidate predators, signal other members of it's own species, etc.",
			"ATTA", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 4);
				base.changeBaseStat(Stat.ENERGY_POINTS, 2);
				base.changeBaseStat(Stat.DEFENSE, 1);
			}),
	SINGLE_BONED_JAW(
			"This type of animal has their lower jaw fused into a single bone, allowing for a great bite force in a compact format.",
			"GAGT", (base) -> {
				base.changeBaseStat(Stat.HIT_DAMAGE, 2);
				base.changeBaseStat(Stat.CRITICAL_CHANCE, -8);
			}),
	FOUR_CHAMBERED_HEART(
			"This type of animal has a very efficient circulatory system, allowing them to exert more effort for longer.",
			"CAAT", (base) -> {
				base.changeBaseStat(Stat.ENERGY_POINTS, 4);
			}),
	// FISH TRAITS
	SCALED_BODY(
			"This type of animal has small, oily, rounded scales on their exterior, helping them to feel movement in their surroundings and making them very slippery.",
			"CATG", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 8);
				base.changeBaseStat(Stat.SPEED, 4);
				base.changeBaseStat(Stat.DEFENSE, -3);
			}),
	HYDRODYNAMISM(
			"This type of animal has a body shape completely adapted to moving in the water, granting them unparalleled mobility in fluid habitats.",
			"ACCC", (base) -> {
				base.changeBaseStat(Stat.ENERGY_POINTS, 1);
				base.changeBaseStat(Stat.SPEED, 12);
			}),
	UNDERWATER_VISION(
			"This type of animal has adapted their sight to the deep, letting them spot prey and predators even in low-light conditions",
			"AGTA", (base) -> {
				base.changeBaseStat(Stat.CRITICAL_CHANCE, 4);
			}),
	// REPTILE TRAITS
	ROUGH_SCALES(
			"This type of animal has rough, dry scales on their exterior, helping them to keep their moisture and granting them an unparalleled resistance to piercing attacks.",
			"CAAC", (base) -> {
				base.changeBaseStat(Stat.HEALTH_POINTS, 12);
				base.changeBaseStat(Stat.ENERGY_POINTS, -2);
				base.changeBaseStat(Stat.DEFENSE, 3);
			}),
	DEADLY_VENOM(
			"This type of animal can develop a muscle-paralyzing venom sometimes strong enough to stop their victim's heart, applied mostly through a bite.",
			"ATTT", (base) -> {
				base.changeBaseStat(Stat.HIT_DAMAGE, 4);
				base.changeBaseStat(Stat.CRITICAL_CHANCE, 16);
			}),
	COLD_BLOODED(
			"This type of animal doesn't maintain their temperature internally, rather it absorbs and discharges heat to-and-from their surroundings, letting them expend very little energy to stay alive.",
			"CCTC", (base) -> {
				base.changeBaseStat(Stat.ENERGY_POINTS, -2);
			});

	private String description;
	private String locus;
	private StatMutator<Animal> statMutator;

	private SpecialTrait(String description, String locus, StatMutator<Animal> statMutator) {
		this.description = description;
		this.locus = locus;
		this.statMutator = statMutator;
	}

	public String getDescription() {
		return this.description;
	}

	public String getLocus() {
		return this.locus;
	}

	public Decoder<String> getDecoder() {
		Decoder<String> decoder = (sequence) -> {
			return sequence.contains(getLocus());
		};

		return decoder;
	}

	public StatMutator<Animal> getStatMutator() {
		return this.statMutator;
	}
}
