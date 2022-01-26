package eighth_solvd_assignment.inheritance;

import eighth_solvd_assignment.enums.*;

public abstract class Invertebrate extends Animal {
    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                           CyrcadianRythm cyrcadianRythm) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm);

        evolve(SpecialTrait.FLEXIBLE_BODY_PLAN);
    }

    protected Invertebrate(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet,
                           CyrcadianRythm cyrcadianRythm, String geneSequence) {
        super(respiration, locomotion, intelligence, diet, cyrcadianRythm, geneSequence);

    }
}
