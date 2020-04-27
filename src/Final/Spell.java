package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Spell extends StudyMode {
	
	public Spell(File f) throws FileNotFoundException {
		super(f); 
	}
    
	public void beginExerciseSpell() {
		System.out.println("Welcome to the Spell section! In this section, you will have to spell");
		System.out.println("the correct word according to the definitions given.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		Set<String> questionSet = exercise.keySet();
		for(String question: questionSet) {
			System.out.println(question);
			System.out.println("Please type your answer:");
			String a = input.nextLine();
			if(a.toLowerCase().equals(exercise.get(question))) {
                System.out.println("Correct!");
                System.out.println();
			}else{
				System.out.println("Wrong! The answer is "+exercise.get(question)); 
				System.out.println();
			}
		}
		input.close();
	}
	
}
