/**********************************\
Vehicle Class asks questions and 
identifys the vehicle.
\**********************************/

public class TunnelTollCharge{
	public boolean isWeekend ;
	public double getCharge(int vehicleClass){
		double multiplier = 1 ;
		if (isWeekend){
			multiplier = 0.75 ; // change the multipler to make the cost to go throught the tunnel 0.75 of the ammount it costs on weekdays
		} 
		switch (vehicleClass) {  // vehicle class input to swich case and a cost returned.
		case 1 :
				return 2.00*multiplier ;
			case 2 : 
				return 3.20*multiplier ;
			case 3 : 
				return 3.80*multiplier ;
			case 4 : 
				return 4.40*multiplier ;
			case 5 : 
				return 8.00*multiplier ;
			case 6 : 
				return 12.00*multiplier ;
		}
		return 0;
	}
	public double getMonthlyPass(int vehicleClass){	// input vehicle class and return the cost for a monthly pass
		switch (vehicleClass) {
			case 1  :
				return 70.00 ;
			case 2 : 
			case 3 :
			case 4 :
				return 130.00;
			case 5 :
			case 6 :
				return 350.00;
		}
		return 0;
	}
	public double  getMonthlyCost(int vehicleClass, int weekendJourneys, int weekdayJourneys){ // calculates the monthly cost without the ticket
		return (weekendJourneys*0.75 + weekdayJourneys)*getCharge(vehicleClass);
	}
}