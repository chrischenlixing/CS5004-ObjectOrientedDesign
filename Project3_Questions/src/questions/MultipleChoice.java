package questions;

import java.util.Arrays;
import java.util.List;

/**
 * offers several options, only one of which is correct.
 * This type of question can be created by passing the text of the question, the correct answer and the options.
 * A question must have at least 3 options, but no more than 8. An answer can be entered as one of the option numbers in a string.
 * For example, "1", "3", etc. Option numbers start at 1.
 * Note: each option is passed to the constructor as a String argument - you will need several constructors to allow for different numbers of parameters.
 */

public class MultipleChoice implements Question{
    private final String text;
    private final String correctOption;
    private final List<String> options;

    public MultipleChoice (String text, String correctOption, String... options){
        if (options.length < 3 || options.length > 8) {
            throw new IllegalArgumentException("Must have 3 to 8 options.");
        }
        this.text = text;
        this.correctOption = correctOption;
        this.options = Arrays.asList(options);
    }
    @Override
    public String answer(String answer) {

        if (correctOption == answer) {
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
        if (o instanceof MultipleChoice) {
            return this.text.compareTo(((MultipleChoice) o).text);
        } else if (o instanceof TrueFalse){
            return 1;
        } else{
            return -1;
        }

    }
}
