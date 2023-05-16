package questions;

/**
 * Likert: can be answered on a fixed, 5-point Likert scale (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
 * This type of question can be created by passing the text of the question. Since this question asks an opinion, there is no "correct" answer.
 * An answer can be entered as one of the option numbers, numbered from 1 in the above order. Any valid option number is a "correct" answer.
 */

public class Likert implements Question{
    private final String text;

    public Likert (String text){
        this.text = text;
    }
    @Override
    public String answer(String answer) {
        if (answer == "1" || answer == "2" || answer == "3" || answer == "4" || answer == "5"){
            return CORRECT;
        }else{
            return INCORRECT;
        }
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public int compareTo(Question o) {
        if(o instanceof Likert){
            return this.text.compareTo(((Likert) o).text);
        }else{
            return 1;
        }
    }
}
