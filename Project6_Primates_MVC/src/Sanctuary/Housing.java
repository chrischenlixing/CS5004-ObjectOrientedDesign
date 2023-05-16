package Sanctuary;

public interface Housing {

    /**

     Removes a monkey from the monkey housing area.
     @param index the index of the monkey to be removed
     @return the removed monkey, or null if the index is out of bounds
     */
    public Monkey removeMonkey(int index);

    /**
     * Returns an array of all the monkeys in the monkey housing area.
     *
     * @return an array of all the monkeys in the monkey housing area
     */
    public static Monkey[] getMonkeys() {
        return new Monkey[0];
    }

}