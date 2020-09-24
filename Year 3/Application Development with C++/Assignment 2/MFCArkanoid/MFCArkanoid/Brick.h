#pragma once


class Brick {
public:
	Brick(int BlockW, int BlockH, int X, int Y);
	void UpdateSize(int BlockW, int BlockH, int X, int Y);
	void Reset();
	CRect BlockLocation;
	int Hits;
	bool active = true;
	
	void hitBlock();
	void Draw(CDC*pDC);
	
};