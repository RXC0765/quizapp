package Final;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Answer {
	ArrayList<User> users;
	
	public Answer() {
		users = new ArrayList<User>();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Quiz App!");
		System.out.println("You bring the brains, we'll bring everything else!");
		
		String start = "";
		int newplayer=1;
		while(true) {
		    System.out.println("Do you want to start you vocabulary learning journey? (Y/N)");
		    Scanner input = new Scanner(System.in);
		    start = input.nextLine();
		    
		    if(start.compareToIgnoreCase("Y")==0) {
		    	while(start.compareToIgnoreCase("Y")==0) {
			    	System.out.println("Please enter your name:");
			    	String name = input.nextLine();
			        
			        User user = new User(name);
			        Answer answer = new Answer();
			        answer.users.add(user); 
			        
			        System.out.println("Hello "+name+" ! Let's get started");
			        QuestionBank qb=new QuestionBank();
			        qb.openTestFile(new File("test.txt"));   //open the file
			        user.ChangeScore(qb.score); 
			        
			        System.out.println("Is there another player? (1/0)");
			        newplayer=Integer.parseInt(input.nextLine());
		    	}		        
		    }else if(start.compareToIgnoreCase("N")==0) {
		    	System.out.println("Bye!");
		    	break;
		    }else {
		    	System.out.println("Please enter Y or N");
		    }
		}			
	}	
}
