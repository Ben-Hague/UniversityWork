import java.util.Scanner;
public class GameExt{

	public static void main(String[] args)
	{
		System.out.printf("Please enter the number of Players:");  
		int players = IntInput(); // getting user input for number of players
		
		System.out.printf("Please enter the number of Rounds:");
		int rounds = IntInput(); // getting user input for number of rounds

		gamePlay GamePlay = new gamePlay(players,rounds); // create new object of type gamePlay called GamePlay this creates and plays the game
		GamePlay.printStats(); // run the printstats method belonging to gameplay
	}
	private static int IntInput(){ // short section to get an int input but deny values lower than 0
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