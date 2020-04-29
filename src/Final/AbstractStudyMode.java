package Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * This class encapsulate the basic file IO operation and support a table for questions and answers
 * @Shiyi(Wendy) Mao
 */

abstract public class AbstractStudyMode {
	// the question to answer table
    private Map<String, String> questionToAnswer;
    // the input file
    private File inputFile;

    /**
     * the constructor
     * @param f the file that read questions and answers from
     */
    protected AbstractStudyMode(File f) {
        this.questionToAnswer = new HashMap<>();
        this.inputFile = f;
    }

    /**
     * add a question to the question answer table
     * @param question the question
     * @param answer the answer
     */
    public void addQuestion(String question, String answer) {
        if (questionToAnswer.containsKey(question)) {
            throw new RuntimeException("This question has already included!");
        }
        this.questionToAnswer.put(question, answer);

    }

    /**
     * get all questions from the questions table
     * @return the set of all questions
     */
    public Set<String> getQuestions() {
        return this.questionToAnswer.keySet();
    }

    /**
     * get the answer for a question
     * @param question the question
     * @return answer in string
     */
    protected String getAnswer(String question){
        return this.questionToAnswer.get(question);
    }

    /**
     * The method that read questions and answers from file
     * @throws FileNotFoundException
     */
    public void loadFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
        	// get question
            String question = scanner.nextLine();
            // parse question
            question = processQuestion(question);
            // get answer
            String answer = scanner.nextLine();
            // parse answer
            answer = processAnswer(answer);
            addQuestion(question, answer);
        }
        scanner.close();
    }

    /**
     * verify the answer of a question
     * @param question the question to verify
     * @param answer the answer of the question
     * @return a boolean result to indicate the verification result
     */
    public boolean verifyAnswer(String question, String answer) {
        return this.questionToAnswer.get(question).equals(answer);
    }

    /**
     * The method that subclass needs to override to process the question read from file.
     * @param question the raw question line
     * @return a processed question string
     */
    abstract protected String processQuestion(String question);

    /**
     * The method that subclass needs to override to process the answer read from file.
     * @param answer the raw answer line
     * @return a processed answer string
     */
    abstract protected String processAnswer(String answer);


}
