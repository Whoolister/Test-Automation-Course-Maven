package inheritance;

import enums.Diet;
import enums.Intelligence;
import enums.Locomotion;
import enums.Respiration;
import enums.*;
import exceptions.BadVariableException;
import interfaces.IAgriculture;
import interfaces.IEctothermy;
import interfaces.ISwarm;

import java.util.Random;

public class Arthropod extends Invertebrate implements IEctothermy, IAgriculture, ISwarm {
    private boolean hardened = true;

    public Arthropod() {
        super(Respiration.SKIN_DIFFUSION,
                (new Random()).nextInt(2) != 1 ? Locomotion.WINGED : Locomotion.MULTI_LEGGED,
                (new Random()).nextInt(2) != 1 ? Intelligence.POPULATION_BASED : Intelligence.SOME,
                (new Random()).nextInt(2) != 1 ? Diet.HERBIVOROUS : Diet.CARNIVOROUS);

        evolve(SpecialTrait.EXOSKELETON);
        evolve(SpecialTrait.IRRITANT_STINGS);
        evolve(SpecialTrait.COMPOUND_EYES);
    }

    public final String molt() {
        if (hardened) {
            Thread timer = new Thread() {
                public void run() {
                    hardened = false;
                    System.out.println();
                    try {
                        sleep(60000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                    hardened = true;
                }
            };
            //STARTS THE THREAD, WAITS 60 SECONDS BEFORE 'HARDENING'
            timer.run();

            return "A successful molt! Now, to hide and wait for the body to harden...";
        } else {
            return "It isn't even done hardening from it's last molt!";
        }
    }

    public final boolean isHardened() {
        return hardened;
    }

    @Override
    public String congregate() {
        return "This being can join into medium to large groups of it's own species, sometimes to devastating effect on the environment.";
    }

    @Override
    public String cultivate() throws BadVariableException {
        if (this.intelligence == Intelligence.SOME) {
            return "This being can participate in a mutualistic relationship with different plant species, protecting them in exchange for a steady source of nutrition.";
        } else if (this.intelligence == Intelligence.POPULATION_BASED) {
            return "This being dedicates a part of its colony to feeding and growing nutritious mycelium, although it may not understand what it's really doing.";
        }

        throw new BadVariableException("In Cultivation");
    }

    @Override
    public String raiseAnimals() throws BadVariableException {
        if (this.intelligence == Intelligence.SOME) {
            return "This being doesn't yet have the capacity to raise other animals, maybe in a further evolution.\n";
        } else if (this.intelligence == Intelligence.POPULATION_BASED) {
            return "This being can enter a mutualistic relationship with certain other species, by protecting them and feeding on their residues.\n";
        }

        throw new BadVariableException("In Husbandry");
    }

    @Override
    public String regulateTemperature() {
        return "This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.\n";
    }

    @Override
    public String toString() {
        return "Arthropod [Name: " + this.name +
                " | Rank: " + this.rank +
                " | Respiration: " + this.respiration +
                " | Locomotion: " + this.locomotion +
                " | Intelligence: " + this.intelligence +
                " | Diet: " + this.diet + "]";
    }
}
