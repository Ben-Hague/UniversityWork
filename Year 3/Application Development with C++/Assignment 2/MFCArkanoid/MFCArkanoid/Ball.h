#pragma once
class Ball {
public:
	int size, Velocity[2];
	CPoint Location;
	Ball();
	Ball(int Xdir, int Ydir, CPoint StartLocation);
	void MoveBall();
	void BounceBall(bool Horozontal);
	void BounceBall(int PaddleLocation);
	void Draw(CDC* pDC);
	void Stop(CPoint StopPoint);
	void Go(int Ballspeed);
	CPoint Top();
	CPoint Bottom();
	CPoint Left();
	CPoint Right();
};
