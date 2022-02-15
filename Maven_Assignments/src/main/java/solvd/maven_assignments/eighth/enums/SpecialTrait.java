package solvd.maven_assignments.eighth.enums;

import solvd.maven_assignments.eighth.genetics.Decoder;

public enum SpecialTrait {
    // INVERTEBRATE TRAITS
    FLEXIBLE_BODY_PLAN(
            "This type of animal has developed a body that isn't bound to a small range of body types, instead, most physical adaptations are always on the table.",
            "ACTG"),
    // ARTHROPOD TRAITS
    EXOSKELETON(
            "This type of animal keeps their hard structures on the outside, granting them great strength and resistance, at the cost of having to molt every time it needs to grow.",
            "CTCC"),
    IRRITANT_STINGS(
            "This type of animal keeps an irritant cocktail of toxins within their stings, very disruptive for both prey and predator.",
            "TATT"),
    COMPOUND_EYES(
            "This type of animal have eyes made up of 'pixel-like' units, increasing their range of vision to near 360 degrees, but decreasing resolution.",
            "CGGC"),
    // CNIDARIAN TRAITS
    HYDROSKELETON(
            "This type of animal keeps their rigidity thanks to hydrostatic pressure, allowing them to float about and endure the crushing pressures of the deep.",
            "CAGG"),
    DEADLY_POISON(
            "This type of animal ensures it isn't preyed upon by filling it's body with an incredibly toxic chemical cocktail.",
            "AGGA"),
    BIOLUMINESCENCE(
            "This type of animal glows in the absence of light, either to warn predators or to signal members of it's own species.",
            "TATA"),
    // MOLLUSK TRAITS
    SHELLED_BODY(
            "This type of animal builds a calcium shell in or on their bodies, it helps to maintain rigidity and buoyancy, and in some cases it serves as a protective shield.",
            "CTTC"),
    JET_PROPULSION(
            "This type of animal can eject fluid out of their bodies at a high enough velocity to propel them in their direction of choice.",
            "AACA"),
    CAMOUFLAGE(
            "This type of animal can change it's surface to more closely match it's surroundings, great for hunting AND avoiding the hunters.",
            "CAGG"),
    // VERTEBRATE TRAITS
    ENDOSKELETON(
            "This type of animal keeps their rigid structures inside their bodies, allowing for less rigid body types, while still keeping them resilient.",
            "GTCA"),
    // MAMMAL TRAITS
    FUR("This type of animal tends to grow a coat of fur over their bodies, which they use to thermoregulate, attract mates, intimidate predators, signal other members of it's own species, etc.",
            "ATTA"),
    SINGLE_BONED_JAW(
            "This type of animal has their lower jaw fused into a single bone, allowing for a great bite force in a compact format.",
            "GAGT"),
    FOUR_CHAMBERED_HEART(
            "This type of animal has a very efficient circulatory system, allowing them to exert more effort for longer.",
            "CAAT"),
    // FISH TRAITS
    SCALED_BODY(
            "This type of animal has small, oily, rounded scales on their exterior, helping them to feel movement around them and making them very slippery.",
            "CATG"),
    HYDRODYNAMISM(
            "This type of animal has a body shape completely adapted to moving in the water, granting them unparalleled mobility in fluid habitats.",
            "ACCC"),
    UNDERWATER_VISION(
            "This type of animal has adapted their sight to the deep, letting them spot prey and predators even in low-light conditions",
            "AGTA"),
    // REPTILE TRAITS
    ROUGH_SCALES(
            "This type of animal has rough, dry scales on their exterior, helping them to keep their moisture and granting them an unparalleled resistance to piercing attacks.",
            "CAAC"),
    COLD_BLOODED(
            "This type of animal doesn't maintain their temperature internally, rather it absorbs and discharges heat to-and-from their surroundings, letting them expend very little energy to stay alive.",
            "CCTC"),
    DEADLY_VENOM(
            "This type of animal can develop a muscle-paralyzing venom sometimes strong enough to stop their victim's heart, applied mostly through a bite.",
            "ATTT");

    private final String description;
    private final String locus;

    SpecialTrait(String description, String locus) {
        this.description = description;
        this.locus = locus;
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
}
