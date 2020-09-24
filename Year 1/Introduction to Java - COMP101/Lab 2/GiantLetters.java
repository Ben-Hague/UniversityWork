/*       Code Written to Print CS username (U6BH) vertically for COMP101 Lab2       */
/*       Each letter is made up with a series of spaces and the character '*'       */
/*                          -Written by Ben Hague 2016                              */

public class GiantLetters
{ 
	public static void main(String[] args)
	{
		String[] letterB = // this is where the letter  B is stored as an array of strings
		{
			"" 
			,"****** "
			,"*     *"
			,"*     *"
			,"****** "
			,"*     *"
			,"*     *"
			,"****** "
		};

		String[] letterH = // this is where the letter  H is stored as an array of strings
		{	
			""	
			,"*     *"
			,"*     *"
			,"*     *"
			,"*******"
			,"*     *"
			,"*     *"
			,"*     *"
		};
		
		String[] letterU = // this is where the letter  U is stored as an array of strings
		{
			""  
			,"*     *"
			,"*     *"
			,"*     *"
			,"*     *"
			,"*     *"
			,"*     *"
			," ***** "
		};

		String[] number6 = // this is where the number 6 is stored as an array of strings
		{
			"" 
			," ***** "
			,"*     *"
			,"*      "
			,"****** "
			,"*     *"
			,"*     *"
			," ***** "
		};
		
		printSymbol(letterU, 'U'); // Print the array letterU out of the char 'U'
		printSymbol(number6, '6'); // Print the array number6 out of the char '6'
		printSymbol(letterB, 'B'); // Print the array letterB out of the char 'B'
		printSymbol(letterH, 'H'); // Print the array letterH out of the char 'H'
	}
    public static void printSymbol(String[] giantLetter, char Symbol) // used in a way where called as printSymbol(a,b); where a is an array of strings making up the letter and B is the character to replace '*' with
	{ 															      // procedure to take the array as above and print the large charachter out line by line changing the letter for the specified one
		for (String currentLine : giantLetter)// for each item in the string array fed to the procedure call that line currentLine then execute as below
		{ 
			System.out.println(currentLine.replace('*',Symbol )); // print the line and replace '*' with the specified Character
		}
	}
}
	

