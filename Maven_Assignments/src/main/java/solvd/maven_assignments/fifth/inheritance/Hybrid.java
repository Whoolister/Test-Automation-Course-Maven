package solvd.maven_assignments.fifth.inheritance;

import solvd.maven_assignments.fifth.enums.Diet;
import solvd.maven_assignments.fifth.enums.Intelligence;
import solvd.maven_assignments.fifth.enums.Locomotion;
import solvd.maven_assignments.fifth.enums.Respiration;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);
    }
}
