/**********************************\
  This is the Robot Movement Class
  it contains all the methods and 
  attribultes belonging to A Robot
\**********************************/

public class RobotMovement{
	public int Angle;					// declaring Angle as an int
	public double Speed;					// declaring Speed as a double
	public double Time;					// declaring Time as a double 


	public void setAngle(int a){		// Set the variable Angle as the interger defined as a
		Angle = a;
	}
	
	public void setSpeed(double s){		// Set the variable Speed as the double defined as s
		Speed = s;
	}
	
	public void setTime(double t){			// Set the variable Time as the interger defined as t
		Time = t;
	}
	
	public double getDistance(){		// Calculate the distace the robot has travelled using Distance = Speed x Time 
		return Speed*Time;
	}
	
	public double getBatteryEstimate(){ // Calculate the Estimated Battery Usage in seconds of idle time battery usage using BatteryEstimate = Time x Speed^2 * 3.7
		return Time*Math.pow(Speed,2)*3.7;
	}
	
	public double getHorizontalPos(){	// Calculate the Horizontal position of the robot by converting the angle to Radians and the equation HorizontalDistance = Distance x Sin(AngleInRad)
		return getDistance()*Math.sin(Math.toRadians(Angle));
	}
	
	public double getVerticalPos(){		// Calculate the Vertical position of the robot by converting the angle to Radians and the equation VerticalDistance = Distance x Cos(AngleInRad)
		return getDistance()*Math.cos(Math.toRadians(Angle));
	}
	
}