public class BronzeAccount extends StandardAccount {
	public BronzeAccount(int DaytimeCalls,int EveningCalls,int BroadbandUse){
		// User inputs
		this.DaytimeCalls = DaytimeCalls;
		this.EveningCalls = EveningCalls;
		this.BroadbandUse = BroadbandUse;
		
		// Package Name
		PackageName = "Bronze";
		
		// Costs
		PackageCost = 36;
		DaytimeCallPrice = 0.12;
		EveningCallPrice = 0.05;
		BroadbandCost = 0.02;
		
		// Profit ammounts
		Profit = 15;
		DaytimeProfit = 0.05;
		EveningProfit = 0.02;
		BroadbandProfit = 0.01;
		
		// Features of the account
		NumberOfChannels = 60;
		BroadbandIncluded =500;
	}
}