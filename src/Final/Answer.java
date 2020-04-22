package Final;

import java.io.File;

public class Answer {
	public static void main(String[] args) {
		QuestionBank qb=new QuestionBank();
		qb.openTestFile(new File("test.txt"));   //open the file
	}
}
