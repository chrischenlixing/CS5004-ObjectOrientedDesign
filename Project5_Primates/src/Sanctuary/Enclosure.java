package Sanctuary;

import Utils.Species;

public class Enclosure implements Housing {
    private Species species;
    private Monkey[] monkeys;

    /**

     Constructs an Enclosure object for a given species.
     @param species the species of monkeys that can live in this enclosure
     */
    public Enclosure(Species species) {
        this.species = species;
        this.monkeys = new Monkey[8];
    }

    /**

     Returns the species of monkeys that can live in this enclosure.
     @return the species of monkeys that can live in this enclosure
     */
    public Species getSpecies() {
        return species;
    }
    /**

     Attempts to add a monkey to the enclosure.
     @param monkey the monkey to be added to the enclosure
     @return true if the monkey was added successfully, false otherwise
     */
    public boolean addMonkey(Monkey monkey) {
        if (monkey.getSpecies() == species) {
            for (int i = 0; i < monkeys.length; i++) {
                if (monkeys[i] == null) {
                    monkeys[i] = monkey;
                    return true;
                }
            }
        }

        return false;
    }

    /**

     Removes a monkey from the enclosure.
     @param index the index of the monkey to be removed
     @return the removed monkey, or null if the index is out of bounds
     */
    public Monkey removeMonkey(int index) {
        if (index < 0 || index >= monkeys.length) {
            return null;
        }
        Monkey removedMonkey = monkeys[index];
        monkeys[index] = null;
        return removedMonkey;
    }

    /**

     Returns an array of all the monkeys in the enclosure.
     @return an array of all the monkeys in the enclosure
     */
    public Monkey[] getMonkeys() {
        return monkeys;
    }
}