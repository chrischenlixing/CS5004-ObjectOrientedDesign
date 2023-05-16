package ViewFolder;

import Utils.Food;
import Utils.Sex;
import Utils.Species;

import java.util.List;

public interface View {
    void showWelcomeMessage();
    void showGoodbyeMessage();
    void showMenu();
    String getInput(String prompt);
    void showErrorMessage(String errorMessage);
    void showSuccessMessage(String successMessage);
    void showEnclosure(List<String> monkeys);
    void showIsolation(List<String> monkeys);
    void showAllMonkeys(List<String> monkeys);
    Species getSpeciesInput(String prompt);
    Sex getSexInput(String prompt);
    Food getFavoriteFoodInput(String prompt);
    int getIntegerInput(String prompt);
    double getDoubleInput(String prompt);
    void show();
}