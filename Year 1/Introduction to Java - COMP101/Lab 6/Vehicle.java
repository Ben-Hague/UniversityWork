/**********************************\
Vehicle Class asks questions and 
identifys the vehicle.
\**********************************/
import java.util.Scanner ;

public class Vehicle
{
	private int wheels ;
	private double length ; 
	private int axles ; 
	private double weight ; 
	public int vehicleClass ;  
	Scanner input = new Scanner(System.in) ;	// declaring private variables and vehicle class public

	private int getIntInput(int minValue){ // short section to get an int input but deny values lower than the given minValue
		int Value = -1 ;
		while (Value < minValue){
			
			Value = input.nextInt();
			if (Value < minValue){
				System.out.printf("The number must be greater than or equal to to %-1d \nPlease enter a different number: ", minValue );
			}
			else{
				break;
			}
		}
		return Value;
	}
	private double getDoubleInput(int minValue){ // short section to get an double input but deny values lower than the given minValue
		double Value = minValue-1 ; 
		while (Value < minValue){
			Value = input.nextDouble();
			
			if (Value < minValue){
				System.out.printf("The number must be greater than or equal to%.2f \nPlease enter a different number: ", minValue);
			}
			else{ 
				break;
			}
		}
		return Value;
	}
	// the following sections obtain data from the user about attributes of the vehicle 
	private void inputWheels(){
		System.out.print("Please enter the number of wheels: ");
		wheels = getIntInput(2);

	}
	private void inputLength(){
		System.out.print("  Please enter the Vehicle Length: ");
		length = getDoubleInput(0);
		
	}
	private void inputAxles(){
		System.out.print(" Please enter the Number of axles: ");
		axles = getIntInput(2);
	}
	private void inputWeight(){
		System.out.print("  Please enter the Vehicle Weight: ");
		weight = getDoubleInput(0);
	}
	
	// this section asks sucsessive questions and once gathered enough data returns the vehicleClass
	public int identify(){
		inputWheels();
		if (wheels < 4){
			return 1;
		}
		inputLength();
		if (wheels == 4  && length <= 15){
			return 2;
		}
		inputAxles();
		if (wheels == 4 && axles == 2){
			return 4;
		}
		inputWeight();
		if (weight <= 2){
			return 3;
		}
		if (weight > 2 && weight <=3.5){
			return 5;
		}
		if (weight > 3.5){
			return 6;
		}
		return 0;
	}
	// this sets the variable Vehicle Class
	public void setClass(int vehicleClass){
		this.vehicleClass = vehicleClass;
	}
	// this identifies in string form for outout the vehicle type and the class from the objects vehicleClass
	public void identifyClass(){
		switch (vehicleClass) {
			case 0 : 
				return;
			case 1 : 
				System.out.printf(" Motorbike (Class 1) ");
				break;
			case 2 : 
				System.out.printf(" Car (Class 2) ");
				break;
			case 3 : 
				System.out.printf(" Car with Trailer (Class 3) ");
				break;
			case 4 : 
				System.out.printf(" Van (Class 4) ");
				break;
			case 5 : 
				System.out.printf(" Small lorry/bus (Class 5) ");
				break;
			case 6 : 
				System.out.printf(" Large Lorry (Class 6) ");
				break;
		}
	}

}