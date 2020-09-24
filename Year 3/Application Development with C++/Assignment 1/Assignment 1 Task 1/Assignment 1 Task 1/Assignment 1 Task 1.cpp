// Assignment 1 Task 1.cpp :
// Assignmnet 1 is a piece of code which calculates the Voltage drop over a diode in a simple circuit
// The assignment uses an Object Orientated approach for data management and calculations

#include "stdafx.h"
#include <cmath>
#include "iostream"
using namespace std;
/*
The first section creates object types for the key 3 types of components in the circuit:
Diode holds the value for e/kT, this is a constant we use which is dependant on the diode.
Resistor holds a resistance value.
Voltage Source holds the current and voltage in the circuit.
*/

class Diode
{
private:
	double EKT;					// Declare the double EKT in a private instance
public:
	Diode(double newEKT)		// Constructor, the diode object is created with the value for e/kT 
	{
		EKT = newEKT;
	}
	double getEKT()				// public Method returns the value of private Variable EKT for use in calcuation.
	{
		return EKT;
	}
};

class Resistor
{
private:
	double Resistance;				// Declare the double Resistance in a private instance.
public:
	Resistor(double R)
	{
		Resistance = R;			// Constructor, the resistor object is created with the value for Resistance
	}
	double getResistance()
	{
		return Resistance;		// public Method returns the value of private Variable Resistance for use in calcuation
	}
};

class VoltageSource
{
private:
	double Voltage, Current;	// Declare the variables Voltage and current as doubles in a private instance

public:
	VoltageSource(double V , double I) // Constructor, the VoltageSource object is created with a value for Voltage and current
	{
		Voltage = V;
		Current = I;
	}
	double getVoltage()			// public Method returns the value of private Variable Voltage for use in calcuation
	{
		return Voltage;
	}
	double getCurrent()			// public Method returns the value of private Variable Current for use in calcuation
	{
		return Current;
	}

};

/*
The Second Section Contains the Circuit object
The Circuit object is given the relevent components and then we can use this to discover the voltage drop over the diode
*/

class Circuit					// Define a class Circuit for finding the Calculations
{

private:
	double RS, RL, V, EKT,I;	// Define doubles For Source Resistance,Load Resistance, Voltage, E/KT and Current

	double Precision = 0.0001;	// Declare the precicsion as 5 significant figures 

	double FunctionOfX(double x)		 // Calculates the Function of X (Inluded for completeness and modularity)
	{
		double Fx;
		Fx = (I*(exp(EKT*x) - 1) - ((V - x) / (RS + RL)));
		return Fx;
	}

	double FunctionOfXD(double x)		// Calculates the derivative for the Function of X (Inluded for completeness and modularity)
	{
		double FDx;
		FDx = I*(EKT*exp(EKT*x)) + (1 / (RS + RL));
		return FDx;
	}
public:
	Circuit(VoltageSource Voltage, Resistor Rload, Resistor RSource, Diode Diode)	// Constructors takes input of a set of components (Voltage Source, 2 Resistors and a diode)
	{
		V = Voltage.getVoltage();			// Take the needed variables from each of the input components and store it in a relevant Local Variable 
		I = Voltage.getCurrent();
		RS = RSource.getResistance();
		RL = Rload.getResistance();
		EKT = Diode.getEKT();
	}

	double CalculateVD(double Xi = 0.1)		// Uses the Newton Rhaphson Method to calculate the voltage drop over the diode takes an input of a guessed preliminary x value
	{
		double Xii = (Xi - (FunctionOfX(Xi) / FunctionOfXD(Xi)));	// Calculate the next value of X "Xii" 
		if (abs((Xii - Xi) / Xi) >= Precision)						// Determine wether the new value of x is right for the current number of significant figures.
		{
			return CalculateVD(Xii);								// If not right, return the value given by running The newton Raphson method on the current value of Xii
		}
		else {
			return Xi;												// If right return the value for Xi
		}
	}
	double CalculateVRL()				// Calculates the value of the voltage drop over RL
	{
		double VD = CalculateVD();	// Gets the Voltage Drop over the diode
		return (V - VD)*(RL / (RS + RL)); // Returns the voltage drop over the resistor 
	}

	void Summary()													// Summmary prints a summary of the calculations to the console window.
	{
		cout << "For the Circuit where the Values are as Below"  << endl;
		cout << "Source Voltage    = " << V << " Volts"<< endl;
		cout << "Source Current    = " << I << " Amps" << endl;
		cout << "Load Resistor     = " << RL << " Ohms" << endl;
		cout << "Source Resistor   = " << RS << " Ohms" << endl;
		cout << "The Value of e/kT = " << EKT << endl;
		cout << "Calculated voltage drop over the diode = "<< CalculateVD() << " Volts" << endl;
		cout << "Calculated voltage drop over the Load Resistor = " << CalculateVRL() << " Volts" << endl;
		
	}
};

/*
The third part is the main class
This part handles user interaction, gets inputs, declares objects and does all the other bits and bobs
*/

int main()
{
	double inputV, inputEKT, inputLR;					// Declare variables for the inputs

	cout << "Please Enter the Source Voltage: ";
	cin >> inputV;

	VoltageSource V(inputV, (8 * pow(10, -8)));			// Ask for Voltage, Record input, and create Voltage Source Object

	cout << "Please Enter the Value of e/kT : ";	
	cin >> inputEKT;
	Diode D(inputEKT);									// Ask for e/kT value, Record input and create Diode Object

	cout << "Please Enter the Resistance of the load Resistor : ";
	cin >> inputLR ;
	Resistor RL(inputLR);								// Ask for Load Resistance, Record input and create Diode Object
	
	Resistor RS(50000);									// Create Resistor Object with a resistance of 50000ohms

	Circuit Problem( V, RL, RS, D);						// Create Object for the circuit Giving the circuit the components needed 

	Problem.Summary();									// Print Summary of the Problem
    return 0;
}
