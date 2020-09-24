// ConsoleApplication3.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "iostream"

using namespace std;

int main()
{
	int FirstNum = 0;
	int SecondNum = 0;

	cout << "Please enter the first number" << endl;
	cin >> FirstNum;

	cout << "Please enter the second number" << endl;
	cin >> SecondNum;

	int product = FirstNum*SecondNum;
	cout << "The Product is: " << product << endl;
	return 0;  

}

