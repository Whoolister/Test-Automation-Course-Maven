package solvd.maven_assignments.third.inheritance;

import java.util.Random;

public class Mollusk extends Invertebrate implements Ectothermy, Hibernation {
    protected boolean cooldown = false;

    public Mollusk() {
        super("Gills",
                (new Random()).nextInt(20) < 10 ? "None" : "Tentacles",
                (new Random()).nextInt(20) < 10 ? "None" : "High",
                (new Random()).nextInt(20) < 10 ? "Carnivorous" : "Omnivorous");

        evolve("Jet Propulsion");
        evolve("Camouflage");
    }

    public final void hide() {
        System.out.println("This being is trying to blend in with it's environment, this happens when it feels threatened. I wonder what you're gonna become...");

        switch ((new Random()).nextInt(5)) {
            case 0:
                System.out.println("It's skin turned into some sort of checkerboard pattern... Maybe it's distracting us with a friendly game of chess!");
                break;
            case 1:
                System.out.println("It's skin developed a coarse texture to it, with browns, reds, and orange colors dashed all about the surface. It kind of looks like a rock");
                break;
            case 2:
                System.out.println("It's skin is turning white like the sand at the bottom of the sea. Accompanied by a slow, gentle digging motion.");
                break;
            case 3:
                System.out.println("It's skin turned a very bleak shade of green, and it seems to be mimicking a piece of drifting plant matter!");
                break;
            case 4:
                System.out.println("It's skin turned into a very distracting stripe pattern, making it difficult to tell apart when it moves.");
                break;
            case 5:
                System.out.println("It's skin turned into a mushy, dark green mess. Not something I'd take a bite out of...");
        }
    }

    public final void escape() {
        System.out.println("This being can expel water out of their bodies at high velocities, propelling them through a fluid...\n"
                + "Oh! It spotted us!");

        if (cooldown == false) {
            Thread timer = new Thread() {
                public void run() {
                    cooldown = true;
                    System.out.println("It got away!");
                    try {
                        sleep(35000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                    cooldown = false;
                }
            };
            //STARTS THREAD, WAITS 35 SECONDS BEFORE RECOVERING
            timer.run();
        } else {
            System.out.println("It doesn't seem to have too much stamina...");

            hide();
        }
    }

    @Override
    public void hibernate() {
        System.out.println("This being can shut off their chemical exchange with the environment, alongside a dip in their metabolism, to help them survive a sudden toxicity in their environments.");
    }

    @Override
    public void regulateTemperature() {
        System.out.println("This being can only take in heat from hot surroundings, and discarge it in cold ones; this may limit their physical capabilities.");
    }

    @Override
    public String toString() {
        return "Mollusk [Respiration: " + this.respiration + "| Locomotion: " + this.locomotion + "| Intelligence: " +
                this.intelligence + "| Diet: " + this.diet + "]";
    }
}
