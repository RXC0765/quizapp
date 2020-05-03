package Final;

/**import java.io.*
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
    /**StringBuffer stringBufferOfData = new StringBuffer();
    String fname = null;
    Scanner sc = new Scanner(System.in);
    */
	
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
    
    public void addQuestion(String file) throws IOException {
		System.out.println("Enter your question:");
		Scanner in = new Scanner(System.in);
		String question = in.nextLine();
		FileWriter fileWriter = new FileWriter(file + ".txt", true); //Set true for append mode
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(question);  //New line
	    printWriter.close();
	    System.out.println("Enter the answer:");
		String answer = in.nextLine();
	    printWriter.println(answer);  //New line
	    printWriter.close();
	}
     /**a method to create a new test file 
     
     public void creatFile() throws IOException{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired name of your test file: ");
        String fileName = input.nextLine();

        File file = new File(fileName + ".txt");
        if (file.createNewFile()) {
            System.out.println("File created.");
        } else {
            System.out.println("File already exists.");
        }
        addQuestion(fileName);
	}
    public void edit() {
		boolean fileRead = readFile();//call the method to read the file with the files name
        if (fileRead) {//if the read file was successfull
            replacement();//call method to get text to replace, replacement text and output replaced String buffer
        }

	}
	public boolean readFile() {
        System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
        fname = sc.nextLine();//read in the file name
        Scanner fileToRead = null;
        try {
            fileToRead = new Scanner(new File(fname)); //point the scanner method to a file
            //check if there is a next line and it is not null and then read it in
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                System.out.println(line);//print each line as its read
                stringBufferOfData.append(line).append("\r\n");//this small line here is to appened all text read in from the file to a string buffer which will be used to edit the contents of the file
            }
            fileToRead.close();//this is used to release the scanner from file
            return true;
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + fname + " could not be found! " + ex.getMessage());
            return false;
        } finally {//if an error occurs now we close the file to exit gracefully
            fileToRead.close();
            return true;
        }
	}
	public void replacement() {
        System.out.println("Please enter the contents of a line you would like to edit: ");//prompt for a line in file to edit
        String lineToEdit = sc.nextLine();//read the line to edit
        System.out.println("Please enter the the replacement text: ");//prompt for a line in file to replace
        String replacementText = sc.nextLine();//read the line to replace
        
        int startIndex = stringBufferOfData.indexOf(lineToEdit);//now we get the starting point of the text we want to edit
        int endIndex = startIndex + lineToEdit.length();//now we add the staring index of the text with text length to get the end index
        stringBufferOfData.replace(startIndex, endIndex, replacementText);//this is where the actual replacement of the text happens
        System.out.println("Here is the new edited text:\n" + stringBufferOfData); //used to debug and check the string was replaced
    }
    */
}
