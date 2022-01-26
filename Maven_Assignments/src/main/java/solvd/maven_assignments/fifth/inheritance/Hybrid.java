package inheritance;

import enums.Diet;
import enums.Intelligence;
import enums.Locomotion;
import enums.Respiration;

public class Hybrid extends Animal {
    public Hybrid(Respiration respiration, Locomotion locomotion, Intelligence intelligence, Diet diet) {
        super(respiration, locomotion, intelligence, diet);
    }
}
