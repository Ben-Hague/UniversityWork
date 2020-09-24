/**********************************\
  This is the Carpet Class
  it contains all the methods and 
  attribultes belonging to a Carpet
\**********************************/

public class CarpetCost
{
	// this declares all the values which will be used throughout the code 
	private double VATPercentage;
	private double maxRoomSize;
	private double labourCharge;
	private double unitCost;
	public double[] dimentions = new double[2];
	
	// this allows us to create an object and pre-set the attributes given to the object
	public CarpetCost (double VATPercentage, double maxRoomSize, double labourCharge, double unitCost,  double length, double width)
	{	// set each of the variables to their user defined value
		this.VATPercentage = VATPercentage; 
        	this.maxRoomSize = maxRoomSize;
		this.labourCharge = labourCharge;
		this.unitCost = unitCost;
		dimentions[0] = length;
		dimentions[1] = width;
	}
	
	public double getArea() 			// calculate and return the area as a float
	{
		return dimentions[0]*dimentions[1];
	}
	
	public double getCostMaterials() 	// calculate and return the cost of the materials
	{
		return unitCost*getArea();
	}
	
	public double getCostLabour() 		// calculate and return the cost of labour to fit the carpet
	{
		if (getArea() >= maxRoomSize)
		{
			return (labourCharge+(getArea()/4))*1.1;
		}
		else 
		{
			return labourCharge+(getArea()/4);
		}
	}
	
	public double getTotal() 			// calculate and  return the total cost, Pre VAT
	{
		return getCostLabour()+getCostMaterials();
	}
	
	public double getVAT()				// calculate and returnt the VAT cost
	{
		return getTotal()*VATPercentage/100;
	}
	public double getFinalCost()		//Calculate and return the Final Total Cost
	{	
		return getTotal()+getVAT();
	}

}