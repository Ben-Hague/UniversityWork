import java.util.Scanner; // import scanner for user input
/* Hello World Code */
public class MarkCalculator {
    public static void main(String[] args){
	Scanner UserInput = new Scanner(System.in);
        System.out.println("Please enter Coursework Score");
        // Ask the user to enter their score
        Integer Coursework = UserInput.nextInt();
		System.out.println("Please enter Exam Score");
        // Ask the user to enter their score
        Integer Exam = UserInput.nextInt();
        // print score to the console
        System.out.println("Your combined score is: " + String.valueOf(((Coursework*25)+(Exam*75))/100));
    }
}