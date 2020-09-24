#pragma once
#include "stdafx.h"
#include<time.h>
#include "Brick.h"

	Brick::Brick(int BlockW, int BlockH, int X, int Y) // Brick constuctor sets the bnrick area (BrickLocation) and the number of hits taken to destroy the brick
	{
		BlockLocation = CRect(X*BlockW, Y*BlockH, (X + 1)*BlockW, (Y + 1)*BlockH);

		Hits = (rand() % 5)+1;
	};
	void Brick::UpdateSize(int BlockW, int BlockH, int X, int Y) // Brick constuctor sets the bnrick area (BrickLocation) and the number of hits taken to destroy the brick
	{
		BlockLocation = CRect(X*BlockW, Y*BlockH, (X + 1)*BlockW, (Y + 1)*BlockH);
	};
	void Brick::Reset() //Reset, ReRandomises the brick and resets the active Flag for the brick, The if a brick is not active it cannot be collided with 
	{
		active = true;
		Hits = (rand() % 5) + 1;
	}

	void Brick::hitBlock() // when the block is hit remove one from the hits. then if the hits <= 0 make the active Flag False
	{
		Hits = 0;
		if (Hits <= 0)
		{
			active = false;
		}
	}
	void Brick::Draw(CDC*pDC) // Draw uses the Hits and draws a brick of set colour depending on the number of hits remaining.
	{
		int colour[3] = { 255,255,255 };
		//Set the colour for each value of brick
		switch (Hits) {
		case 1: //Blue
			colour[0] = 0;
			colour[1] = 0;
			colour[2] = 255;
			break;
		case 2: //Green
			colour[0] = 0;
			colour[1] = 255;
			colour[2] = 0;
			break;
		case 3://Red
			colour[0] = 255;
			colour[1] = 0;
			colour[2] = 0;
			break;
		case 4: //Pink
			colour[1] = 0;
			colour[0] = 255;
			colour[2] = 255;
			break;
		case 5: // cyan
			colour[0] = 0;
			colour[1] = 255;
			colour[2] = 255;
			break;
		}

		CPen BrickPen; //Create the pen
		BrickPen.CreatePen(PS_NULL, 2, RGB(0, 0, 0));//set to invisible
		CBrush BrickBrush{ RGB(colour[0], colour[1], colour[2]) }; // set the coloured brush
		CPen* pOldPen{ pDC->SelectObject(&BrickPen) }; //select the pen
		CBrush* pOldBrush{ pDC->SelectObject(&BrickBrush) }; //select the brush
		pDC->Rectangle(BlockLocation);//Draw the Block
	};
