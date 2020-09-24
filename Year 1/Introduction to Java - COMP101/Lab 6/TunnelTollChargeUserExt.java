/**************************************************************\
TunnelTollChargeUser Class uses the TunnelTollCharge class and 
Vehicle Class to identify the vehhicle and return the cost to 
go through the tunnel
\**************************************************************/

import java.util.Scanner;		// import scanner for user input

public class TunnelTollChargeUserExt
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in) ; // new object of type Scanner called input
		Vehicle newVehicle = new Vehicle();		//new object of type Vehicle called newVehicle
		TunnelTollCharge Cost = new TunnelTollCharge();	//new object of type TunnelTollCharge called Cost
		newVehicle.setClass(newVehicle.identify()); // set the class as what is identified as the class by the vehicle class
		System.out.printf("Input true if travelling on a weekend (sat/sun) and false otherwise:"); 
		Cost.isWeekend = input.nextBoolean();
		System.out.printf("How many weekend journys do you take per month through the tunnel"); 
		int weekendJourneys = input.nextInt();
		System.out.printf("How many weekday journys do you take per month through the tunnel"); 
		int weekdayJourneys = input.nextInt();
		System.out.printf("A");
		newVehicle.identifyClass();
		if (Cost.isWeekend) {
			System.out.printf("travelling on a weekend ");
		}
		else {
			System.out.printf("traveling on a weekday ");
		}
		System.out.printf("will be charged %.2f \n",Cost.getCharge(newVehicle.vehicleClass)); // print a comprehendable output for the user to understand
		if (Cost.getMonthlyCost(newVehicle.vehicleClass, weekendJourneys, weekdayJourneys)> Cost.getMonthlyPass(newVehicle.vehicleClass)){
			System.out.printf("You spend %.2f per month on trips through the tunnel where as a pass would only cost %.2f ",Cost.getMonthlyCost(newVehicle.vehicleClass, weekendJourneys, weekdayJourneys),Cost.getMonthlyPass(newVehicle.vehicleClass));
		}
		
	}

}