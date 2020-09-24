import java.util.Scanner;
public class AccountUserExt{

	public static void main(String[] args){
		
		// Get inputs of the 3 user devined values from the user
		System.out.printf("Please Enter the ammount of daytime telephone minutes : ");
		int DaytimeCalls = IntInput();
		System.out.printf("Please Enter the ammount of evening and weekend telephone minutes : ");
		int EveningCalls = IntInput();
		System.out.printf("Please Enter the ammount of total Broadband Use : ");
		int BroadbandUse = IntInput();
		System.out.printf("\n\n\n");
		
		// Create object of type BronzeAccount Called Bronze
		BronzeAccount Bronze = new BronzeAccount(DaytimeCalls,EveningCalls,BroadbandUse);
		// Create object of type SilverAccount Called Silver
		SilverAccount Silver = new SilverAccount(DaytimeCalls,EveningCalls,BroadbandUse);
		// Create object of type GoldAccount Called Gold
		GoldAccount Gold = new GoldAccount(DaytimeCalls,EveningCalls,BroadbandUse);
		
		
		// Print the costs accociated with each account
		Bronze.PrintCosts();
		Silver.PrintCosts();
		Gold.PrintCosts();
		
		// Print the Profits accociated with each account 
		Bronze.PrintProfit();
		Silver.PrintProfit();
		Gold.PrintProfit();
		System.out.printf("\n\n");
		
		// Determine which account is the cheapest and tell the user
		if (Gold.TotalCost()<Silver.TotalCost() && Gold.TotalCost()<Bronze.TotalCost()){
			System.out.printf("The Gold account is the cheapest");
		}
		else if (Silver.TotalCost()<Bronze.TotalCost() && Silver.TotalCost()<Gold.TotalCost()){
			System.out.printf("The Silver account is the cheapest");
		}
		else if (Bronze.TotalCost()<Silver.TotalCost() && Bronze.TotalCost()<Gold.TotalCost()){
			System.out.printf("The Bronze account is the cheapest");
		}
		
	}
	private static int IntInput(){ // short section to get an int input but deny values lower than the given minValue
		// Create new object of type scanner called input
		Scanner input = new Scanner(System.in); 
		//  set the interger Value to less then the threshold minimum (-1)
		int Value = -1 ;
		while (Value < 0){
			Value = input.nextInt();
			if (Value < 0){
				System.out.printf("The number must be greater than or equal to to 0 \nPlease enter a different value: ");
			}
			else{
				break;
			}
		}
		return Value;
	}
}