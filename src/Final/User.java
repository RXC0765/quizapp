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
    
    
}
