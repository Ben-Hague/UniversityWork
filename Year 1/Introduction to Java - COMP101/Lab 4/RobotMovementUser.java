/**************************************************************\
  This is the Robot Movement User Class
  It creates a robot, new  an  instance of the RobotMovement 
  class then asks you to input Speed, Time and Angle, applies
  them to the newRobot and then Calculates the  Position, 
  Distance Travelled and Battery Use of the Robot
\**************************************************************/

import java.util.Scanner;								//import the Scanner class from java

public class RobotMovementUser{

	public static void main(String[] args){				// Method to be run by java when executing the class
		
		RobotMovement newRobot = new RobotMovement();	// Create a new object "newRobot" of Type RobotMovement
		Scanner input = new Scanner(System.in);			// Create a new object "input" of Type Scanner
		
		System.out.print("Input the angle, measured clockwise from the vertical a real number between 0-90: ");
		newRobot.setAngle(input.nextInt()); 			//Ask the user to input a value for angle between 0-90 and give the number to setAngle method of newRobot 
		
		System.out.print("Input the speed, as a real number between 1.0 - 5.0: ");
		newRobot.setSpeed(input.nextFloat());			//Ask the user to input a value for speed between 1.0 and 5.0 and give the number to setSpeed method of newRobot 
		
		System.out.print("Input the time travelled as a positive or zero real number: ");
		newRobot.setTime(input.nextFloat());				//Ask the user to input a value positive or zero real number and give the number to setTime method of newRobot 
		
		
		System.out.printf("A robot moving with angle %-1d at a speed of %.1f for %.1f seconds has: \n", newRobot.Angle, newRobot.Speed, newRobot.Time);
		// Print a summary of input data to the console with angle as an int, speed at 1dp and time as an int 
		System.out.printf("the distance travelled: %.1f \n" , newRobot.getDistance());
		// Print the distance traveled to the console to one decimal place 
		System.out.printf("horizontal movement: %.2f \n" , newRobot.getHorizontalPos());
		// Print the Horizontal movement to the console to two decimal places
		System.out.printf("vertical movement: %.2f \n" , newRobot.getVerticalPos());
		// Print the Vertical movement to the console to two decimal places
		System.out.printf("the estimated battery usage (in idle-battery seconds): %.2f \n " , newRobot.getBatteryEstimate());
		// Print the Estimated Battery Usage to the console to two decimal places
	}
	
}
