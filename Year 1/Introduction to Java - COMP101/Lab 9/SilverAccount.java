public class SilverAccount extends StandardAccount {
	public SilverAccount(int DaytimeCalls,int EveningCalls,int BroadbandUse){
		// User inputs
		this.DaytimeCalls = DaytimeCalls;
		this.EveningCalls = EveningCalls;
		this.BroadbandUse = BroadbandUse;
		
		// Package name
		PackageName = "Silver";
		
		// Costs
		PackageCost = 46;
		DaytimeCallPrice = 0.12;
		EveningCallPrice = 0;
		BroadbandCost = 0.01;
		
		// Profit ammounts
		Profit = 20;
		DaytimeProfit = 0.05;
		EveningProfit = -0.01;
		BroadbandProfit = 0;
		
		// Features of the account
		NumberOfChannels = 130;
		BroadbandIncluded =1000;
				
		// Package perks
		Spotify = true ;
	}
}	