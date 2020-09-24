public class GoldAccount extends StandardAccount {
	public GoldAccount(int DaytimeCalls,int EveningCalls,int BroadbandUse){
		// User  Inputs
		this.DaytimeCalls = DaytimeCalls;
		this.EveningCalls = EveningCalls;
		this.BroadbandUse = BroadbandUse;
		
		// Package Name
		PackageName = "Gold";
		
		// Costs
		PackageCost = 61;
		DaytimeCallPrice = 0;
		EveningCallPrice = 0;
		BroadbandCost = 0.01;
		
		// Profit ammounts
		Profit = 25;
		DaytimeProfit = -0.03;
		EveningProfit = -0.01;
		BroadbandProfit = 0;
		
		// Features of the account
		NumberOfChannels = 230;
		BroadbandIncluded =1520;
		
		// package perks
		Spotify = true ;
		MusicOnDemand = true ;
	}
}