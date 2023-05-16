package questions;

import java.util.Arrays;
import java.util.List;

/**
 * offers several options, but there are multiple correct answers.
 * This type of question can be created by passing the text of the question, the correct answer and the options.
 * A question may have at least 3 options, but no more than 8. Both the correct answer and the user's answer are entered as the option numbers in a string.
 * For example, "1", "1 3", "4 1", etc. Option numbers start at 1. An answer is correct if and only if it contains all the correct options and none of the incorrect ones.
 */
public class MultipleSelect implements Question{
    private final String text;
    private final String correctOptions;
    private final List<String> options;

    public MultipleSelect (String text, String correctOptions, String... options){
        if (options.length < 3 || options.length > 8) {
            throw new IllegalArgumentException("Must have 3 to 8 options.");
        }
        this.text = text;
        this.correctOptions = correctOptions;
        this.options = Arrays.asList(options);
    }
    @Override
    public String answer(String answer) {
        char answerArray[] = answer.toCharArray();

        char correctArray[] = correctOptions.toCharArray();


        Arrays.sort(answerArray);
        Arrays.sort(correctArray);
        if (Arrays.equals(answerArray, correctArray)) {
            return CORRECT;
        } else {
            return INCORRECT;
        }
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public int compareTo(Question o) {
        if (o instanceof MultipleSelect) {
            return this.text.compareTo(((MultipleSelect) o).text);
        } else if (o instanceof Likert){
            return -1;
        } else{
            return 1;
        }
}
}
