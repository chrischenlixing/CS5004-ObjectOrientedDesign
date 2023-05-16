package ControllerFolder;

import Sanctuary.Sanctuary;
import Sanctuary.Monkey;
import Utils.Food;
import Utils.Sex;
import Utils.Species;
import ViewFolder.JFrameView;

import java.util.List;

public class Controller {
    private Sanctuary model;
    private JFrameView view;

    public Controller(Sanctuary model, JFrameView view) {
        this.model = model;
        this.view = view;
    }

    public void initialize() {
        view.showWelcomeMessage();
        view.showMenu();
        String choice = view.getInput("Enter choice: ");
        while (!choice.equals("q")) {
            switch (choice) {
                case "1":
                    registerMonkey();
                    break;
                case "2":
                    moveMonkey();
                    break;
                case "3":
                    viewEnclosure();
                    break;
                case "4":
                    printAllMonkeys();
                    break;
                default:
                    view.showErrorMessage("Invalid choice.");
                    break;
            }
            view.showMenu();
            choice = view.getInput("Enter choice: ");
        }
        view.showGoodbyeMessage();
    }

    private void registerMonkey() {
        String name = null;
        Species species = null;
        Sex sex = null;
        double size = 0.0;
        double weight = 0.0;
        int age = 0;
        Food favoriteFood = null;

        while (name == null) {
            try {
                name = view.getInput("Enter monkey name: ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey name. Please try again.");
            }
        }

        while (species == null) {
            try {
                species = view.getSpeciesInput("Enter monkey species (Drill/Howler/Mangabey/Quereza/Saki/Spider/Squirrel/Tamarin): ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey species. Please try again.");
            }
        }

        while (sex == null) {
            try {
                sex = view.getSexInput("Enter monkey sex (Male/Female): ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey sex. Please try again.");
            }
        }

        while (size == 0.0) {
            try {
                size = view.getDoubleInput("Enter monkey size: ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey size. Please try again.");
            }
        }

        while (weight == 0.0) {
            try {
                weight = view.getDoubleInput("Enter monkey weight: ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey weight. Please try again.");
            }
        }

        while (age == 0) {
            try {
                age = view.getIntegerInput("Enter monkey age: ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey age. Please try again.");
            }
        }

        while (favoriteFood == null) {
            try {
                favoriteFood = view.getFavoriteFoodInput("Enter monkey favorite food (Eggs, Fruits, Insects, Leaves, Nuts, Seeds, TreeSap): ");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage("Invalid input for monkey favorite food. Please try again.");
            }
        }

        Monkey monkey = new Monkey(name, species, sex, size, weight, age, favoriteFood);
        boolean added = model.addMonkeyToIsolation(monkey);
        if (added) {
            view.showSuccessMessage("Monkey added successfully.");
        } else {
            view.showErrorMessage("Could not add monkey to isolation: isolation is full.");
        }
    }

    private void moveMonkey() {
        view.showIsolation(model.getMonkeyinIsolation());
        int monkeyIndex = view.getIntegerInput("Enter index of monkey in isolation to move: ");
        Monkey monkey = model.getIsolation().removeMonkey(monkeyIndex);
        if (monkey != null) {
            boolean added = model.addMonkeyToEnclosure(monkey);
            if (added) {
                view.showSuccessMessage("Monkey moved to enclosure successfully.");
            } else {
                view.showErrorMessage("Could not add monkey to enclosure: all enclosures for this species are full.");
                model.getIsolation().addMonkeyToIsolation(monkey);
            }
        } else {
            view.showErrorMessage("Could not find monkey at index " + monkeyIndex);
        }
    }


    private void viewEnclosure() {
        List<String> monkeys = model.getEnclosureList();
        view.showEnclosure(monkeys);
    }

    private void viewIsolation() {
        List<String> monkeys = model.getMonkeyinIsolation();
        view.showIsolation(monkeys);
    }

    private void printAllMonkeys(){
        List<String> monkeys = model.getAlphabeticalList();
        view.showAllMonkeys(monkeys);
    }
}
