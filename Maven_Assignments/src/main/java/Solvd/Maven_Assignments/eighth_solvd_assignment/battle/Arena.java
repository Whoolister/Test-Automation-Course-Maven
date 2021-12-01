package eighth_solvd_assignment.battle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import eighth_solvd_assignment.enums.Stat;
import eighth_solvd_assignment.exceptions.DefeatedException;
import eighth_solvd_assignment.exceptions.ExcessRankException;
import eighth_solvd_assignment.exceptions.ExhaustedException;
import eighth_solvd_assignment.exceptions.MissException;
import eighth_solvd_assignment.inheritance.Animal;
import eighth_solvd_assignment.inheritance.Facility;
import eighth_solvd_assignment.utilities.Randomizer;

public class Arena extends Facility {
	private static LinkedList<Animal> roster = new LinkedList<Animal>();

	public static void hostTournament(Scanner scanner) {
		LOG.setupLogger();

		LOG.logAndShow(Level.INFO,
				StringUtils.center("ENTERING THE TOURNAMENT", 54) + System.lineSeparator()
						+ "/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\\n"
						+ "--+---+---+---+---+---+---+---+---+---+---+---+---+--\n"
						+ "o | o   o | o   o | o   o | o   o | o   o | o   o | o\n"
						+ "--+---+---+---+---+---+---+---+---+---+---+---+---+--\n"
						+ "o   o | o   o | o   o | o   o | o   o | o   o | o   o\n"
						+ "--+---+---+---+---+---+---+---+---+---+---+---+---+--" + System.lineSeparator());

		boolean useRNG = true;
		if (specimens != null) {
			LOG.logAndShow(Level.INFO,
					"What mode do you want to use?" + System.lineSeparator()
							+ "\t>-> Type 1 to use the exhibits saved from the Zoo" + System.lineSeparator()
							+ "\t>-> Type 2 to randomly generate combatants" + System.lineSeparator());

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int mode = scanner.nextInt();
					if (mode == 1) {
						useRNG = false;
						roster.addAll(specimens);
						specimens.clear();
						break;
					} else if (mode == 2) {
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
		}

		if (useRNG) {
			LOG.logAndShow(Level.INFO, "Input the number of combatants (Up to 16), to create for this tournament:"
					+ System.lineSeparator());
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int amount = scanner.nextInt();
					if (amount > 0 && amount <= 16) {
						LOG.logAndShow(Level.INFO, "Generating " + amount + " creatures..." + System.lineSeparator());
						roster.addAll(Randomizer.creatureCreator(amount));
						break;
					} else {
						System.out.print("ERRONEOUS INPUT (" + amount + ") Must input 1, 2, 3, 4, or 5."
								+ System.lineSeparator());
					}
				} else {
					System.out.print("ERRONEOUS INPUT: Must be an integer." + System.lineSeparator());
					scanner.next();
				}
			}
		}

		for (Animal animal : roster) {
			animal.generateStatBlock();
		}

		int cycles = 1;
		while (roster.size() > 1) {
			bracketMaker(roster);

			LinkedList<Animal> survivors = new LinkedList<>();

			LOG.logAndShow(Level.INFO, "Match Cycle " + cycles + System.lineSeparator() + "==<O>===<0>- -<0>===<O>=="
					+ System.lineSeparator());

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
							"There's no one to put " + roster.get(fights).getName()
									+ " against, so they'll be advancing the ranking. However, they won't rank up."
									+ System.lineSeparator());
					survivors.add(roster.get(fights));
				} catch (ExcessRankException excess) {
					LOG.logAndShow(Level.SEVERE, roster.toString() + System.lineSeparator() + excess.getMessage());
					System.exit(0);
				}
			}

			roster = survivors;
			cycles++;
		}

		LOG.logAndShow(Level.INFO, "Press any key, and hit ENTER to show the winner:");
		scanner.next();

		Animal winner = roster.getFirst();

		LOG.logAndShow(Level.INFO,
				"  .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.\n"
						+ ":::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\\n"
						+ "'      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      `"
						+ System.lineSeparator() + "\t\tW I N N E R: " + winner.getName() + System.lineSeparator()
						+ "_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_" + System.lineSeparator()
						+ winner.breathe() + System.lineSeparator() + winner.move() + System.lineSeparator()
						+ winner.think() + System.lineSeparator() + winner.eat() + System.lineSeparator());

		// FINAL LINE
		LOG.logAndShow(Level.INFO, StringUtils.center("E N D   O F   T O U R N A M E N T", 32) + System.lineSeparator()
				+ "__________________________________________" + System.lineSeparator());

		LOG.turnOffLogger();
	}

	public static Animal fight(Animal competitorOne, Animal competitorTwo) throws ExcessRankException {
		ArrayDeque<Animal> queue = new ArrayDeque<>(2);

		if (competitorOne.getStat(Stat.SPEED) > competitorTwo.getStat(Stat.SPEED)
				|| competitorOne.getStat(Stat.SPEED) == competitorTwo.getStat(Stat.SPEED)) {
			queue.addFirst(competitorOne);
			queue.addLast(competitorTwo);
		} else {
			queue.addFirst(competitorTwo);
			queue.addLast(competitorOne);
		}

		for (int rounds = 0; true; rounds++) {
			LOG.logAndShow(Level.INFO, "Round " + (rounds + 1) + ":" + System.lineSeparator()
					+ ">---------->---------->---------->---------->");
			// LAMBDA IMPLEMENTATION
			BiPredicate<Animal, Deque<Animal>> predicate = (fighter, order) -> {
				return (fighter.equals(order.peekFirst()));
			};

			for (Animal competitor : queue) {
				if (predicate.test(competitor, queue)) {
					try {
						LOG.logAndShow(Level.INFO,
								">" + competitor.getName() + " Landed a hit for a " + Randomizer.hitAdjectiveGenerator()
										+ " " + competitor.hit(queue.peekLast()) + " points of damage!"
										+ System.lineSeparator());
					} catch (MissException miss) {
						LOG.logAndShow(Level.INFO,
								">" + competitor.getName() + miss.getMessage() + System.lineSeparator());
					} catch (ExhaustedException exhausted) {
						queue.peekLast().rankUP();
						LOG.logAndShow(Level.INFO,
								competitor.getName() + exhausted.getMessage() + queue.peekLast().getName()
										+ " has won the match, and rose to Rank " + queue.peekLast().getRank()
										+ System.lineSeparator());
						return queue.peekLast();
					} catch (DefeatedException defeated) {
						competitorOne.rankUP();
						LOG.logAndShow(Level.INFO,
								competitor.getName() + " delivered one final blow to his opponent, dealing a "
										+ Randomizer.hitAdjectiveGenerator() + " " + defeated.getDamage()
										+ " points of damage!" + System.lineSeparator()
										+ "They have won the match, and risen to Rank " + competitor.getRank());
						return competitor;
					}
				} else {
					try {
						LOG.logAndShow(Level.INFO,
								">" + competitor.getName() + " Landed a hit for a " + Randomizer.hitAdjectiveGenerator()
										+ " " + competitor.hit(queue.peekFirst()) + " points of damage!"
										+ System.lineSeparator());
					} catch (MissException miss) {
						LOG.logAndShow(Level.INFO,
								">" + competitor.getName() + miss.getMessage() + System.lineSeparator());
					} catch (ExhaustedException exhausted) {
						queue.peekFirst().rankUP();
						LOG.logAndShow(Level.INFO,
								competitor.getName() + exhausted.getMessage() + queue.peekFirst().getName()
										+ " has won the match, and rose to Rank " + queue.peekFirst().getRank()
										+ System.lineSeparator());
						return queue.peekFirst();
					} catch (DefeatedException defeated) {
						competitorOne.rankUP();
						LOG.logAndShow(Level.INFO,
								competitor.getName() + " delivered one final blow to his opponent, dealing a "
										+ Randomizer.hitAdjectiveGenerator() + " " + defeated.getDamage()
										+ " points of damage!" + System.lineSeparator()
										+ "They have won the match, and risen to Rank " + competitor.getRank());
						return competitor;
					}
				}
			}
		}
	}

	public static void bracketMaker(List<Animal> list) {
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
