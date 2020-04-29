package Final;
/**
import java.io.*
import java.util.Scanner;
*/
/**
 * 
 * @author Yinghan Lin Irene Li
 * This class represents a user and records his/her name and score.
 */

public class User {
    private String name;
    private int score;
    
    public User(String name) { //constructor
    	this.name = name;
    	this.score = 0;
    }
    
    public void ChangeScore(int score) { //change the user's score
    	this.score = score;
    }
    
    public String getName() { //getter method
    	return name;
    }
    
    public int getScore() { //getter method
    	return score;
    }
    
    public String toString() { //toString method
    	return "User name: "+ name+"       Score: "+score; 
    }
    
    /** a method to add question to existing question bank
    public void addQuestion() throws IOException {
		System.out.println("Enter your question:");
		Scanner in = new Scanner(System.in);
		String question = in.nextLine();
		FileWriter fileWriter = new FileWriter("Test2.txt", true); //Set true for append mode
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(question);  //New line
	    printWriter.close();
	    System.out.println("Enter the answer:");
		String answer = in.nextLine();
	    printWriter.println(answer);  //New line
	    printWriter.close();
	}
    */
}
