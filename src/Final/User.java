package Final;

/**
 * 
 * @author Yinghan Lin
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
}
