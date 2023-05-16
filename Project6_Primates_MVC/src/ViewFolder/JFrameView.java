package ViewFolder;

import Utils.Food;
import Utils.Sex;
import Utils.Species;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class JFrameView {
    private JFrame frame;
    private JTextArea outputTextArea;
    private JTextField inputTextField;

    public JFrameView() {
        frame = new JFrame("Monkey Sanctuary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Input: ");
        inputPanel.add(inputLabel);
        inputTextField = new JTextField(20);
        inputPanel.add(inputTextField);
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> {
            synchronized (this) {
                this.notify();
            }
        });
        inputTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        inputPanel.add(enterButton);
        frame.add(inputPanel, BorderLayout.SOUTH);
    }
    /**

     Displays a welcome message to the user when the program is started.
     */
    public void showWelcomeMessage() {
        outputTextArea.append("Welcome to the Monkey Sanctuary!\n");
    }
    /**

     Displays a goodbye message to the user when the program is closed.
     */
    public void showGoodbyeMessage() {
        outputTextArea.append("Goodbye!\n");
    }
    /**

     Displays the main menu options to the user.
     */
    public void showMenu() {
        outputTextArea.append("Menu:\n");
        outputTextArea.append("1. Register monkey\n");
        outputTextArea.append("2. Move monkey to enclosure\n");
        outputTextArea.append("3. View enclosures\n");
        outputTextArea.append("3. View all monkeys in sanctuary\n");
        outputTextArea.append("q. Quit\n");
    }
    /**

     Gets input from the user as a string based on the given prompt.
     @param prompt the prompt to display to the user.
     @return the user's input as a string.
     */
    public String getInput(String prompt) {
        outputTextArea.append(prompt);
        inputTextField.setText("");
        inputTextField.requestFocus();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String input = inputTextField.getText();
        outputTextArea.append(input + "\n");
        return input;
    }
    /**

     Displays an error message to the user.
     @param errorMessage the error message to display.
     */
    public void showErrorMessage(String errorMessage) {
        outputTextArea.append("Error: " + errorMessage + "\n");
    }
    /**

     Displays a success message to the user.
     @param successMessage the success message to display.
     */
    public void showSuccessMessage(String successMessage) {
        outputTextArea.append("Success: " + successMessage + "\n");
    }
    /**

     Displays a list of monkeys in a given enclosure based on their species.
     @param monkeys the list of monkeys to display.
     */
    public void showEnclosure(List<String> monkeys) {
        outputTextArea.append("All monkeys in enclosure based on their species:\n");
            outputTextArea.append(monkeys.toString() + "\n");
        }

    /**

     Displays a list of monkeys in isolation based on their index.
     @param monkeys the list of monkeys to display.
     */
    public void showIsolation(List<String> monkeys) {
        outputTextArea.append("All monkeys in isolation based on index:\n");
        outputTextArea.append(monkeys.toString() + "\n");
    }
    /**

     Displays a list of all monkeys in the sanctuary.
     @param monkeys the list of monkeys to display.
     */
    public void showAllMonkeys(List<String> monkeys) {
        outputTextArea.append("All monkeys in the Sanctuary:\n");
        outputTextArea.append(monkeys.toString() + "\n");
    }
    /**

     Gets input from the user as a Species enum based on the given prompt.
     @param prompt the prompt to display to the user.
     @return the user's input as a Species enum.
     */
    public Species getSpeciesInput(String prompt) {
        String input = getInput(prompt);
        return Species.valueOf(input);
    }

    public Sex getSexInput(String prompt) {
        String input = getInput(prompt);
        return Sex.valueOf(input);
    }

    public Food getFavoriteFoodInput(String prompt) {
        String input = getInput(prompt);
        return Food.valueOf(input);
    }

    public int getIntegerInput(String prompt) {
        String input = getInput(prompt);
        return Integer.parseInt(input);
    }

    public double getDoubleInput(String prompt) {
        String input = getInput(prompt);
        return Double.parseDouble(input);
    }

    public void show() {
        frame.setVisible(true);
    }
}
