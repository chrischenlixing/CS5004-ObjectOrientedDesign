package Sanctuary;

import Utils.Food;
import Utils.Sex;
import Utils.Species;

public class Monkey {
    private String name;
    private Species species;
    private Sex sex;
    private double size;
    private double weight;
    private int age;
    private Food favoriteFood;

    public Monkey(String name, Species species, Sex sex, double size, double weight, int age, Food favoriteFood) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }
    /**

     Returns the name of the monkey.
     @return the name of the monkey
     */
    public String getName() {
        return name;
    }
    /**

     Returns the species of the monkey.
     @return the species of the monkey
     */
    public Species getSpecies() {
        return species;
    }
    /**

     Returns the sex of the monkey.
     @return the sex of the monkey
     */
    public Sex getSex() {
        return sex;
    }
    /**

     Returns the size of the monkey.
     @return the size of the monkey
     */
    public double getSize() {
        return size;
    }
    /**

     Returns the weight of the monkey.
     @return the weight of the monkey
     */
    public double getWeight() {
        return weight;
    }
    /**

     Returns the age of the monkey.
     @return the age of the monkey
     */
    public int getAge() {
        return age;
    }
    /**

     Returns the favorite food of the monkey.
     @return the favorite food of the monkey
     */
    public Food getFavoriteFood() {
        return favoriteFood;
    }
}

