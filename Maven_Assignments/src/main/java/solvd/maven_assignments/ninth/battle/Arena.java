package solvd.maven_assignments.ninth.battle;

import org.apache.commons.lang3.StringUtils;
import solvd.maven_assignments.ninth.enums.Ordering;
import solvd.maven_assignments.ninth.enums.Stat;
import solvd.maven_assignments.ninth.enums.Weather;
import solvd.maven_assignments.ninth.exceptions.DefeatedException;
import solvd.maven_assignments.ninth.exceptions.ExcessRankException;
import solvd.maven_assignments.ninth.exceptions.ExhaustedException;
import solvd.maven_assignments.ninth.exceptions.MissException;
import solvd.maven_assignments.ninth.inheritance.Animal;
import solvd.maven_assignments.ninth.inheritance.Facility;
import solvd.maven_assignments.ninth.utilities.Randomizer;

import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Arena extends Facility {
    public static void hostTournament(Scanner scanner) {
        openFacilities();
        ArrayList<Animal> roster = null;

        LOG.logAndShow(Level.INFO,
                StringUtils.center("ENTERING THE TOURNAMENT", 54) + System.lineSeparator()
                        + "/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\\n"
                        + "--+---+---+---+---+---+---+---+---+---+---+---+---+--\n"
                        + "o | o   o | o   o | o   o | o   o | o   o | o   o | o\n"
                        + "--+---+---+---+---+---+---+---+---+---+---+---+---+--\n"
                        + "o   o | o   o | o   o | o   o | o   o | o   o | o   o\n"
                        + "--+---+---+---+---+---+---+---+---+---+---+---+---+--" + System.lineSeparator());

        if (specimens.size() != 0) {
            LOG.logAndShow(Level.INFO,
                    "What mode do you want to use?" + System.lineSeparator()
                            + "\t>-> Type 1 to use the exhibits saved from the Zoo" + System.lineSeparator()
                            + "\t>-> Type 2 to randomly generate combatants" + System.lineSeparator());

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int mode = scanner.nextInt();
                    if (mode == 1) {
                        roster = new ArrayList<>(specimens);
                        specimens.clear();
                        break;
                    } else if (mode == 2) {
                        roster = rngSpecimens(scanner);
                        break;
                    } else {
                        LOG.logAndShow(Level.SEVERE,
                                "ERRONEOUS INPUT (" + mode + ") Must input 1 or 2." + System.lineSeparator());
                    }
                } else {
                    LOG.logAndShow(Level.SEVERE, "ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
                    scanner.next();
                }
            }
        } else {
            LOG.logAndShow(Level.INFO, "No specimens available in our holding bay, heading to the lab:");
            roster = rngSpecimens(scanner);
        }

        roster.forEach(animal -> animal.generateBaseStatBlock());

        int cycles = 1;
        while (roster.size() > 1) {
            bracketMaker(roster);

            ArrayList<Animal> survivors = new ArrayList<>();

            LOG.logAndShow(Level.INFO, "Match Cycle " + cycles + ": " + System.lineSeparator()
                    + "==<O>===<0>- -<0>===<O>==" + System.lineSeparator());
            // CYCLE FIGHTS
            for (int fights = 0; fights < roster.size(); fights += 2) {
                LOG.logAndShow(Level.INFO, "Press any key, and hit ENTER to begin:");
                scanner.next();

                try {
                    LOG.logAndShow(Level.INFO,
                            "---<O>===<O>===<O>===<O>---" + System.lineSeparator() + roster.get(fights).getName()
                                    + " Vs " + roster.get(fights + 1).getName() + System.lineSeparator()
                                    + "^-^-^-^-^-^-^-^-^-^");

                    survivors.add(fight(roster.get(fights), roster.get(fights + 1)));
                } catch (IndexOutOfBoundsException e) {
                    LOG.logAndShow(Level.INFO,
                            "There's no one to put " + roster.get(roster.size() - 1).getName()
                                    + " against, so they'll be advancing the ranking. However, they won't rank up."
                                    + System.lineSeparator());
                    survivors.add(roster.remove(roster.size() - 1));
                } catch (ExcessRankException excess) {
                    LOG.logAndShow(Level.SEVERE, roster + System.lineSeparator() + excess.getMessage());
                    LOG.turnOffLogger();
                    System.exit(0);
                }
            }

            if (survivors.size() > 1) {
                Ordering ordering = Ordering.values()[new Random().nextInt(Ordering.values().length)];
                LOG.logAndShow(Level.INFO, "NEXT MATCH CYCLE : " + ordering.name() + System.lineSeparator()
                        + ordering.getDescription() + System.lineSeparator());
                // STREAM IMPLEMENTATION
                roster = new ArrayList<>(
                        survivors.stream().sorted(ordering.getComparator()).collect(Collectors.toList()));
                cycles++;
            } else {
                break;
            }
        }
        // PACER
        LOG.logAndShow(Level.INFO, "Press any key, and hit ENTER to show the winner:");
        scanner.next();

        Animal winner = roster.remove(0);

        LOG.logAndShow(Level.INFO,
                "  .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.\n"
                        + ":::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\\n"
                        + "'      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      `"
                        + System.lineSeparator() + "\t\tW I N N E R: " + winner.getName() + System.lineSeparator()
                        + "_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_" + System.lineSeparator()
                        + winner.breathe() + System.lineSeparator() + winner.move() + System.lineSeparator()
                        + winner.think() + System.lineSeparator() + winner.eat() + System.lineSeparator()
                        + winner.sleep() + System.lineSeparator());

        // FINAL LINE
        LOG.logAndShow(Level.INFO, StringUtils.center("E X I T I N G   T H E   A R E N A", 32) + System.lineSeparator()
                + "__________________________________________" + System.lineSeparator());
    }

    private static Animal fight(Animal competitorOne, Animal competitorTwo) throws ExcessRankException {
        // APPLY WEATHER CONDITIONS ON FIGHTERS
        Weather weather = Weather.values()[new Random().nextInt(Weather.values().length)];
        LOG.logAndShow(Level.INFO,
                weather.getIcon() + System.lineSeparator() + weather.getDescription() + System.lineSeparator());

        weather.getCondition().condition(competitorOne);
        weather.getCondition().condition(competitorTwo);

        ArrayDeque<Animal> queue = new ArrayDeque<>(2);

        // DECIDE FIGHTING ORDER
        if (competitorOne.getStat(Stat.SPEED) > competitorTwo.getStat(Stat.SPEED)
                || competitorOne.getStat(Stat.SPEED) == competitorTwo.getStat(Stat.SPEED)) {
            queue.addFirst(competitorOne);
            queue.addLast(competitorTwo);
        } else {
            queue.addFirst(competitorTwo);
            queue.addLast(competitorOne);
        }

        // ITERATE ROUNDS
        for (int rounds = 0; queue.size() == 2; rounds++) {
            LOG.logAndShow(Level.INFO, "Round " + (rounds + 1) + ":" + System.lineSeparator()
                    + ">---------->---------->---------->---------->");
            // FIRST HITTER
            try {
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekFirst().getName() + " Landed a hit for a " + Randomizer.hitAdjectiveGenerator()
                                + " " + queue.peekFirst().hit(queue.peekLast()) + " points of damage!"
                                + System.lineSeparator());
            } catch (MissException miss) {
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekFirst().getName() + miss.getMessage() + System.lineSeparator());
            } catch (ExhaustedException exhausted) {
                queue.peekLast().rankUP();
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekFirst().getName() + exhausted.getMessage() + queue.peekLast().getName()
                                + " has won the match, and rose to Rank " + queue.peekLast().getRank()
                                + System.lineSeparator());
                queue.removeFirst();
                break;
            } catch (DefeatedException defeated) {
                queue.peekFirst().rankUP();
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekFirst().getName() + " delivered one final blow to his opponent, dealing a "
                                + Randomizer.hitAdjectiveGenerator() + " " + defeated.getDamage() + " points of damage!"
                                + System.lineSeparator() + "They have won the match, and risen to Rank "
                                + queue.peekFirst().getRank() + System.lineSeparator());
                queue.removeLast();
                break;
            }
            // SECOND HITTER
            try {
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekLast().getName() + " Landed a hit for a " + Randomizer.hitAdjectiveGenerator()
                                + " " + queue.peekLast().hit(queue.peekFirst()) + " points of damage!"
                                + System.lineSeparator());
            } catch (MissException miss) {
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekLast().getName() + miss.getMessage() + System.lineSeparator());
            } catch (ExhaustedException exhausted) {
                queue.peekFirst().rankUP();
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekLast().getName() + exhausted.getMessage() + queue.peekFirst().getName()
                                + " has won the match, and rose to Rank " + queue.peekFirst().getRank()
                                + System.lineSeparator());
                queue.removeLast();
                break;
            } catch (DefeatedException defeated) {
                queue.peekLast().rankUP();
                LOG.logAndShow(Level.INFO,
                        ">" + queue.peekLast().getName() + " delivered one final blow to his opponent, dealing a "
                                + Randomizer.hitAdjectiveGenerator() + " " + defeated.getDamage() + " points of damage!"
                                + System.lineSeparator() + "They have won the match, and risen to Rank "
                                + queue.peekLast().getRank() + System.lineSeparator());
                queue.removeFirst();
                break;
            }
        }

        return queue.remove();

    }

    private static void bracketMaker(List<Animal> list) {
        LOG.logAndShow(Level.INFO, "M A T C H   B R A C K E T" + System.lineSeparator()
                + ">< >< >< >< >< >< >< >< >< ><" + System.lineSeparator() + "--<>--<>--<>--<>--<>--<>--<>--<>--");
        try {
            for (int index = 0; index < list.size(); index += 2) {
                LOG.logAndShow(Level.INFO,
                        list.get(index).getName() + System.lineSeparator() + " Vs " + System.lineSeparator()
                                + list.get(index + 1).getName() + System.lineSeparator()
                                + "--<>--<>--<>--<>--<>--<>--<>--<>--");
            }
        } catch (IndexOutOfBoundsException e) {
            LOG.logAndShow(Level.INFO, list.get(list.size() - 1).getName() + System.lineSeparator() + " Vs "
                    + System.lineSeparator() + ". . ." + System.lineSeparator() + "--<>--<>--<>--<>--<>--<>--<>--<>--");
        }
        LOG.logAndShow(Level.INFO, ">< >< >< >< >< >< >< >< >< ><" + System.lineSeparator());
    }
}
