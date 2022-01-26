package sixth_solvd_assignment.inheritance;

import sixth_solvd_assignment.enums.*;

public abstract class Vertebrate extends Animal {
    protected Vertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.ENDOSKELETON);
    }
}
