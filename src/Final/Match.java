package Final;

import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 

public class Match extends AbstractStudyMode implements CanPlay {
	static int NUM_PER_RUN = 5;
    public Match(File f) throws FileNotFoundException { //constructor 
    	super(f);
    	loadFromFile();
    }

	@Override
	protected String processQuestion(String question) {
		return question;
	}

	@Override
	protected String processAnswer(String answer) {
		answer = answer.replace("-","");
		return answer.strip();
	}

	public void beginExercise() {
    	System.out.println("Welcome to the Match section! In this section, you will be given a list of");
		System.out.println("definitions and a list of word. Try to match them correctly!");
		System.out.println();
    	
    	Set<String> questionSet = getQuestions();
    	Scanner input = new Scanner(System.in);

    	List<String> questionList = new ArrayList<>(questionSet);
    	Collections.shuffle(questionList);

    	int i = 0;
    	while(i < questionList.size()){
    		System.out.println((i / NUM_PER_RUN + 1) + "th " + "Question:");
    		int end = Math.min(i + NUM_PER_RUN, questionList.size());
    		List<String> partitionQuestionList = questionList.subList(i, end);

    		List<String> correctAnswerList = getAnswerList(partitionQuestionList);
    	    Collections.shuffle(correctAnswerList);

			printMatching(partitionQuestionList, correctAnswerList);
			// take answer
			List<Integer> userAnswerList = takeAnswers(input, partitionQuestionList);
			// print result
			printResult(partitionQuestionList, correctAnswerList, userAnswerList);
			i += NUM_PER_RUN;
		}
     }
