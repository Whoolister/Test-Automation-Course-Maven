package sixth_solvd_assignment.inheritance;

import sixth_solvd_assignment.enums.Diet;
import sixth_solvd_assignment.enums.Intelligence;
import sixth_solvd_assignment.enums.Locomotion;
import sixth_solvd_assignment.enums.Respiration;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);
    }
}
