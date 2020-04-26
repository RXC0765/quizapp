package Final;
import java.util.*; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuestionBank {
	File fTest;      //file
	FileReader frInput;   //file reader
	BufferedReader brInput;   //buffered reader
	String correctAnswer;
	int score=0;
	
	public void openTestFile(File f) throws IOException{
		fTest=f;
		try {			
			frInput=new FileReader(fTest);   //create a file reader
			brInput=new BufferedReader(frInput);   //improve reading efficiency
			readOneQuestion();   //read one question
		} catch (FileNotFoundException e1) {//throw exceptions
			System.out.println("file");
			e1.printStackTrace();
		}  catch (Exception e) {
			System.out.println("question not found");
		}
		
	}
	
	//read one question
	//in the file, answers start with '-'
	public void readOneQuestion() {
		try {
			String s=null;    //read a string from txt
			while((s=brInput.readLine())!=null) {   
				if(!s.startsWith("-")) {   //if it's a question
					System.out.println(s);    //print the question
				}	
				else {    //start with '-', is an answer
					s=s.replace("-","");   //pick out the answer
					correctAnswer = s;    //update the right answer
					break;
				}
			}
			if(s==null) {   
				brInput.close();   //close buffered reader
				System.out.println("game ended");
				System.out.println("Your score:"+score);
			}
			getanswer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getanswer() {    //get the player's input
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		boolean bOne=str.compareToIgnoreCase(correctAnswer)==0;  
		//case is ignored, and when player's answer equals to the correct answer returns 0
		if(bOne) {        //if player input the correct answer
			score++;
			readOneQuestion();   //raise a new question
		}else {
			readOneQuestion(); 
		}
	}			
	
}
