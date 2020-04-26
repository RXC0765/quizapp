package Final;

import java.io.File;
import java.util.*;

public class Answer {
	ArrayList<User> users;
	
	public Answer() {
		users = new ArrayList<User>();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Quiz App!");
		System.out.println("You bring the brains, we'll bring everything else!");
		String name = SignUp();
		System.out.println("Hello "+name+" !");
		QuestionBank qb=new QuestionBank();
		qb.openTestFile(new File("test2.txt"));   //open the file
	}
	
	public static String SignUp() {
		System.out.println("Please enter your name:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();  
		return name;
	}
	
	
}
