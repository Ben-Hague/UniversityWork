/**************************************************************\
  This is the Carpet Cost User Class
  It asks you to input length and width of a room
  then creates a carpet, new  an  instance of the CarpetCost
  with the attributes declared in the beginning. it then prints
  a list of details related to the cost of fitting the carpet.
\**************************************************************/

import java.util.Scanner;		// import scanner for user input

public class CarpetCostUser
{
	public static void main(String[] args)
	{
		// These Variables are liable to change and therefore are declared outside of the object,
		double VATPercentage = 20; 
		double maxRoomSize = 100;
		double labourCharge = 16.50;
		double unitCost = 4.75;
		
		Scanner input = new Scanner(System.in);		 //create new  object of type Scanner called input 
		
		System.out.printf("Please input apartment length (in meters):");	//Ask the user to enter the apartment Length 
		double length = input.nextDouble();			// Create an objectt of type Double which holds an input Length
		System.out.printf("Please input apartment width (in meters):");		//Ask the user to enter the apartment Width
		double width = input.nextDouble();			// Create an objectt of type Double which holds an input Width

		CarpetCost newCarpet = new CarpetCost(VATPercentage, maxRoomSize, labourCharge, unitCost, length, width);  //create new  object of type CarpetCost called newCarpet
		
		System.out.printf("\n\nThe apartment has length %.2f and width %.2f. \n" , newCarpet.dimentions[0],newCarpet.dimentions[1]);
			// Print the dimnentions of the apartment to 2dp
		System.out.printf("Area of appartment: %.2f \n" , newCarpet.getArea() );
			// Print the output of getArea() belonging to newCarpet to 2dp
		System.out.printf("Carpet area cost: £%.2f \n" , newCarpet.getCostMaterials());
			// Print the output of getCostMaterials() belonging to newCarpet to 2dp
		System.out.printf("Labour service charges: £%.2f \n" , newCarpet.getCostLabour());
			// Print the output of getCostLabour() belonging to newCarpet to 2dp
		System.out.printf("Total before VAT: £%.2f \n" , newCarpet.getTotal());
			// Print the output of getTotal() belonging to newCarpet to 2dp
		System.out.printf("VAT: £%.2f\n" , newCarpet.getVAT());
			// Print the output of getVAT() belonging to newCarpet to 2dp
		System.out.printf("Final Cost: £%.2f" , newCarpet.getFinalCost());
			// Print the output of getFinalCost() belonging to newCarpet to 2dp
	}

}