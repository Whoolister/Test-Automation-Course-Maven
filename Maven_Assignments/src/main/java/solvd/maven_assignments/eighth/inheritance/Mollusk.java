package solvd.maven_assignments.eighth.inheritance;

import solvd.maven_assignments.eighth.enums.*;
import solvd.maven_assignments.eighth.interfaces.IEctothermy;
import solvd.maven_assignments.eighth.interfaces.IHibernation;
import solvd.maven_assignments.eighth.utilities.Randomizer;

import java.util.Random;

public class Mollusk extends Invertebrate implements IEctothermy, IHibernation {
    private static boolean jetReady = true;

    public Mollusk() {
        super(Respiration.GILLS, new Random().nextInt(2) < 1 ? Locomotion.TENTACLES : Locomotion.NONE,
                new Random().nextInt(2) < 1 ? Intelligence.NONE : Intelligence.HIGH,
                new Random().nextInt(2) < 1 ? Diet.CARNIVOROUS : Diet.OMNIVOROUS, CyrcadianRythm.METATURNAL);

        evolve(SpecialTrait.SHELLED_BODY);
        evolve(SpecialTrait.JET_PROPULSION);
        evolve(SpecialTrait.CAMOUFLAGE);

        // RANDOMIZES THE MISSING GENETIC MATERIAL
        this.genes = Randomizer.nucleotideRandomizer(genes);
    }

    public Mollusk(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                   CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);
    }

    public static boolean isJetReady() {
        return jetReady;
    }

    public static void setJetReady(boolean input) {
        jetReady = input;
    }

    public final String hide() {
        switch ((new Random()).nextInt(5)) {
            case 0:
                return "It's skin turned into some sort of checkerboard pattern... Maybe it's distracting us with a friendly game of chess!\n";
            case 1:
                return "It's skin developed a coarse texture to it, with browns, reds, and orange colors dashed all about the surface. It kind of looks like a rock.\n";
            case 2:
                return "It's skin is turning white like the sand at the bottom of the sea. Accompanied by a slow, gentle digging motion.\n";
            case 3:
                return "It's skin turned a very bleak shade of green, and it seems to be mimicking a piece of drifting plant matter!\n";
            case 4:
                return "It's skin turned into a very distracting stripe pattern, making it difficult to tell apart when it moves.\n";
            case 5:
                return "It's skin turned into a mushy, dark green mess. Not something I'd take a bite out of...\n";
            default:
                return "It's... Just staying very still...";
        }
    }

    public final String escape() {
        if (jetReady) {
            // LAMBDA IMPLEMENTATION
            new Thread(() -> {
                try {
                    Mollusk.setJetReady(false);
                    Thread.sleep(35000);
                    Mollusk.setJetReady(true);
                } catch (InterruptedException e) {
                    // Nothing
                }
            }).start();

            return "It got away!\n";
        } else {
            return "It doesn't seem to have too much stamina left...";
        }
    }

    @Override
    public String hibernate() {
        return "This being can shut off their chemical exchange with the environment, alongside a dip in their metabolism, to help them survive a sudden toxicity in their environments.\n";
    }

    @Override
    public String regulateTemperature() {
        return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may limit their physical capabilities.\n";
    }

    @Override
    public String toString() {
        return "Mollusk [Name: " + this.name + " | Respiration: " + this.respiration + " | Locomotion: "
                + this.locomotion + " | Intelligence: " + this.intelligence + " | Diet: " + this.diet
                + " | Cyrcadian Rythm: " + this.cyrcadianRythm + "]";
    }
}
