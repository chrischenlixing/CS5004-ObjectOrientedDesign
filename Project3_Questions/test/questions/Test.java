package questions;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Abstract class that test the implementation of an AbstractQuestion class
 */
public class Test {

    private Question trueFalseTest;
    private Question multipleChoiceTest;
    private Question multipleSelectTest;
    private Question likertTest;


    /**
     * Setting up some instances to test this implementation
     */
    @org.junit.Before
    public void setUp() {
        //Age
        trueFalseTest = new TrueFalse("Are you younger than your father", "False");

        //Multiple Options
        String[] MCOptions = {"Waste Of time", "I should do other stuff", "Its ok", "Great","Amazing class"};
        multipleChoiceTest = new MultipleChoice("How do you feel with the class", "3", MCOptions);

        //Multiple Select
        String[] MSOptions = {"Monday", "June", "Thursday", "Mars","Sunday"};
        multipleSelectTest = new MultipleSelect("Choose the invalid days of the week", "2 4", MSOptions);

        //Likert
        likertTest  = new Likert("How do you feel about NE?");

    }


    /**
     * Give less than 3 options throw illegalArgumentException
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void testIllegalConstructorOptions() {
        Question IllegalMultipleAnswer = new MultipleChoice("Multiple","1", "a", "b");
    }

    /**
     * Give more than 8 options throw illegalArgumentException
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void testIllegalConstructorMaxedOptions() {
        Question IllegalMultipleAnswer = new MultipleChoice(
                "Multiple",
                "1",
                "a", "b", "c","d","e","f","g","t","z","w");
    }

    /**
     * create a TrueFalse with an answer different than True or False
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void testIllegalConstructorTrueFalse() {
        Question IllegalMultipleAnswer = new TrueFalse("Is Sunday","No");
    }


    /**
     * Test Answer method.
     */
    @org.junit.Test
    public void testAnswer() {

        //Correct
        assertEquals(Question.CORRECT,trueFalseTest.answer("False"));
        assertEquals(Question.CORRECT,multipleChoiceTest.answer("3"));
        assertEquals(Question.CORRECT,multipleSelectTest.answer("2 4"));
        assertEquals(Question.CORRECT,likertTest.answer("2"));
        assertEquals(Question.CORRECT,likertTest.answer("4"));


        //Incorrect
        assertEquals(Question.INCORRECT,trueFalseTest.answer("True"));
        assertEquals(Question.INCORRECT,trueFalseTest.answer("Si"));
        assertEquals(Question.INCORRECT,trueFalseTest.answer("Yes"));
        assertEquals(Question.INCORRECT,multipleChoiceTest.answer("1"));
        assertEquals(Question.INCORRECT,multipleChoiceTest.answer("1 2 3"));
        assertEquals(Question.INCORRECT,multipleSelectTest.answer("2 4 5"));
        assertEquals(Question.INCORRECT,multipleSelectTest.answer("2"));
        assertEquals(Question.INCORRECT,likertTest.answer(""));

    }

    /**
     * Test getText method.
     */
    @org.junit.Test
    public void testGetText() {

        //Correct
        assertEquals("Are you younger than your father",trueFalseTest.getText());
        assertEquals("How do you feel with the class",multipleChoiceTest.getText());
        assertEquals("Choose the invalid days of the week",multipleSelectTest.getText());
        assertEquals("How do you feel about NE?",likertTest.getText());


        //Incorrect
        assertEquals(Question.INCORRECT,trueFalseTest.answer("True"));
        assertEquals(Question.INCORRECT,multipleChoiceTest.answer("1"));
        assertEquals(Question.INCORRECT,multipleSelectTest.answer("2 4 5"));

    }

    /**
     * Check that the comparison among different classes follows the pattern
     * trueFalse -> MultipleChoice -> MultipleSelect -> Likert
     */
    @org.junit.Test
    public void testCompareTo() {

        assertEquals(-1, trueFalseTest.compareTo(likertTest));
        assertEquals(-1, trueFalseTest.compareTo(multipleChoiceTest));
        assertEquals(-1, trueFalseTest.compareTo(multipleSelectTest));

        assertEquals(1, multipleChoiceTest.compareTo(trueFalseTest));
        assertEquals(-1, multipleChoiceTest.compareTo(likertTest));
        assertEquals(-1, multipleChoiceTest.compareTo(multipleSelectTest));

        assertEquals(-1, multipleSelectTest.compareTo(likertTest));
        assertEquals(1, multipleSelectTest.compareTo(multipleChoiceTest));
        assertEquals(1, multipleSelectTest.compareTo(trueFalseTest));

        assertEquals(1, likertTest.compareTo(trueFalseTest));
        assertEquals(1, likertTest.compareTo(multipleChoiceTest));
        assertEquals(1, likertTest.compareTo(multipleSelectTest));

    }

    /**
     * Test that classes of the same type are sorting in alphabetical order
     */
    @org.junit.Test
    public void testCompareToSameType() {

        //TrueFalse
        Question order1 = new TrueFalse("Are you younger than your father", "False");
        Question order1b = new TrueFalse("Are you younger than your father", "True");
        Question order2 = new TrueFalse("Better tomorrow than today", "False");
        Question order3 = new TrueFalse("Coffee better than water", "False");
        Question order4 = new TrueFalse("You only live once?", "False");

        assertEquals(0, order1b.compareTo(order1));
        assertEquals(0, order1.compareTo(order1b));

        assertEquals(-1, order1.compareTo(order2));
        assertEquals(-1, order2.compareTo(order3));
        assertEquals(-22, order3.compareTo(order4));

        assertEquals(22, order4.compareTo(order3));
        assertEquals(1, order3.compareTo(order2));
        assertEquals(1, order2.compareTo(order1));

        //Likert
        Question orderL1 = new Likert("Are you younger than your father");
        Question orderL2 = new Likert("Better tomorrow than today");
        Question orderL3 = new Likert("Coffee better than water");
        Question orderL4 = new Likert("You only live once?");

        assertEquals(-1, orderL1.compareTo(orderL2));
        assertEquals(-1, orderL2.compareTo(orderL3));
        assertEquals(-22, orderL3.compareTo(orderL4));

        assertEquals(22, orderL4.compareTo(orderL3));
        assertEquals(1, orderL3.compareTo(orderL2));
        assertEquals(1, orderL2.compareTo(orderL1));
    }


    /**
     * Test that if we need to implement a Questionnaire we could sort our questions following
     * two patters
     *        a. trueFalse -> MultipleChoice -> MultipleSelect -> Likert
     *        b. inside each class sort in alphabetical order
     */
    @org.junit.Test
    public void testCompareQuestionnaire() {

        List<Question> questionnaire = new ArrayList<>();

        String[] options = {"a", "b" , "c" , "d"};

        Question order1L = new Likert("A-Likert");
        Question order2L = new Likert("B-Likert");
        Question order3L = new Likert("C-Likert");
        Question order4L = new Likert("D-Likert");

        //TrueFalse
        Question order1TF = new TrueFalse("A-TF", "False");
        Question order2TF = new TrueFalse("B-TF", "True");
        Question order3TF = new TrueFalse("C-TF", "False");
        Question order4TF = new TrueFalse("D-TF", "False");

        String[] solutionMC = {"a"};
        //MC
        Question order1MC = new MultipleChoice("A-MC","a", options);
        Question order2MC = new MultipleChoice("B-MC","b", options);
        Question order3MC = new MultipleChoice("C-MC", "c", options);
        Question order4MC = new MultipleChoice("D-MC","d", options);

        //Ms
        String[] solutionMS = {"a", "b"};
        Question order1MS = new MultipleSelect("A-MS", "a b", options);
        Question order2MS = new MultipleSelect("B-MS", "a b", options);
        Question order3MS = new MultipleSelect("C-MS", "a b", options);
        Question order4MS = new MultipleSelect("D-MS", "a b", options);


        questionnaire.add(order3L);
        questionnaire.add(order3TF);
        questionnaire.add(order3MC);
        questionnaire.add(order3MS);

        questionnaire.add(order2L);
        questionnaire.add(order2TF);
        questionnaire.add(order2MC);
        questionnaire.add(order2MS);

        questionnaire.add(order1L);
        questionnaire.add(order1TF);
        questionnaire.add(order1MC);
        questionnaire.add(order1MS);

        questionnaire.add(order4L);
        questionnaire.add(order4TF);
        questionnaire.add(order4MC);
        questionnaire.add(order4MS);


        String[] correctOrder = {
                "A-TF",
                "B-TF",
                "C-TF",
                "D-TF",
                "A-MC",
                "B-MC",
                "C-MC",
                "D-MC",
                "A-MS",
                "B-MS",
                "C-MS",
                "D-MS",
                "A-Likert",
                "B-Likert",
                "C-Likert",
                "D-Likert",
        };

        //Sort using double dispatch approach
        Collections.sort(questionnaire);

        for (int i = 0; i < correctOrder.length ; i++) {
            assertEquals(correctOrder[i], questionnaire.get(i).getText());
        }
    }
}