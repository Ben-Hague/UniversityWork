import java.util.Scanner;
public class LatePenaltiesUserExt {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); //create new  object of type Scanner called input 
		MarkCalculator Test = new MarkCalculator(); //create new  object of type MarkCalculator called Test
		MarkCalculator.schemeOne schemeOne = Test.new schemeOne(); //create new  object of type markCalculator.schemeOne called schemeOne
		MarkCalculator.schemeTwo schemeTwo = Test.new schemeTwo(); //create new  object of type markCalculator.schemeTwo called schemeTwo
		// ask user for inputs for scheme mark and number of day
		System.out.printf("Would you like to use scheme one (1) or scheme two  (2) :");
		int scheme  = input.nextInt();
		System.out.printf("Please Enter the mark: ");
		Test.setMark(Test.inputBetween(0,100));
		System.out.printf("Please Enter the number of days: ");
		Test.setDays(input.nextInt());
		System.out.printf("Please Enter the marks needed to pass: ");
		Test.setPassMark(Test.inputBetween(0,100));
		// ask the user specific settings for each scheme and print the result
		if (scheme == 1){
			System.out.printf("What is the lower limit of marks: ");
			schemeOne.setLowerLimit(Test.inputBetween(0,100));
			System.out.printf("What is the number of marks lost per day: ");
			schemeOne.setMarksLostPerDay(Test.inputBetween(0,100));
			System.out.printf("\n\n SCHEME ONE \n\n");
			schemeOne.printMarks(schemeOne.getMarks());
			printDays(schemeOne.getDays());
		}
		else if (scheme == 2){
			System.out.printf("What is the lower limit of marks: ");
			schemeTwo.setLowerLimit(Test.inputBetween(0,100));
			System.out.printf("What is the percentage of marks lost per day: ");
			schemeTwo.setPercentageLostPerDay(Test.inputBetween(0,100));
			System.out.printf("\n\n SCHEME TWO \n\n");
			schemeTwo.printMarks(schemeTwo.getMarks());
			printDays(schemeTwo.getDays());
		}
		else {System.out.printf("please ensure you entered a valid scheme and restart the program");}// print an option in case the user doesnt submit a valid option
		
		
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