package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 

public class Match extends StudyMode{
    public Match(File f) throws FileNotFoundException {
    	super(f);
    }
    
    public void beginExerciseMatch() {
    	System.out.println("Welcome to the Match section! In this section, you will be given a list of");
		System.out.println("definitions and a list of word. Try to match them correctly!");
		System.out.println();
    	
    	Set<String> questionSet = exercise.keySet();
    	Scanner input = new Scanner(System.in);
    		for(String question: questionSet) {
    			
    		}
    		input.close();
     }
    
}
