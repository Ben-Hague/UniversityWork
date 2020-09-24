import java.util.Scanner;
public class LatePenaltiesUser {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); //create new  object of type Scanner called input 
		MarkCalculator Test = new MarkCalculator(); //create new  object of type MarkCalculator called Test
		MarkCalculator.schemeOne schemeOne = Test.new schemeOne(); //create new  object of type markCalculator.schemeOne called schemeOne
		MarkCalculator.schemeTwo schemeTwo = Test.new schemeTwo(); //create new  object of type markCalculator.schemeTwo called schemeTwo
		// ask user for inputs for mark and number of days 
		System.out.printf("Please Enter the mark: ");
		Test.setMark(Test.inputBetween(0,100));
		System.out.printf("Please Enter the number of days: ");
		Test.setDays(input.nextInt());
		// output the scheme name then the marks then the number of days till failure for each scheme 
		System.out.printf("\n\n SCHEME ONE \n\n");
		schemeOne.printMarks(schemeOne.getMarks());
		printDays(schemeOne.getDays());
		System.out.printf("\n\n SCHEME TWO \n\n");
		schemeTwo.printMarks(schemeTwo.getMarks());
		printDays(schemeTwo.getDays());
	}
	public static void printDays(int days){ // works out if to tell the person they have failed or 
		if (days>=0){
			System.out.printf("\nThis work can be up to %-1d days late before failing", days);
		}
		else {
			System.out.printf("\nThis work has failed before submission");
		}
	}
}