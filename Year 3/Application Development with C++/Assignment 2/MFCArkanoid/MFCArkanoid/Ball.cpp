#include "stdafx.h"

#include "Ball.h"
	Ball::Ball() {  //Constructor Default defines a ) velocity , Location and 0 size, this acts as a placeholder for when the ball has been given its settings later
		size = 0;
		Velocity[0] = 0;
		Velocity[1] = 0;
		Location = CPoint(0,0);
	}
	Ball::Ball( int Xdir, int Ydir, CPoint StartLocation) { //define the start variables from the constructor

		size = 20;
		Velocity[0] = Xdir;
		Velocity[1] = Ydir;
		Location = StartLocation;
	}
	void Ball::MoveBall() // move the x and y of the ball by the velocity

	{
		Location.x += Velocity[0];
		Location.y += Velocity[1];
	};
	void Ball::BounceBall(bool Horozontal) //Bounceball based on the angle of the surface it hits, Horosontal or Vertical
	{
		if (Horozontal)
		{
			Velocity[0] *= -1; //bounce in the vertical space by inverting Y component of movement
			Velocity[1] *= 1;
		}
		else
		{
			Velocity[1] *= -1; //Bounce in Horosontal space by inverting the x component of movement
			Velocity[0] *= 1;

		}
	};
	void Ball::Draw(CDC* pDC) // Input the pem object, produce a drawn output on the screem by drawing the paddle 
	{
		CPen BallPen;
		BallPen.CreatePen(PS_SOLID, 2, RGB(0, 0, 0));
		CBrush BallBrush{ RGB(0, 0, 0) };
		CPen* pOldPen{ pDC->SelectObject(&BallPen) };
		CBrush* pOldBrush{ pDC->SelectObject(&BallBrush) }; // Make pen and brush in black then select them and draw the ball at the location
		pDC->Ellipse((Location.x - size / 2), (Location.y - size / 2), (Location.x + size / 2), (Location.y + size / 2));
	};
	CPoint Ball::Bottom() //Returns the Bottom of the ball as a cpoint
	{
		return CPoint((Location.x), Location.y + size / 2);
	}
	CPoint Ball::Top()//Returns the Top of the ball as a cpoint
	{
		return CPoint((Location.x), Location.y - size / 2);
	}
	CPoint Ball::Left()//Returns the Left of the ball as a cpoint
	{
		return CPoint((Location.x - size / 2), Location.y );
	}
	CPoint Ball::Right()//Returns the Right of the ball as a cpoint
	{
		return CPoint((Location.x + size / 2), Location.y);
	}
	
	void Ball::Stop(CPoint StopLocal) //Stops the ball at the set location
	{
		Location = StopLocal;
		Velocity[0] = 0;
		Velocity[1] = 0;
	}
	void Ball::Go(int Ballspeed) //Starts the ball at the specified speed
	{
		Velocity[0] = -Ballspeed;
		Velocity[1] = Ballspeed;
	}