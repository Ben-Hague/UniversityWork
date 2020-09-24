public abstract class StandardAccount{
	
	// declaring all variables for all classes
	// Storing the package name
	public String PackageName;
	
	// Account Costs
	public double PackageCost;
	public double DaytimeCallPrice;
	public double EveningCallPrice;
	public double BroadbandCost;
	
	// Profit ammounts for the package
	public double Profit;
	public double DaytimeProfit;
	public double EveningProfit;
	public double BroadbandProfit;
	
	// input Variables from the user
	public double DaytimeCalls;
	public double EveningCalls;
	public double BroadbandUse;
	
	// Features of the account
	public int NumberOfChannels;
	public int BroadbandIncluded;
	
	// Package Perks as boolean values 
	public boolean Spotify = false ; 
	public boolean MusicOnDemand = false ; 
	
	
	// methods
	
	public double CalculateProfit(){ // calculate total profit for the account  
		double TotalProfit = Profit;
		double Daytime = DaytimeProfit*DaytimeCalls;
		double Evening = EveningProfit*EveningCalls;
		TotalProfit += Daytime+Evening;
		if (BroadbandUse > BroadbandIncluded){ // if using over allocated broadband add the excess to the total
			TotalProfit += BroadbandProfit*(BroadbandUse-BroadbandIncluded);
		}
		return TotalProfit ;
	}
	public double DaytimeCallCost(){ // calculate the cost of the daytime calls
		return DaytimeCallPrice*DaytimeCalls;
	}
	public double EveningCallCost(){  // calculate the cost of the evening and weekend calls
		return EveningCallPrice*EveningCalls;
	}
	public double BroadbandUseCost(){
		if (BroadbandUse > BroadbandIncluded){ // if using over allocated broadband calculate the broadband use
			return BroadbandCost*(BroadbandUse-BroadbandIncluded);
		}
		return 0;
	}
	public double TotalCost(){ // calculate the total cost
		return PackageCost+DaytimeCallCost()+EveningCallCost() + BroadbandUseCost();
	}
	public void PrintCosts(){ // output the costs for the account to the screen 
		System.out.printf("Account Summary for %s Account\n", PackageName);
		System.out.printf("Package Cost : %.2f\n", PackageCost);
		System.out.printf("Cost of daytime calls: %.2f/Min\n", DaytimeCallPrice);
		System.out.printf("Cost of evening and weekend calls: %.2f/Min\n",  EveningCallPrice);
		System.out.printf("Number of Channels: %-1d\n", NumberOfChannels);
		System.out.printf("Broadband included: %-1dMb\n", BroadbandIncluded);
		System.out.printf("Total daytime call cost: %.2f\n", DaytimeCallCost());
		System.out.printf("Total evening/Weekend call cost: %.2f\n", EveningCallCost());
		System.out.printf("Total (extra) broadband cost: %.2f\n", BroadbandUseCost());
		System.out.printf("Total cost: %.2f\n", TotalCost());
		if (Spotify) {
			System.out.printf("Package Includes Spotify Account\n");
		}
		if (MusicOnDemand) {
			System.out.printf("Package Includes Music On Demand\n");
		}
		System.out.printf("\n\n\n");
		
	}
	public void PrintProfit(){ // output the profit for the account to the screen
		System.out.printf("The profit made on the %s package is: %.2f\n",PackageName, CalculateProfit());
	}
}