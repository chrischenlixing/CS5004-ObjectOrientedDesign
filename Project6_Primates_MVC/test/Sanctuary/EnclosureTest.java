package Sanctuary;

import Utils.Food;
import Utils.Sex;
import org.junit.Test;
import static org.junit.Assert.*;

import Utils.Species;

public class EnclosureTest {
    @Test
    public void testAddMonkey() {
        // Create an enclosure for Squirrel monkeys
        Enclosure enclosure = new Enclosure(Species.Squirrel);

        // Create a male and a female monkey
        Monkey monkey1 = new Monkey("Sandy", Species.Squirrel, Sex.Male, 15.0, 1.0, 5, Food.Fruits);
        Monkey monkey2 = new Monkey("Lucy", Species.Squirrel, Sex.Female, 14.0, 0.9, 4, Food.Nuts);

        // Add the male monkey to the enclosure
        assertTrue(enclosure.addMonkey(monkey1));

        // Try to add the female monkey to the enclosure (should succeed)
        assertTrue(enclosure.addMonkey(monkey2));

        // Try to add another male monkey to the enclosure (should fail, wrong species)
        Monkey monkey3 = new Monkey("Max", Species.Howler, Sex.Male, 20.0, 2.0, 6, Food.Leaves);
        assertFalse(enclosure.addMonkey(monkey3));



        // Make sure the two monkeys in the enclosure are the ones we added
        Monkey[] monkeys = enclosure.getMonkeys();
        assertEquals(monkey1, monkeys[0]);
        assertEquals(monkey2, monkeys[1]);
    }

    @Test
    public void testRemoveMonkey() {
        // Create an enclosure for Mangabey monkeys
        Enclosure enclosure = new Enclosure(Species.Mangabey);

        // Create two monkeys and add them to the enclosure
        Monkey monkey1 = new Monkey("Sam", Species.Mangabey, Sex.Male, 18.0, 1.5, 8, Food.Insects);
        Monkey monkey2 = new Monkey("Molly", Species.Mangabey, Sex.Female, 17.0, 1.4, 7, Food.Fruits);
        enclosure.addMonkey(monkey1);
        enclosure.addMonkey(monkey2);

        // Remove the first monkey (should succeed)
        Monkey removedMonkey = enclosure.removeMonkey(0);
        assertEquals(monkey1, removedMonkey);

        // Try to remove a monkey from an empty enclosure (should fail)
        removedMonkey = enclosure.removeMonkey(0);
        assertNull(removedMonkey);
    }
}