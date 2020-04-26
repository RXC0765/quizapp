package Final;

import java.util.*;


public class User {
    private String name;
    private int score;
    private ArrayList<String> CollectionOfMistakes;
    
    public User(String name) {
    	this.name = name;
    	this.score = 0;
    	this.CollectionOfMistakes = new ArrayList<String>();
    }
    
    public void ChangeScore(int score) {
    	this.score = score;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getScore() {
    	return score;
    }
    
    public void printUser() {
    	System.out.println("User name: "+ name+" Score: "+score);
    }
}
