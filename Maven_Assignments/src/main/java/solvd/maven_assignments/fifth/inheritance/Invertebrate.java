package inheritance;

import enums.Diet;
import enums.Intelligence;
import enums.Locomotion;
import enums.Respiration;
import enums.*;

public abstract class Invertebrate extends Animal {
    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
    }
}
