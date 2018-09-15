import java.util.Scanner;
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * index limit.
     */
    final int index = 100;
    /**
     * questions.
     */
    String[] questions = new String[index];
    /**
     * choices.
     */
    String[][] choices = new String[index][index];
    /**
     * correctAnswers.
     */
    int[] correctAnswer = new int[index];
    /**
     * userAnswers.
     */
    int[] userAnswers = new int[index];
    /**
     * marks.
     */
    int[] marks = new int[index];
    /**
     * negMarks.
     */
    int[] negMarks = new int[index];
    /**
     * userMarks.
     */
    int userMarks = 0;
    /**
     * answerCount1.
     */
    int answerCount1 = 0;
    /**
     * questionCount1.
     */
    int questionCount1 = 0;
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
                                     final Quiz quiz,
                                     final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int three = 3;
        final int five = 5;
        final int four = 4;
        quiz.questionCount1 = questionCount;
        if (questionCount != 0) {
            for (int i = 0; i < questionCount; i++) {
                String[] tokens = s.nextLine().split(":");
                if (tokens.length == five) {
                    quiz.questions[i] = tokens[0];
                    String[] tokensChoices = tokens[1].split(",");
                    for (int j = 0; j < quiz.questionCount1; j++) {
                        quiz.choices[i][j] = tokensChoices[j];
                    }
                    quiz.correctAnswer[i] = Integer.parseInt(tokens[2]);
                    quiz.marks[i] = Integer.parseInt(tokens[three]);
                    quiz.negMarks[i] = Integer.parseInt(tokens[four]);
                } else {
                    System.out.println("Error! Malformed question");
                    return;
                }
            } System.out.println(questionCount + " are added to the quiz");


        } else {
            System.out.println("Quiz does not have questions");
        }
    }


    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
                                 final Quiz quiz,
                                 final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (quiz.questionCount1 != 0) {
            quiz.answerCount1 = answerCount;
            for (int i = 0; i < answerCount; i++) {
                System.out.println(quiz.questions[i] + "(" + (i + 1) + ")");
                System.out.println(quiz.choices[i][0]
                                   + "\t" + quiz.choices[i][1]
                                   + "\t" + quiz.choices[i][2]
                                   + "\t" + quiz.choices[i][3]);
                System.out.println();
            }
            for (int i = 0; i < quiz.answerCount1; i++) {
                String[] tokensAns = s.nextLine().replace(" ", ",").split(",");
                quiz.userAnswers[i] = Integer.parseInt(tokensAns[1]);
            }
        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        if (quiz.questionCount1 != 0) {
            Scanner s = new Scanner(System.in);
            for (int i = 0; i < quiz.answerCount1; i++) {
                System.out.println("question text " + (i + 1));
                if (quiz.userAnswers[i] == quiz.correctAnswer[i]) {
                    System.out.println(" Correct Answer! - Marks Awarded: "
                                       + quiz.marks[i]);
                    quiz.userMarks += quiz.marks[i];
                } else {
                    System.out.println(" Wrong Answer! - Penality: "
                                       + quiz.negMarks[i]);
                    quiz.userMarks += quiz.negMarks[i];
                }
            }
            System.out.println("Total Score: " + quiz.userMarks);
        }
    }
}
