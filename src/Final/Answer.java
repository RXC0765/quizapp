package Final;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Answer {
	ArrayList<User> users;
	
	public Answer() {
		users = new ArrayList<User>();
	}
	
	public void PrintResult() {
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
			        
			        User user = new User(name);
			        answer.users.add(user); 
			        
			        System.out.println("Hello "+name+" ! Let's get started!");
			        System.out.println("Before the quiz, let's spend some time going over these words!");			        
			        
			        
			        while(true) {
			            System.out.println("Please choose your study mode: Spell(0) or Match(1)");
			            int mode = input.nextInt();
			            if(mode==0) {
			            	Spell spell = new Spell(new File("StudyMode.txt"));
			            	spell.beginExerciseSpell();
			        	    break;
			            }else if(mode==1) {
			            	//Match match = new Match(new File("StudyMode.txt"));
			            	//match.beginExerciseMatch();
			        	    break;
			            }else {
			        	    System.out.println("Please enter 0 or 1.");
			            }
			        }
			        
			        
			        System.out.println("Now let's take a quiz and see how much you have learnt!");
			        QuestionBank qb=new QuestionBank();
			        qb.openTestFile(new File("test.txt"));   //open the file error
			        user.ChangeScore(qb.score); 
			        
			        System.out.println("Is there another player? (1/0)");
			        newplayer = input.nextInt();
			        input.nextLine();
			        
			        if(newplayer==0) {
			        	System.out.println("Do you want to see everyone's results? (Y/N)");
			        	String see = input.nextLine();
			        	if(see.compareToIgnoreCase("Y")==0) {
			        		answer.PrintResult();
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

