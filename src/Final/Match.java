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

	private void printResult(List<String> partitionQuestionList, List<String> correctAnswer, List<Integer> userAnswerList) {
		String answerFormat = "%-50s" + "%20s" + "%20s";
		System.out.printf(answerFormat, "Question", "Your Answer","Correct Answer");
		System.out.println();
		for(int j = 0; j < partitionQuestionList.size(); j++){
			String q = partitionQuestionList.get(j);
			System.out.printf(answerFormat, q, userAnswerList.get(j), correctAnswer.indexOf(getAnswer(q)) + 1);
			System.out.println();
		}
		System.out.println();
	}

	private List<Integer> takeAnswers(Scanner input, List<String> partitionQuestionList) {
		List<Integer> userAnswerList = new ArrayList<>();
		System.out.println("*******Please type the number you think is a match*******");
		for(int j = 0; j < partitionQuestionList.size(); j++){
			System.out.print(partitionQuestionList.get(j) + ": ");
			int answer = input.nextInt();
			userAnswerList.add(answer);
		}
		return userAnswerList;
	}

	private void printMatching(List<String> partitionQuestionList, List<String> shuffleAnswerList) {
    	String matchFormat = "%-50s" + "%-20s";
    	System.out.printf(matchFormat, "From", "To");
    	System.out.println();

		for(int j = 0; j < partitionQuestionList.size(); j++){
			String question = partitionQuestionList.get(j);
			System.out.printf(matchFormat, question,  (j + 1) + ": " + shuffleAnswerList.get(j));
			System.out.println();
		}
	}

	private List<String> getAnswerList(List<String> questionList){
    	List<String> answerList = new ArrayList<>();
    	for(String q : questionList){
    		answerList.add(getAnswer(q));
		}
    	return answerList;
	 }


}

