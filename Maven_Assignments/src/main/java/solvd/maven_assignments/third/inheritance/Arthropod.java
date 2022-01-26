package inheritance;

import java.util.Random;

public class Arthropod extends Invertebrate implements Ectothermy, Agriculture, Swarm {
    protected boolean hardened = true;

    public Arthropod() {
        super("Skin Diffusion",
                (new Random()).nextInt(20) < 10 ? "Winged" : "Multi-Legged",
                (new Random()).nextInt(20) < 10 ? "Some" : "Population Based",
                (new Random()).nextInt(20) < 10 ? "Carnivorous" : "Herbivorous");

        evolve("Exoskeleton");
        evolve("Limitless Offspring");
        evolve("Compound Eyes");
    }

    public final void molt() {
        System.out.println("This being's hard exoskeleton limits their growth, requiring them to burst through their shell repeatedly throughout their lives, or die trying...\n"
                + "Oh! It's starting!");

        Thread timer = new Thread() {
            public void run() {
                hardened = false;
                System.out.println("A successful molt! Now, to hide and wait for the body to harden...");
                try {
                    sleep(60000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                hardened = true;
                System.out.println("Finally, this being has hardened their new exoskeleton.");
            }
        };
        //STARTS THE THREAD, WAITS 60 SECONDS BEFORE 'HARDENING'
        timer.run();
    }

    public final boolean isHardened() {
        return hardened;
    }

    @Override
    public void congregate() {
        System.out.println("This being can join into medium to large groups of it's own species, sometimes to devastating effect on the environment.");
    }

    @Override
    public void cultivate() {
        if (this.intelligence == "Some") {
            System.out.println("This being can participate in a mutualistic relationship with different plant species, protecting them in exchange for a steady source of nutrition.");
        } else if (this.intelligence == "Population Based") {
            System.out.println("This being dedicates a part of its colony to feeding and growing nutritious mycelium, although it may not understand what it's really doing.");
        }
    }

    @Override
    public void raiseAnimals() {
        if (this.intelligence == "Some") {
            System.out.println("This being doesn't yet have the capacity to raise other animals, maybe in a further evolution.");
        } else if (this.intelligence == "Population Based") {
            System.out.println("This being can enter a mutualistic relationship with certain other species, by protecting them and feeding on their residues.");
        }
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may force them to move around constantly.");
    }

    @Override
    public String toString() {
        return "Arthropod [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
