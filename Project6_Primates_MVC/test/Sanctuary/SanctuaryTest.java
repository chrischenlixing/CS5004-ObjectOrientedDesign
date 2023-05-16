package Sanctuary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Sanctuary.Monkey;
import Sanctuary.Sanctuary;
import Utils.Food;
import Utils.Species;
import Utils.Sex;

public class SanctuaryTest {

    private Sanctuary sanctuary;
    private Monkey monkey1;

    @Before
    public void setUp() {
        sanctuary = new Sanctuary();
        monkey1 = new Monkey("Sandy", Species.Squirrel, Sex.Male, 15.0, 1.0, 5, Food.Fruits);
    }

    @Test
    public void testAddMonkeyToIsolation() {
        boolean result = sanctuary.addMonkeyToIsolation(monkey1);
        assertTrue(result);
    }

    @Test
    public void testAddMonkeyToEnclosure() {
        boolean result = sanctuary.addMonkeyToEnclosure(monkey1);
        assertTrue(result);
    }


}