package battle;

import exceptions.DepletedHealthException;
import exceptions.NegativeStaminaException;
import inheritance.Animal;

import java.util.ArrayList;

public class Arena {
    public static String hostFight(Animal firstCompetitor, Animal secondCompetitor) {
        StringBuilder log = new StringBuilder();
        log.append("G O" + System.lineSeparator());

        for (int index = 0; true; index++) {
            try {
                log.append((index + 1) + "� Round:" + System.lineSeparator());
                if (firstCompetitor.getSpeed() > secondCompetitor.getSpeed()) {
                    log.append(firstCompetitor.hit(secondCompetitor) ?
                            "A successful hit from " + firstCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + firstCompetitor.getName() + "!" + System.lineSeparator());
                    log.append(secondCompetitor.hit(firstCompetitor) ?
                            "A successful hit from " + secondCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + secondCompetitor.getName() + "!" + System.lineSeparator());
                } else if (secondCompetitor.getSpeed() > firstCompetitor.getSpeed()) {
                    log.append(secondCompetitor.hit(firstCompetitor) ?
                            "A successful hit from " + secondCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + secondCompetitor.getName() + "!" + System.lineSeparator());
                    log.append(firstCompetitor.hit(secondCompetitor) ?
                            "A successful hit from " + firstCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + firstCompetitor.getName() + "!" + System.lineSeparator());
                } else {
                    log.append(firstCompetitor.hit(secondCompetitor) ?
                            "A successful hit from " + firstCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + firstCompetitor.getName() + "!" + System.lineSeparator());
                    log.append(secondCompetitor.hit(firstCompetitor) ?
                            "A successful hit from " + secondCompetitor.getName() + "!" + System.lineSeparator() :
                            "A miss from " + secondCompetitor.getName() + "!" + System.lineSeparator());
                }
            } catch (DepletedHealthException e) {
                log.append(e.getMessage());
                break;
            } catch (NegativeStaminaException e) {
                log.append(e.getMessage());
                break;
            }
        }

        return log.toString();
    }

    public static String bracketMaker(ArrayList<Animal> list) {
        String bracket = "";

        try {
            for (int index = 0; index < list.size(); index += 2) {
                bracket += list.get(index).getName() +
                        "\n  Vs\n" +
                        list.get(index + 1).getName() + "\n----------\n";
            }
        } catch (IndexOutOfBoundsException e) {
            bracket += list.get(list.size() - 1).getName() +
                    "\n  Vs \n" +
                    "A particularly violent gust of wind!\n\n";
        }

        return bracket;
    }
}
