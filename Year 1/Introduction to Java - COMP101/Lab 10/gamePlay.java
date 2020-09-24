public class gamePlay{	
	// Attributes
	private int players;
	private int rounds;
	private int[][][] scores ; 
	private boolean draw = false;
	//Constructor 
	public gamePlay(int players, int rounds){
		this.players = players;
		this.rounds = rounds;
		playGame();
	}
	
// Classes related to runing the game
	private int[][] playRound(){ // Simulates a single round of the game and returns a 2d array of the scores for each dice and the total for each player
		int[][] Scores = new int[players][4];
		for (int player = 0; player<players; player++)
		{
			ThreeDiceScorer Round = new ThreeDiceScorer(DieRoll(),DieRoll(),DieRoll());
			Scores[player] = Round.getStats();
		}
		
		return Scores;
	}
	public int[][][] playGame() // run the game and return a 3d array containing the each round in the form given by the playRound function
	{
		int[][][] Scores = new int[rounds][players][4];
		for (int round = 0; round<rounds; round++){
			Scores[round] = playRound();
		}
		scores = Scores;
		return Scores;
	}

// Classes used for calculations
	private int DieRoll() // return a random number between one and 6 AKA Roll the dice 
	{
		int DiceValue = 1+(int)(6*Math.random());
		return DiceValue;
	}
	private int GetRoundWinner(int round) //  determine the winner of any given round
	{
		int TopPlayer = 0;
		for (int player = 0; player<players; player++)
		{
			if (scores[round][player][0]>scores[round][TopPlayer][0])
			{
				TopPlayer = player;
;
			}

		}
		return TopPlayer+1;
	}
	private int GetWinner() // determine the winer with the most points over the game
	{
		int TopPlayer = 1;
		for (int player = 1; player<players+1; player++)
		{
			if (GetTotalScore(player)>GetTotalScore(TopPlayer))
			{
				TopPlayer = player;
				draw = false;
;
			}
			else if (GetTotalScore(player)==GetTotalScore(TopPlayer))
			{
				draw = true;
			}
			

		}
		return TopPlayer;
	}
	private int GetTotalScore(int Player) // return the total score of a given player over the whole game 
	{
		int Score = 0;
		for (int round = 0; round<rounds; round++)
		{
			Score+= scores[round][Player-1][0];
		}
		return Score;
	}
	private int GetAverage(int Player) // determine the average score over the entire game 
	{
		return GetTotalScore(Player)/rounds;

	}
	
	// User Outputs 
	public void printStats() // print the stats of the game 
	{
		for (int round = 0; round<rounds; round++)
		{
			System.out.printf("\nRound %-5d", round+1);
			for (int player = 0; player<players; player++)
			{
				System.out.printf("Player %-1d: %-1d, %-1d, %-1d	Score: %-2d	", player+1, scores[round][player][1],scores[round][player][2],scores[round][player][3],scores[round][player][0]);
			}
			System.out.printf("The Winner this round is Player %-1d", GetRoundWinner(round)); // print the stats round by round
		}
		System.out.printf("\n\nTotal Points \n");
		for (int player = 0; player<players; player++)
		{
			System.out.printf("Player %-1d: %-6d",player+1, GetTotalScore(player+1));
		}
		System.out.printf("\n\nAverage Points Per Round \n");
		for (int player = 0; player<players; player++)
		{
			System.out.printf("Player: %-1d: %-6d",player+1, GetAverage(player+1));
		}
		if (draw)
		{
			System.out.printf("The game was a draw");
		}
		else
		{
			System.out.printf("\n\nThe Overall Points Winner is Player:%-1d", GetWinner());
		}
	
	}
}
