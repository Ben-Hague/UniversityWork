/**********************************\

\**********************************/
import java.util.Scanner;
public class MarkCalculator{
	
	// declare variables
	public int mark;
	public int days;
	public int passMark = 40;
	
	// functions to set variables 
	public void setDays(int x){
		days = x; // set days as the integer input to this function
	}
	public void setMark(int x){
		mark = x; // set mark as the integer input to this function
	}
	public void setPassMark(int x){
		passMark = x; // set passMark as the integer input to this function
	}
	
	// Custom input Function for verifying input between 2 values
	public int inputBetween(int min, int max){
		int Value = (min-1); // set the integer value to less than the minimum
		Scanner input = new Scanner(System.in); // create new object called inoput of type scanner for system input 
		while (Value <min || Value >max){ // if the value is not between the limits loop
			Value = input.nextInt(); // get a user input to replace the value of Value 
			if (Value <min || Value >max){ // if the vale is not in the limits ask for another imput else break the loop
				System.out.printf("The mark must be between %-1d and %-1d, enter a new value: ",min,max );
			}
			else{
				break;
			}
		}
		return Value; 
	}
	
	// Scheme one subclass, contains the fucnctions and variables only needed for scheme one 
	public class schemeOne{
		// scheme one variables
		private int lowerLimit = 20;
		private int marksLostPerDay = 5;
		// functions to set scheme one variables 
		public void setLowerLimit(int x){
			lowerLimit = x; // set lowerLimit as the integer input to this function
		}
		public void setMarksLostPerDay(int x){
			marksLostPerDay = x; // set marksLostPerDay as the integer input to this function
		}
		// functions for scheme one 
		public int[] getMarks(){ // function to return an array of the marks each day
			int currentMark = mark;
			int[] markList = new int[days+1];
			for (int day = 0; day <= days; day++){ // for each day work out the mark and add it to the array markList
				markList[day] = currentMark;
				currentMark -= marksLostPerDay;
				if (currentMark < lowerLimit && mark>=lowerLimit){
					currentMark = lowerLimit;
				}
				else if (mark<lowerLimit){
					currentMark = mark;
				}
			}
			return markList; // return the marklist
		}
		public int getDays(){ // fuction to calculate the number of days till failure 
			return (mark-passMark)/marksLostPerDay;
		}
		public void printMarks(int[] markList){ // function to output the marks in a readable way
			System.out.printf(" Day | Mark \n");
			for (int day = 0; day <= markList.length-1; day++){
					System.out.printf("%4d | %-5d \n", day, markList[day]);
			}
		}

		
	}
	
	// Scheme two subclass, contains the fucnctions and variables only needed for scheme two
	public class schemeTwo{
		// scheme two variables
		private int lowerLimit = 25;
		private int percentageLostPerDay =  10;
		//functions to set scheme two variables 
		public void setLowerLimit(int x){
			lowerLimit = x; // set lowerLimit as the integer input to this function
		}
		public void setPercentageLostPerDay(int x){
			percentageLostPerDay = x; // set lowerLimit as the integer input to this function
		}
		// functions specific to scheme two
		public double[] getMarks(){ // function to return an array of the marks each day
			double currentMark = mark;
			double[] markList = new double[days+1];
			for (int day = 0; day <= days; day++){ // for each day work out the mark and add it to the array markList
				if (currentMark< lowerLimit && mark>lowerLimit){
					currentMark = lowerLimit;
				}
				else if (mark<lowerLimit){
					currentMark = mark;
				}
				markList[day] = currentMark;
				currentMark = currentMark*(100-percentageLostPerDay)/100;
			}
			return markList; // return the marklist
		}
		public int getDays(){ // fuction to calculate the number of days till failure 
			if (mark == passMark){
					return 0 ;
			}
			double marksRemaining = mark;
			int day =-1;
			
			while (marksRemaining > passMark){ // while loop repeats each day untill the mark is below the passMark
				marksRemaining = marksRemaining*(100-percentageLostPerDay)/100;
				day ++;
				
			}
			return (day);
		}
		public void printMarks(double[] markList){// function to output the marks in a readable way
			System.out.printf(" Day | Mark \n");
			for (int day = 0; day <= markList.length-1; day++){ // for item in marklist
					System.out.printf("%4d | %.2f \n", day, markList[day]);
			}
		}

	}
}