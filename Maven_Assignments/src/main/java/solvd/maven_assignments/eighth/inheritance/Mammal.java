package solvd.maven_assignments.eighth.inheritance;

import solvd.maven_assignments.eighth.enums.*;
import solvd.maven_assignments.eighth.interfaces.IAgriculture;
import solvd.maven_assignments.eighth.interfaces.IEndothermy;
import solvd.maven_assignments.eighth.interfaces.IHibernation;
import solvd.maven_assignments.eighth.utilities.Randomizer;

import java.util.Random;

public class Mammal extends Vertebrate implements IEndothermy, IAgriculture, IHibernation {
    private final String furColor;

    public Mammal() {
        super(Respiration.LUNGS, new Random().nextInt(2) < 1 ? Locomotion.QUADRUPEDAL : Locomotion.FINNED,
                new Random().nextInt(3) < 2
                        ? ((new Random()).nextInt(2) < 1 ? Intelligence.INTERMEDIATE : Intelligence.HIGH)
                        : Intelligence.SAPIENT,
                new Random().nextInt(3) < 2 ? new Random().nextInt(2) < 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS
                        : Diet.OMNIVOROUS,
                new Random().nextInt(3) < 2
                        ? new Random().nextInt(2) < 1 ? CyrcadianRythm.DIURNAL : CyrcadianRythm.METATURNAL
                        : CyrcadianRythm.NOCTURNAL);

        furColor = (new Random()).nextInt(3) < 2 ? ((new Random()).nextInt(2) < 1 ? "White" : "Brown") : "Black";

        evolve(SpecialTrait.FUR);
        evolve(SpecialTrait.SINGLE_BONED_JAW);
        evolve(SpecialTrait.FOUR_CHAMBERED_HEART);

        // RANDOMIZES THE MISSING GENETIC MATERIAL
        this.genes = Randomizer.nucleotideRandomizer(genes);
    }

    public Mammal(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                  CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);

        furColor = (new Random()).nextInt(3) < 2 ? ((new Random()).nextInt(2) < 1 ? "White" : "Brown") : "Black";
    }

    @Override
    public String hibernate() {
        return "This being can enter a state of extremely low metabolism, to sleep through periods with unfavorable conditions.\n";
    }

    @Override
    public String cultivate() {
        if (this.intelligence == Intelligence.INTERMEDIATE) {
            return "This being can pick apart certain plants with healing effects on it's body, but not much else.";
        } else if (this.intelligence == Intelligence.HIGH) {
            return "This being knows to wait for the growth or ripening of plants and fruits, to enjoy better and safer meals.";
        } else {
            return "This being has the mental acquity to learn to carefully plan and aid the growth of plant matter, either for medicinal or nutritional purposes.";
        }
    }

    @Override
    public String raiseAnimals() {
        if (this.intelligence == Intelligence.INTERMEDIATE) {
            return "This being can participate in symbiotic relationships with other animals, be it for protection or hunting aid.";
        } else if (this.intelligence == Intelligence.HIGH) {
            return "This being can learn the behaviors of different species and use the knowledge to hunt or find food and water.";
        } else {
            return "This being has the mental capacity to raise, train, and even selectively breed other animal species.";
        }
    }

    @Override
    public String produceHeat() {
        return "This being can increase their metabolism to exude greater amounts of energy, this may be a limiting factor to their physical ability.\n";
    }

    @Override
    public String releaseHeat() {
        return "This being needs to push excess heat out of their bodies through panting, sweating, or a mixture of both.\n";
    }

    @Override
    public String toString() {
        return "Mammal [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
                + this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet
                + " | Cyrcadian Rythm: " + this.cyrcadianRythm + " | Fur Color: " + this.furColor + "]";
    }
}
