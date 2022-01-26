package inheritance;

import enums.Diet;
import enums.Intelligence;
import enums.Locomotion;
import enums.Respiration;
import enums.*;

public abstract class Vertebrate extends Animal {
    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.ENDOSKELETON);
    }
}
