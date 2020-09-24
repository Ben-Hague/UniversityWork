#include "stdafx.h"

#include "Paddle.h"
	Paddle::Paddle(int Size, CPoint StartLocation) //Constructor sets the location, and size 
	{
		Location = StartLocation;
		size = Size;
	};
	Paddle::Paddle() { //Default Paddle Size Declared
		size = 150;
	}
	CRect Paddle::Block() // Return the rectangle which is the paddle
	{
		return CRect(Location.x - size / 2, Location.y - 10, Location.x + size / 2, Location.y + 10);
	}
	void Paddle::Draw(CDC* pDC) // draw the paddle 
	{
		CPen PaddlePen; //create the pen object 
		PaddlePen.CreatePen(PS_NULL, 2, RGB(0, 0, 0)); //Set Null Pen Colour
		CPen* pOldPen{ pDC->SelectObject(&PaddlePen) }; //Select the paddle Pen
		CBrush BlackBrush{ RGB(0, 0, 0) }; // Create the black Brush
		CBrush PaddleBrush{ RGB(0, 255, 0) };//create the green brush
		CBrush* pOldBrush{ pDC->SelectObject(&PaddleBrush) }; //Select te green brush
		if (BlackPaddle) //if black paddle
		{
			
			CBrush* pOldBrush{ pDC->SelectObject(&BlackBrush) }; // select the black brush
		}
		pDC->Rectangle(Block()); //draw block
	}
	
	void Paddle::UpdateLocation(CPoint Place)
	{
		Location.x = Place.x; // Set the x location to the specified location given.
	}
	void Paddle::UpdateLocation(int Distance)
	{
		Location.x += Distance; // Set the x location to the specified location given.
	}