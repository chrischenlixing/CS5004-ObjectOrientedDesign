package Sanctuary;

public class Isolation implements Housing{
    private static Monkey[] monkeys;

    /**

     Constructs an Isolation object with a capacity of 20 monkeys.
     */
    public Isolation() {
        this.monkeys = new Monkey[20];
    }

    /**

     Attempts to add a monkey to the isolation area.
     @param monkey the monkey to be added to the isolation area
     @return true if the monkey was added successfully, false otherwise
     */
    public boolean addMonkeyToIsolation(Monkey monkey) {
        for (int i = 0; i < monkeys.length; i++) {
            if (monkeys[i] == null) {
                monkeys[i] = monkey;
                return true;
            }
        }
        return false;
    }


    /**

     Removes a monkey from the isolation area.
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

     Returns an array of all the monkeys in the isolation area.
     @return an array of all the monkeys in the isolation area
     */
    public Monkey[] getMonkeys() {
        return monkeys;
    }
}

