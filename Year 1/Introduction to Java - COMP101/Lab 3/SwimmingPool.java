import java.util.Scanner;

public class SwimmingPool{
	private double length;
	private double width;
	private double depth;
	private static double rateOfFlow = 50.0;
	private static double UNITCAPACITY = 1000.0;
	public void setLength(double l){
		length = l;
	}
	public void setWidth(double w){
		width = w;
	}
	public void setDepth(double d){
		depth = d;
	}
	public double getVolume(){
		return length*width*depth;
	}
	public double timeToFill(){
		return (getVolume()*UNITCAPACITY)/rateOfFlow;
	}
	public static void main(String[] args){
		SwimmingPool bigPool = new SwimmingPool();
		Scanner input = new Scanner(System.in);
		bigPool.setWidth(input.nextInt());
		bigPool.setLength(input.nextInt());
		bigPool.setDepth(input.nextInt());
		System.out.println(bigPool.timeToFill());
	}
	
}