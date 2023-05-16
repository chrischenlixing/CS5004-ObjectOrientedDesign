package Sanctuary;

import Sanctuary.Monkey;
import Utils.Food;
import Utils.Sex;
import Utils.Species;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonkeyTest {
    Monkey monkey = new Monkey("George", Species.Spider, Sex.Male, 1.2, 45.0, 8, Food.Fruits);
    @Test
    public void testGetName() {
        assertEquals("George", monkey.getName());
    }

    @Test
    public void testGetSpecies() {

        assertEquals(Species.Spider, monkey.getSpecies());
    }

    @Test
    public void testGetSex() {
        assertEquals(Sex.Male, monkey.getSex());
    }

    @Test
    public void testGetSize() {
        assertEquals(1.2, monkey.getSize(), 0.01);
    }

    @Test
    public void testGetWeight() {
        assertEquals(45.0, monkey.getWeight(), 0.01);
    }

    @Test
    public void testGetAge() {
        assertEquals(8, monkey.getAge());
    }

    @Test
    public void testGetFavoriteFood() {
        assertEquals(Food.Fruits, monkey.getFavoriteFood());
    }
}