package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 
/**
*@author Shiyi(Wendy) Mao
*/
public class Match extends AbstractStudyMode implements CanPlay {
	// The number of question per run.
	static int NUM_PER_RUN = 5;
    public Match(File f) throws FileNotFoundException { //constructor 
    	super(f);
    	
    	// load question and answer from file.
    	loadFromFile();
    }

    /**
     * Process the question format
     */
	@Override
	protected String processQuestion(String question) {
		return question;
	}

	/** Process the format of answers
	 * 
	 */
	@Override
	protected String processAnswer(String answer) {
		answer = answer.replace("-","");
		return answer.trim();
	}

	/**
	 * Begin the study mode routine
	 */
	public void beginExercise() {
    	System.out.println("Welcome to the Match section! In this section, you will be given a list of");
		System.out.println("definitions and a list of word. Try to match them correctly!");
		System.out.println();
    	
		// Get all questions in set
    	Set<String> questionSet = getQuestions();
    	Scanner input = new Scanner(System.in);

    	// Get all questions in list
    	List<String> questionList = new ArrayList<>(questionSet);
    	Collections.shuffle(questionList);

    	// Loop through the whole question list
    	int i = 0;
    	while(i < questionList.size()){
    		// print run information
    		System.out.println((i / NUM_PER_RUN + 1) + "th " + "Question:");
    		int end = Math.min(i + NUM_PER_RUN, questionList.size());
    		
    		// slice the whole question list into different part
    		List<String> partitionQuestionList = questionList.subList(i, end);

    		// get the corresponding answer list
    		List<String> correctAnswerList = getAnswerList(partitionQuestionList);
    		
    		// shuffle the whole answer list
    	    Collections.shuffle(correctAnswerList);

			printMatching(partitionQuestionList, correctAnswerList);
			// take answer
			List<Integer> userAnswerList = takeAnswers(input, partitionQuestionList);
			// print result
			printResult(partitionQuestionList, correctAnswerList, userAnswerList);
			i += NUM_PER_RUN;
		}
     }

	/**
	 * This method print the result of a run
	 * @param partitionQuestionList the questions in a run
	 * @param correctAnswer the correct answers for the questions in the run
	 * @param userAnswerList the answers list the user type in
	 */
	private void printResult(List<String> partitionQuestionList, List<String> correctAnswer, List<Integer> userAnswerList) {
		// the answer template
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

	/**
	 * The method take input from users.
	 * @param input the input 
	 * @param partitionQuestionList the questions in a run
	 * @return the Answers that user type in in list of int
	 */
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

	/**
	 * print the matching question and answers in a run
	 * @param partitionQuestionList the questions in a run
	 * @param shuffleAnswerList the answers for the questions
	 */
	private void printMatching(List<String> partitionQuestionList, List<String> shuffleAnswerList) {
    	String matchFormat = "%-50s" + "%-20s";
    	System.out.printf(matchFormat, "From", "To");
    	System.out.println();

    	// print the question : random answer
		for(int j = 0; j < partitionQuestionList.size(); j++){
			String question = partitionQuestionList.get(j);
			System.out.printf(matchFormat, question,  (j + 1) + ": " + shuffleAnswerList.get(j));
			System.out.println();
		}
	}

	/**
	 * get the answer list from questions
	 * @param questionList
	 * @return a list of the answer from the questions
	 */
	private List<String> getAnswerList(List<String> questionList){
    	List<String> answerList = new ArrayList<>();
    	for(String q : questionList){
    		answerList.add(getAnswer(q));
		}
    	return answerList;
	 }


}


