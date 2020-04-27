package Final;

public class User {
    private String name;
    private int score;
    
    public User(String name) {
    	this.name = name;
    	this.score = 0;
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
    
    public String toString() {
    	return "User name: "+ name+"       Score: "+score; 
    }
}
