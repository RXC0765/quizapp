package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Yinghan Lin, Shiyi(Wendy) Mao
 * This is a subclass of StudyMode.class
 */
public class Spell extends AbstractStudyMode implements CanPlay {
	
	public Spell(File f) throws FileNotFoundException { //constructor 
		super(f);
		loadFromFile();
	}

	@Override
	protected String processQuestion(String question) {
		return question;
	}

	@Override
	protected String processAnswer(String answer) {
		answer = answer.replace("-","");//pick out the answer
		answer = answer.trim();
		return answer;

	}

	@Override
	public void beginExercise() {
		System.out.println("Welcome to the Spell section! In this section, you will have to spell");
		System.out.println("the correct word according to the definitions given.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		Set<String> questionSet = getQuestions(); //get all the key values: questions
		for(String question: questionSet) {
			System.out.println(question);
			System.out.println("Please type your answer:");
			String a = input.nextLine();
			//if the answer is wrong, show the right answer
			if(verifyAnswer(question, a)) { //check if the answer is correct
                System.out.println("Correct!");
			}else{
				System.out.println("Wrong! The answer is "+getAnswer(question));
			}
			System.out.println();
		}
	}

	@Override
	public boolean verifyAnswer(String question, String answer) {
	    answer = answer.toLowerCase();
	    return super.verifyAnswer(question, answer);
	}
}
