#pragma once
class Paddle {
public:
	CPoint Location;
	int size;
	bool BlackPaddle = true;
	Paddle(int Size, CPoint StartLocation);
	Paddle();
	CRect Block();
	void Draw(CDC* pDC);
	void UpdateLocation(CPoint Location);
	void UpdateLocation(int Ammount);
};

