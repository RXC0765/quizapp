package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class StudyMode {
    Map<String, String> exercise;
    
    public StudyMode(File f) throws FileNotFoundException {
    	exercise = new HashMap<String, String>();
    	Scanner input = new Scanner(f);
    	String question = "";
    	String trueAnswer = "";
    	while(input.hasNextLine()) {
    		String line = input.nextLine();
    		if(!line.startsWith("-")) {   //if it's a question
				question = line;    
			}	
			else {    
				line = line.replace("-","");//pick out the answer
				trueAnswer = line.trim();    //update the right answer
			}
   		    exercise.put(question, trueAnswer);
    	}
    	input.close();
    }
    
     
}
