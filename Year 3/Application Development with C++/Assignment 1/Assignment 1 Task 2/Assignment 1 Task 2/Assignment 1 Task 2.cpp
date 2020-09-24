// Assignment 1 Task 2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "iostream"
#include <string>
#include <fstream>

using namespace std;


char Capitalise(char InputChar)					// Capitalise is a short segment of code using the Ascii value of a letter to determine if it is lowercase and if so, capitalise it 
{													// Takes a char input and gives a char output 
	int InputInt = (int)InputChar;					// Find the Ascii Value for input char
	if ('a' <= InputInt && InputInt <= 'z') 		// if the input char is lower case 97 is "a" and 122 is "z"
	{
		InputInt -= 32;								// Convert the Input char to a capital by subtracting 32 from the char value (Ascii table magic)
	}
	return (char)InputInt;							// return the new char
}

string PrepName(string Input)					// SentanceCase is a function which looks for spaces within a statement and capitalises the first letter after the space useing Capitalise
{													// Takes a string input and gives a string output 
	Input[0] = Capitalise(Input[0]);				// This line is important as it ensures the first letter of the string is capitalised
	int Fspace = 1000;								// this is used to find the first space, we choose an unrealisticly high number to allow the first space to be identified
	int Lspace = 0;									// this is used to find the last space, we make the first number 0 as this is the begininng of the array
	for (int i = 0; i < (int)Input.length()-1; i++)	// For i in the range of 0  to the length of the string
	{
		if ((char)Input[i] == ' ')						// if the char is a space
		{
			if (i < Fspace) { Fspace = i; }					// store the location for the first space in Fspace
			if (i > Lspace) { Lspace = i; }					// store the location for the last space in Lspace
			Input[i + 1] = Capitalise(Input[i + 1]);		// use the Capitalise function to ensure the next charachter is a capital
		}
	}
	Input[Fspace] = ',';							// Convert the first space to a comma for the csv file 
	if (Fspace == Lspace) {							// if there are only two names determined by the difference between first and last space
		Input.insert(Lspace, ",");						// insert an additional comma to indicate a blank colum for middle name
	}
	else {											// if there are not 2 names
		Input[Lspace] = ',';						// replace the final space to a comma at the end of the middle names
	}
	return Input;									// Return the new modified comma deliminated string 
}
string GetText()									// Get the user input and verify it 
{
	string Input = " ";								// Declare the input string
	try
	{
		getline(cin, Input);						// Get the input from the screen

		for (int i = 0; i < ((int)Input.length() - 1); i++)		// For i in the range of 0  to the length of the string
		{		
			if (false ==(((char)Input[i]>='a'&& (char)Input[i]<='z') || ((char)Input[i] >= 'A' && (	char)Input[i] <= 'Z') || ((char)Input[i] == ' ') || ((char)Input[i] == '-') || ((char)Input[i] == '\'')))						// if the char is a space
			{
				throw std::invalid_argument("Non Valid Characters Detected"); // if not valid input throw invalid_argument 
			}
		}
		return Input;
		
	}
	catch (std::invalid_argument)	//	catch invalid argument say prompt and return the GetText Function
	{
		cout << "Invalid Symbol used. Ony letters \" \" and \"-\" are permitted. " << endl;
		cout << "Please Re-enter the name : " << endl;
		return GetText();
	}


}

int main()
{
	string address = "Data.csv";	// declare a source file
	ofstream File;					// start and output stream called file
	string Name;					// Declare the name Variable
	int noOfPeople = 5;				// declare an integer for number of people
	for (int Person = 1; Person <=noOfPeople; Person++)		// for number of people
	{
		cout << "Please enter name " <<  Person << ": " << endl; 
		Name = GetText();
		File.open(address, ios::app);	//get name input 

		Name = PrepName(Name);			// Procees the name to the correct format

		File << Name << endl;			// Write the name to the file
		cout << "Name Written to file" << endl; 
		File.close();					// close the file
	}
	cout << "The Name has been stored in CSV format where Collum 1 is the Given name, 2 the Middle Name(s) and 3 the Family name \n The File is stored as "<< address << endl;
	//print a summary 
	return 0;
}

