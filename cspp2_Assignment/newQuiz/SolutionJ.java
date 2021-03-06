import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * Constructs the object.
     */
    protected Quiz(){
        //empty constructor.
    }
    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();
    ArrayList<Integer> maxMarks = new ArrayList<Integer>();
    ArrayList<Integer> penalityMarks = new ArrayList<Integer>();
    ArrayList<String> chooses = new ArrayList<String>();
    ArrayList<String> inputanswers = new ArrayList<String>();


    /**
     * Adds a question.
     *
     * @param      question  The question
     */
    void addQuestion(String question) {
        questions.add(question);
    }
    /**
     * Adds an answer.
     *
     * @param      answer  The answer
     */
    void addAnswer(String answer) {
        //System.out.println(answer);
        answers.add(answer);

    }
    /**
     * Adds choices.
     *
     * @param      choice  The choice
     */
    void addchoice(String choice) {
        chooses.add(choice);
    }
    /**
     * Adds maximum marks.
     *
     * @param      maxmark  The maxmark
     */
    void addMaxMarks(int maxmark) {
        maxMarks.add(maxmark);
    }
    /**
     * Adds Penality.
     *
     * @param      penality  The penality
     */
    void addpenality(int penality) {
        penalityMarks.add(penality);
    }
    /**
     * Displays the Quiz List.
     */
    void displayQuizList() {
        if (questions.size() != 0 && answers.size() != 0 && penalityMarks.size() != 0 && maxMarks.size() != 0 && chooses.size() != 0) {
            int i = 0;
            for (String que : questions) {
                System.out.println(que + "(" + maxMarks.get(i) + ")");
                System.out.println(chooses.get(i));
                System.out.println();
                i++;
            }
        }
    }

    /**
     * Adds an user answer.
     *
     * @param      answer  Theanswer
     */
    void addUserAnswer(final String answer) {
        //System.out.println(answer);
        inputanswers.add(answer);
    }

    /**
     * display Score.
     */
    void displayScore() {
        if (questions.size() != 0 && answers.size() != 0
            && penalityMarks.size() != 0
            && maxMarks.size() != 0
            && chooses.size() != 0) {
            int i = 0;
            int score = 0;
            for (String ans : answers) {
                System.out.println(questions.get(i));
                if (ans.equals(inputanswers.get(i))) {
                    System.out.println(" Correct Answer! - Marks Awarded: "
                        + maxMarks.get(i));
                    score += maxMarks.get(i);
                } else {
                    // Wrong Answer! - Penalty: -4Total Score: 10
                    System.out.println(" Wrong Answer! - Penalty: "
                        + penalityMarks.get(i));
                    score += penalityMarks.get(i);
                }
                i++;
            }
            System.out.println("Total Score: " + score);

        }

    }


}
/**
 * Solution class for code-eval.
 */
public final class SolutionJ {
    /**
    * Constructs the object.
    */
    private SolutionJ() {
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
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount <= 0) {
            System.out.println("Quiz does not have questions");
            return;
        }


        for (int i = 0; i < questionCount; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(":");
            try {
                if (tokens[0].equals("")) {
                    System.out.println("Error! Malformed question");
                    throw new Exception();
                }
                quiz.addQuestion(tokens[0]);
                if (tokens[1].length() < 17) {
                    System.out.println(tokens[0] + " does not have enough answer choices");
                    return;
                }
                quiz.addchoice(tokens[1].replace(",", "\t"));
                if (Integer.parseInt(tokens[2]) > 4) {
                    System.out.println("Error! Correct answer choice number is out of range for question text " + (i + 1));
                    return;
                }

                int ind = Integer.parseInt(tokens[2]) - 1;
                String[] tmp = tokens[1].split(",");

                quiz.addAnswer(tmp[ind]);

                if (Integer.parseInt(tokens[3]) < 0) {
                    System.out.println("Invalid max marks for " + tokens[i]);
                    return;
                }
                quiz.addMaxMarks(Integer.parseInt(tokens[3]));

                if (Integer.parseInt(tokens[4]) > 0) {
                    System.out.println("Invalid penalty for " + tokens[i]);
                    return;
                }
                quiz.addpenality(Integer.parseInt(tokens[4]));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error! Malformed question");
                return;
            } catch (Exception e) {
                return;
            }

        }

        System.out.println(questionCount + " are added to the quiz");

    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.displayQuizList();

        for (int i = 0; i < answerCount; i++) {
            String line = s.nextLine();
            quiz.addUserAnswer(line);
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.displayScore();
    }
}








