package Final;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
*@author Shiyi(Wendy) Mao
*/
public class Answer {
	ArrayList<User> users;
	
	public Answer() { //constructor
		users = new ArrayList<User>();
	}
	
	public void PrintResult() { //print the list of users
		for(int i=0; i<users.size();i++) {
			System.out.println(users.get(i).toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Quiz App!");
		System.out.println("You bring the brains, we'll bring everything else!");
		
		Scanner input = new Scanner(System.in);
		Answer answer = new Answer();
		String start = "";
		int newplayer=1;
		
        while(true) {
		    System.out.println("Do you want to start you vocabulary learning journey? (Y/N)");
		    start = input.nextLine();
		    
		    if(start.compareToIgnoreCase("Y")==0) {
		    	while(start.compareToIgnoreCase("Y")==0) {
			    	System.out.println("Please enter your name:");
			    	String name = input.nextLine();
			        
			        User user = new User(name); //create a user class which includes name and score
			        answer.users.add(user); //add the user to the array list
			        
			        System.out.println("Hello "+name+" ! Let's get started!");
			        System.out.println("Before the quiz, let's spend some time going over these words!");


					CanPlay play = null; // the CanPlay instance to run the game
					while(true) { //like some vocabulary trainer apps, the user should go over the words before the test
			            System.out.println("Please choose your study mode: Spell(0) or Match(1)");
			            int mode = input.nextInt(); //we designed two study modes
			            if(mode==0) {
			            	play = new Spell(new File("StudyMode.txt")); //the first one is spell
			        	    break;
			            }else if(mode==1) {
			            	play = new Match(new File("Match.txt")); //the second one is match
							break;
			            }else {
			        	    System.out.println("Please enter 0 or 1.");
			        	    continue;
			            }
			        }
					play.beginExercise();
			        
			        
			        System.out.println("Now let's take a quiz and see how much you have learnt!");
			        QuestionBank qb=new QuestionBank();
			        qb.openTestFile(new File("test.txt"));   //open the file 
			        user.ChangeScore(qb.score); 
			        
			        System.out.println("Is there another player? (1/0)"); //multiple users can use this app
			        newplayer = input.nextInt();
			        input.nextLine();
			        
			        if(newplayer==0) {
			        	System.out.println("Do you want to see everyone's results? (Y/N)");
			        	String see = input.nextLine();
			        	if(see.compareToIgnoreCase("Y")==0) {
			        		answer.PrintResult(); //use the print result method to print every user's score
			        		break;
			        	}else {
			        		System.out.println("Bye");
			        	    break;
			        	}
			        }
		    	}
		    	break;
		    }else if(start.compareToIgnoreCase("N")==0) {
		    	System.out.println("Bye!");
		    	break;
		    }else {
		    	System.out.println("Please enter Y or N");
		    }
		}			
	}
}

