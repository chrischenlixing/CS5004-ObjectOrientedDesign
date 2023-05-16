import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Sanctuary.Isolation;
import Sanctuary.Monkey;
import Utils.Food;
import Utils.Sex;
import Utils.Species;

public class IsolationTest {

    private Isolation isolation;

    @Before
    public void setUp() {
        isolation = new Isolation();
    }

    Monkey monkey = new Monkey("Monkey", Species.Mangabey, Sex.Female, 100, 50, 10, Food.Eggs);

    @Test
    public void testAddMonkey() {
        // Add 5 monkeys to the isolation
        for (int i = 0; i < 20; i++) {
            assertTrue(isolation.addMonkeyToIsolation(monkey));
        }

        // Try to add another monkey, should fail since isolation is full
        Monkey monkey = new Monkey("Monkey 5", Species.Drill, Sex.Male, 100, 50, 10, Food.TreeSap);
        assertFalse(isolation.addMonkeyToIsolation(monkey));
    }

    @Test
    public void testRemoveMonkey() {
        // Add 5 monkeys to the isolation
        for (int i = 0; i < 5; i++) {
            isolation.addMonkeyToIsolation(monkey);
        }

        // Remove the second monkey
        Monkey removedMonkey = isolation.removeMonkey(1);
        assertNotNull(removedMonkey);
        assertEquals("Monkey", removedMonkey.getName());

        // Try to remove a monkey at an invalid index, should return null
        assertNull(isolation.removeMonkey(5));
    }

    @Test
    public void testGetMonkeys() {
        // Add 5 monkeys to the isolation
        for (int i = 0; i < 5; i++) {
            isolation.addMonkeyToIsolation(monkey);
        }

        // Get the array of monkeys and check that it's not null and has a length of 20
        Monkey[] monkeys = isolation.getMonkeys();
        assertNotNull(monkeys);
        assertEquals(20, monkeys.length);

        // Check that the first 5 elements in the array are the monkeys we added
        for (int i = 0; i < 5; i++) {
            assertNotNull(monkeys[i]);
            assertEquals("Monkey" , monkeys[i].getName());
        }

        // Check that the remaining elements in the array are null
        for (int i = 5; i < monkeys.length; i++) {
            assertNull(monkeys[i]);
        }
    }

}