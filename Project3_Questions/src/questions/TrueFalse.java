package questions;

/**
 *  can be answered in one of two ways: true or false.
 *  This type of question can be created by passing the text of the question and the correct answer.
 *  The only valid answer to this type of question is a "True" or "False".
 */
public class TrueFalse implements Question {

    private final String text;
    private final String correctAnswer;

    public TrueFalse(String text, String correctAnswer) {
        if (correctAnswer!= "True" && correctAnswer!= "False") {
            throw new IllegalArgumentException("Answer must be true or false.");
        }
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String answer(String answer) {
        if (correctAnswer == answer) {
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
        if (o instanceof TrueFalse) {
            return this.text.compareTo(((TrueFalse) o).text);
        } else {
            return -1;
        }

    }
}
