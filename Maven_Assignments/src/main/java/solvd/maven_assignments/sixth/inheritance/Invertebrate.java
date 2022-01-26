package sixth_solvd_assignment.inheritance;

import sixth_solvd_assignment.enums.*;

public abstract class Invertebrate extends Animal {
    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);

        evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
    }
}
