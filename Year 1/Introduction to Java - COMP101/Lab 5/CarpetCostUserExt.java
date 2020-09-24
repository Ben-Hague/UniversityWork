/**************************************************************\
  This is the Carpet Cost User Class
  It asks you to input length and width of a room
  then creates a carpet, new  an  instance of the CarpetCost
  with the attributes declared in the beginning. it then prints
  a list of details related to the cost of fitting 3 different
  types of carpet.
\**************************************************************/

import java.util.Scanner;

public class CarpetCostUserExt
{
	public static void printStats(CarpetCost newCarpet) // a method which prints the stats for the object of type Carpet called newCarpet which is given to it
	{
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
	
	public static void main(String[] args)
	{
		double VATPercentage = 20;
		int maxRoomSize = 100;
		double labourCharge = 16.50;

		
		Scanner input = new Scanner(System.in); //create new  object of type Scanner called input 
		
		System.out.printf("Please input apartment length (in meters):");	//Ask the user to enter the apartment Length 
		double length = input.nextDouble();			// Create an objectt of type Double which holds an input Length
		System.out.printf("Please input apartment width (in meters):");		//Ask the user to enter the apartment Width
		double width = input.nextDouble();			// Create an objectt of type Double which holds an input Width
		
		CarpetCost Basic = new CarpetCost(VATPercentage, maxRoomSize, labourCharge, 4.75, length, width);	//create new  object of type CarpetCost called Basic
		CarpetCost Smart = new CarpetCost(VATPercentage, maxRoomSize, labourCharge, 6.00, length, width);   //create new  object of type CarpetCost called Smart
		CarpetCost Luxury = new CarpetCost(VATPercentage, maxRoomSize, labourCharge, 8.25,length, width);	//create new  object of type CarpetCost called Luxury
		
		System.out.printf("\n\nThe apartment has length %.2f and width %.2f. \n" , length, width);
			// Print the dimnentions of the apartment to 2dp
		System.out.printf("Area of appartment: %.2f \n" , Basic.getArea() );
			// Print the output of getArea() belonging to Basic to 2dp

		System.out.printf("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~Basic~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		printStats(Basic);

		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~Smart~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		printStats(Smart);

		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~Luxury~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		printStats(Luxury);


	}

}