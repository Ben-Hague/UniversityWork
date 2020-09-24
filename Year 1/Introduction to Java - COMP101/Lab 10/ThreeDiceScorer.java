public class ThreeDiceScorer extends ThreeDice{
	public ThreeDiceScorer(int s1, int s2, int s3)
	{
		super(s1,s2,s3); // pass the values on to the  superclass constructor
		
	}
	public int[] getStats(){
		int sum = die1+die2+die3; // calculate the sum of the three rolls
		if (threeSame()) // calculate the total score if there are 3 of the same
		{
			sum += 60;
		}
		else if (runOfThree()) //calculate the total score if there area run of 3
		{
			sum += 40;
		}
		else if (pair()) //calculate the total if there is a pair
		{
			sum += 20;
		}
		else if (allDifferent()) // calculate the sum if they are all different 
		{
			sum += 0 ;
		}
		int[] playerscore = {sum, die1,die2,die3}; // return an array populated with the dice score in order and the 
		return playerscore;
	}

	
	
}