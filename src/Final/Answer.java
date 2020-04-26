package Final;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Answer {
	ArrayList<User> users;
	
	public Answer() {
		this.users = new ArrayList<User>(); //Create an array list so that multiple users can take quiz.
	}
	
	public void addUser(User player) {
		users.add(player);
	}
	
	public void PrintResult() {
		for(int i=0; i< users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Quiz App!");
		System.out.println("You bring the brains, we'll bring everything else!");
		Scanner input = new Scanner(System.in);
		Answer answer = new Answer();
		String start = "";
		
		while(true) {
		    System.out.println("Do you want to start you vocabulary learning journey? (Y/N)");
		    start = input.nextLine();
		    
		    if(start.compareToIgnoreCase("Y")==0) {
		    	System.out.println("Please enter your name:");
		    	String name = input.nextLine();
		        
		        User player = new User(name); //Create a user
		        answer.addUser(player); //Add it to the array list
		        
		        System.out.println("Hello "+name+" ! Let's get started");
		        QuestionBank qb=new QuestionBank();
		        qb.openTestFile(new File("test2.txt"));   //open the file: a GRE vocabulary quiz
		        player.ChangeScore(qb.score); //Update the score in the user class
		        
		    }else if(start.compareToIgnoreCase("N")==0) {
		    	if(answer.users.size()>0) {
		    		System.out.println("In summary: ");
		    		answer.PrintResult();
		    	}
		    	System.out.println("Bye!");
		    	break;
		    	
		    }else {
		    	System.out.println("Please enter Y or N"); 
		    }	    
		}
	}
	
}
