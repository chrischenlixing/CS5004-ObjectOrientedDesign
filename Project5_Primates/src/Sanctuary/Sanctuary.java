package Sanctuary;

import Utils.Species;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sanctuary {
    private Isolation isolation;
    private Enclosure[] enclosures;

    public Sanctuary() {

        this.isolation = new Isolation();
        this.enclosures = new Enclosure[8];
        enclosures[0] = new Enclosure(Species.Drill);
        enclosures[1] = new Enclosure(Species.Howler);
        enclosures[2] = new Enclosure(Species.Mangabey);
        enclosures[3] = new Enclosure(Species.Quereza);
        enclosures[4] = new Enclosure(Species.Saki);
        enclosures[5] = new Enclosure(Species.Spider);
        enclosures[6] = new Enclosure(Species.Squirrel);
        enclosures[7] = new Enclosure(Species.Tamarin);
    }
    /**

     Adds a monkey to the isolation area.
     @param monkey The monkey to be added to the isolation area.
     @return True if the monkey was successfully added, false otherwise.
     */
    public boolean addMonkeyToIsolation(Monkey monkey) {
        return isolation.addMonkeyToIsolation(monkey);
    }
    /**

     Adds a monkey to an enclosure for the species of the monkey.
     @param monkey The monkey to be added to an enclosure.
     @return True if the monkey was successfully added to an enclosure, false otherwise.
     */
    public boolean addMonkeyToEnclosure(Monkey monkey) {
        for (Enclosure enclosure : enclosures) {
            if (enclosure.addMonkey(monkey)) {
                return true;
            }
        }
        return false;
    }
    /**

     Returns a list of strings containing information about the monkeys in each enclosure.
     @return A list of strings containing information about the monkeys in each enclosure.
     */
    public List<String> getEnclosureList() {
        List<String> result = new ArrayList<>();
        for (Enclosure enclosure : enclosures) {
            StringBuilder sb = new StringBuilder();
            sb.append(enclosure.getSpecies().toString() + ": ");
            Monkey[] monkeys = enclosure.getMonkeys();
            for (int i = 0; i < monkeys.length; i++) {
                if (monkeys[i] != null) {
                    sb.append(monkeys[i].getName() + " (" + monkeys[i].getSex().toString() + ", " +
                            monkeys[i].getFavoriteFood().toString() + ")");
                    if (i < monkeys.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    /**

     Returns a list of monkeys sorted alphabetically by name.
     @return A list of monkeys sorted alphabetically by name.
     */
    public List<Monkey> getAlphabeticalList() {
        List<Monkey> monkeys = new ArrayList<>();
        for (Enclosure enclosure : enclosures) {
            Collections.addAll(monkeys, enclosure.getMonkeys());
        }
        Collections.addAll(monkeys, isolation.getMonkeys());
        Comparator<Monkey> comparator = Comparator.comparing(Monkey::getName);
        Collections.sort(monkeys, comparator);
        return monkeys;
    }
    /**

     Returns a list of monkeys sorted alphabetically by name.
     @return A list of monkeys sorted alphabetically by name.
     */
    public Isolation getIsolation() {
        return this.isolation;
    }
}
