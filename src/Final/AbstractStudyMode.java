package Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

abstract public class AbstractStudyMode {
    private Map<String, String> questionToAnswer;
    private File inputFile;

    protected AbstractStudyMode(File f) {
        this.questionToAnswer = new HashMap<>();
        this.inputFile = f;
    }

    public void addQuestion(String question, String answer) {
        if (questionToAnswer.containsKey(question)) {
            throw new RuntimeException("This question has already included!");
        }
        this.questionToAnswer.put(question, answer);

    }

    public Set<String> getQuestions() {
        return this.questionToAnswer.keySet();
    }

    protected String getAnswer(String question){
        return this.questionToAnswer.get(question);
    }

    public void loadFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String question = scanner.nextLine();
            question = processQuestion(question);
            String answer = scanner.nextLine();
            answer = processAnswer(answer);
            addQuestion(question, answer);
        }
        scanner.close();
    }

    public boolean verifyAnswer(String question, String answer) {
        return this.questionToAnswer.get(question).equals(answer);
    }

    abstract protected String processQuestion(String question);

    abstract protected String processAnswer(String answer);


}
