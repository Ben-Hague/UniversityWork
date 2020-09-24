/**************************************************************\
  This is the Robot Movement User Class
  It creates a robot, new  an  instance of the RobotMovement 
  class then asks you to input Speed, Time and Angle, applies
  them to the newRobot and then uses the Calculates the 
  Position, Distance Travelled and Battery  Use of the Robot
\**************************************************************/
import java.util.Scanner;								//import the Scanner class from java

public class RobotMovementUserExt{
	public static float TotalHorizontal = 0;
	public static float TotalVertical = 0;
	public static float TotalDistance = 0;				
	public static double TotalBatteryUse = 0;			// Declare TotalBatteryUse, TotalHorizontal, TotalVertical and TotalDistance as variables with the starting value of 0
	
	public static void journeyData(RobotMovement journey, int journeyNumber){   // short method to collect data for each journey the robot makes from the user takes  a Object of type RobotMovement and an Object of Type Integer
		Scanner input = new Scanner(System.in);			// Create a new object "input" of Type Scanner
		
		System.out.printf("Input the angle, measured clockwise from the vertical a real number between 0-90 for journey %-1d : ",  journeyNumber);
		journey.setAngle(input.nextInt());				// Print instruction of to enter angle between 0 and 90 for journeyNumber (integer declared at beginning of method) give result to setAngle of journey declared at beginning of method
		System.out.printf("Input the speed, as a real number between 1.0 - 5.0 for journey %-1d : ",  journeyNumber);
		journey.setSpeed(input.nextFloat());			// Print instruction of to enter Speed between 1.0 and 5.0 for journeyNumber (integer declared at beginning of method) give result to setSpeed of journey declared at beginning of method
		System.out.printf("Input the time travelled a positive or zero real number for journey %-1d : ",  journeyNumber);
		journey.setTime(input.nextFloat());				// Print instruction of to enter Time positive or zero real number for journeyNumber (integer declared at beginning of method) give result to setTime of journey declared at beginning of method
		
		TotalVertical +=  journey.getVerticalPos();
		TotalHorizontal += journey.getHorizontalPos();
		TotalDistance += journey.getDistance();
		TotalBatteryUse += journey.getBatteryEstimate();// add the vertical movement, horizontal movement distance and battery estimate to the Totals declared at the top of the program
	}
	
	public static void printStats(RobotMovement journey){// short method to print a summary for the given journey input data, takes 1 object of type RobotMovement
		System.out.printf("The Robot travels with angle %-1d at a speed of %.1f for %.1f seconds then, ", journey.Angle, journey.Speed, journey.Time); // 
	}
	
	public static void printTotals(){					// short method to print the totals from all journeys undertaken takes no arguments 
		System.out.printf("the distance travelled will be: %.1f \n" , TotalDistance);	// Print the TotalDistance traveled to the console to one decimal place 
		System.out.printf("horizontal movement will be: %.2f \n" , TotalHorizontal);	// Print the TotalHorizontal traveled to the console to two decimal places
		System.out.printf("vertical movement will be: %.2f \n" , TotalVertical);		// Print the TotalVertical traveled to the console to two decimal places
		System.out.printf("the estimated battery usage (in idle-battery seconds) will be: %.2f \n", TotalBatteryUse);	// Print the TotalBatteryUse to the console to two decimal places
	}
	  
	public static void main(String[] args){
		RobotMovement journey1 = new RobotMovement();	// Create a new object "journey1" of Type RobotMovement
		RobotMovement journey2 = new RobotMovement();	// Create a new object "journey2" of Type RobotMovement
		RobotMovement journey3 = new RobotMovement();	// Create a new object "journey3" of Type RobotMovement
		
		journeyData(journey1, 1);						// Method journeyData is given the object journey1 and the integer 1, this gets the data from the user
		journeyData(journey2, 2);						// Method journeyData is given the object journey2 and the integer 2, this gets the data from the user 
		journeyData(journey3, 3);						// Method journeyData is given the object journey3 and the integer 3, this gets the data from the user
		
		printStats(journey1);							// Method printStats is given the object journey1, this prints the summary for this leg
		printStats(journey2);							// Method printStats is given the object journey2, this prints the summary for this leg
		printStats(journey3);							// Method printStats is given the object journey3, this prints the summary for this leg
		
		printTotals();									// Method printTotals prints the totals for distance, vertical movement, horizontal movement and estimated battery use
	
	}
	
}
