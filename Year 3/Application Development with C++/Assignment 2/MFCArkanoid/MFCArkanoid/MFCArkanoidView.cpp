
// MFCArkanoidView.cpp : implementation of the CMFCArkanoidView class
//

#include "stdafx.h"
// SHARED_HANDLERS can be defined in an ATL project implementing preview, thumbnail
// and search filter handlers and allows sharing of document code with that project.
#ifndef SHARED_HANDLERS
#include "MFCArkanoid.h"
#endif

#include "MFCArkanoidDoc.h"
#include "MFCArkanoidView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

// Include the relevant header files
#include <vector>
#include "Ball.h"
#include "Paddle.h"
#include "Brick.h"
#include<time.h>
#include "memdc.h"
#include "GameOverDialoig.h"
#include "Settings.h"
#include "PausedState.h"

//Initilise the objects for use throughout the methods in this class
Ball TheBall; // Make a Ball Object
Paddle ThePaddle; // Make a Paddle Object
std::vector <std::vector <Brick>> Blocks; //Make an vector of a vector of blocks

// Determine the key gameplay variables
int Rows = 3;
int Columns = 10;
int BallSpeed = 3;

// Create an object to represent the screen 
CRect Screen;

// and a Variable to for the score
int Score;
// CMFCArkanoidView

IMPLEMENT_DYNCREATE(CMFCArkanoidView, CView)

// Declare the message handlers
BEGIN_MESSAGE_MAP(CMFCArkanoidView, CView)
	ON_WM_TIMER()
	ON_WM_ERASEBKGND()
	ON_WM_MOUSEMOVE()
	ON_WM_CREATE()
	ON_COMMAND(ID_KEYBOARDLEFT, &CMFCArkanoidView::OnKeyboardleft)
	ON_COMMAND(ID_KEYBOARDRIGHT, &CMFCArkanoidView::OnKeyboardright)
	ON_COMMAND(ID_FILE_SETTINGS, &CMFCArkanoidView::OnFileSettings)
	ON_COMMAND(ID_FILE_NEW, &CMFCArkanoidView::NewGame)
	ON_COMMAND(ID_KEYBOARDSPACE, &CMFCArkanoidView::PauseGame)
END_MESSAGE_MAP()

// CMFCArkanoidView construction/destruction

CMFCArkanoidView::CMFCArkanoidView() noexcept
{
	// TODO: add construction code here

}

CMFCArkanoidView::~CMFCArkanoidView()
{
}

// Code For Pre Creation of the window, this is empty as all the code is executed once the window is drawn to account for the window size
BOOL CMFCArkanoidView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

// CMFCArkanoidView drawing
// this is the Drawing Method, It contains all the code calculating the drawing, it is reexecuted whenever the timer times out.
void CMFCArkanoidView::OnDraw(CDC* dc)
{
	CusMemDC pDC(dc); // this is a custom frame buffer, removes the flickering 

	// This sets up the document in the Required format
	CMFCArkanoidDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;
	//This Assigns the current Screen size in this iteration to the rectangle Screen
	CWnd* Res = this->GetParent();
	CRect Screen;
	Res->GetWindowRect(&Screen);

	//start the timer to refresh the screen every 5ms
	SetTimer(1, 5, NULL);

	//define the BlockWidth and Bock Height in this drawing
	int BlockWidth = (Screen.Width()) / Columns;
	int BlockHeight = 60 / Rows;

	//Draw the Ball in its current position and then move the ball. This means we are calculating the next visable change in the objects
	TheBall.Draw(pDC);
	TheBall.MoveBall();

	//Declare the Game area, this is the area of the screen where the game takes place, we remove the bottom 100pixels for the score
	CRect GameArea(0, 0, Screen.Width(), Screen.Height()-100);
	
	//Check if the base of the ball exits the game area, if it does then show the game over Prompt
	if (!PtInRect(GameArea, TheBall.Bottom()))
	{
		GameOverDialog GameOver;
		GameOver.setScore(Score);
		TheBall.Stop(CPoint(CPoint(Screen.Width() / 2, Screen.Height() / 2)));
		if (GameOver.DoModal() == IDOK) {
			NewGame();
		};
	}
	//Check if the Ball is touching the sides of the Game Area if so, Bounce
	if (!PtInRect(GameArea, TheBall.Top()))
	{
		TheBall.BounceBall(false);
	}
	if (!PtInRect(GameArea, TheBall.Right()) || !PtInRect(GameArea, TheBall.Left()))
	{
		TheBall.BounceBall(true);
	}
	// For each of the blocks that is spawned, Update the size and location of the block
	//then check if the Ball has collided, if so then bounce the ball in its respective direction
	for (int x = 0; x < Columns; x++) {
		for (int y = 0; y < Rows; y++) {
			Blocks[x][y].UpdateSize(Screen.Width() / Columns, (120 / Rows), x, y);
			if (Blocks[x][y].active) {
				if (PtInRect(Blocks[x][y].BlockLocation, TheBall.Top()) || PtInRect(Blocks[x][y].BlockLocation, TheBall.Bottom()))
				{
					Score += pow(Blocks[x][y].Hits, 3);
					Blocks[x][y].hitBlock();
					TheBall.BounceBall(false);
				}
				if (PtInRect(Blocks[x][y].BlockLocation, TheBall.Left()) || PtInRect(Blocks[x][y].BlockLocation, TheBall.Right()))
				{
					Score += pow(Blocks[x][y].Hits, 3);
					Blocks[x][y].hitBlock();
					TheBall.BounceBall(true);
				}
				Blocks[x][y].Draw(pDC);
			}

		};
	};
	// Draw the paddle and check for a collision, if its collided, bounce
	ThePaddle.Draw(pDC);
	if (PtInRect(ThePaddle.Block(), TheBall.Bottom()))
	{
		TheBall.BounceBall(false);
	};
	// Set the area for the score and print the score in that rectangle
	CRect ScoreRect(0, Screen.Height() -85, Screen.Width(), Screen.Height());
	CString ScoreText;
	ScoreText.Format(_T("%i"), Score);
	pDC->DrawText(ScoreText, ScoreRect, DT_CENTER);

}


// CMFCArkanoidView diagnostics

#ifdef _DEBUG
void CMFCArkanoidView::AssertValid() const
{
	CView::AssertValid();
}

void CMFCArkanoidView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMFCArkanoidDoc* CMFCArkanoidView::GetDocument() const // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMFCArkanoidDoc)));
	return (CMFCArkanoidDoc*)m_pDocument;
}
#endif //_DEBUG

void CMFCArkanoidView::NewGame() {
	
	//Make The Bricks in a temporary file and overwrite the blocks
	std::vector<std::vector<Brick>> tmpBlocks;
	for (int x = 0; x < Columns; x++) {
		std::vector<Brick> Row;
		for (int y = 0; y < Rows; y++) {
			Brick tmp((Screen.Width() / Columns), (120 / Rows), x, y);
			Row.push_back(tmp);
		};
		tmpBlocks.push_back(Row);
	};
	Blocks = tmpBlocks;
	//set the score to 0
	Score = 0;
	//Set the Location to the Center Point and Launch the Ball 
	TheBall.Location = CPoint(Screen.Width() / 2, Screen.Height() / 2);
	TheBall.Go(BallSpeed);
}

// CMFCArkanoidView message handlers


void CMFCArkanoidView::OnTimer(UINT_PTR nIDEvent)
{
	// When the timer expires Refresh the screen
	UpdateData(FALSE);

	Invalidate();
	CView::OnTimer(nIDEvent);
}


BOOL CMFCArkanoidView::OnEraseBkgnd(CDC* pDC)
{
	//Dont Refresh the background

	return false;
}


void CMFCArkanoidView::OnMouseMove(UINT nFlags, CPoint point) // Event Handler for mouse Movement
{
// Get the point where the cursor is and store it as P
	CPoint p;
	GetCursorPos(&p);
	ScreenToClient(&p);

	//Update the X position of the paddle to the same as the mouse
	ThePaddle.UpdateLocation(p);
	CView::OnMouseMove(nFlags, point);
}

//
int CMFCArkanoidView::OnCreate(LPCREATESTRUCT lpCreateStruct) // Event Handler for post window creation
{
	if (CView::OnCreate(lpCreateStruct) == -1)
		return -1;
	//Store the window Size as Screen
	CWnd* Res = this->GetParent();
	Res->GetWindowRect(&Screen);

	//Start Random Number Seed
	srand((unsigned)time(NULL));
	
	//Create the Ball and Paddle Objects
	TheBall = Ball(BallSpeed, -BallSpeed, CPoint(Screen.Width() / 2, Screen.Height() / 2));
	ThePaddle = Paddle(150, CPoint(Screen.Width()/2, Screen.Height()-100));
	//Use the New Game Method to start a new game
	NewGame();

	return 0;
}


void CMFCArkanoidView::OnKeyboardleft() // Event Handler for left keyboard button 
{
	// When Pressed move the paddle 20 pixels left
	ThePaddle.UpdateLocation(-20);
}


void CMFCArkanoidView::OnKeyboardright() // Event Handler for Right Keyboard Button
{
	// When Pressed move the paddle 20 pixels right
	ThePaddle.UpdateLocation(20);
}


void CMFCArkanoidView::OnFileSettings() // Event Handler for settings button
{
	//Create Settings Screen Item
	Settings SetScreen;
	// Set the Variables to match the current System Variables
	SetScreen.BallSpeed1 = BallSpeed;
	SetScreen.Column = Columns;
	SetScreen.Row = Rows;
	SetScreen.isBlackPaddle = ThePaddle.BlackPaddle;
	// Make the Screen Appear, On exit Update the Variables
	if (SetScreen.DoModal() == IDOK)
	{
		if (Rows != SetScreen.Row && Columns != SetScreen.Column)
		{
			Rows = SetScreen.Row;
			Columns = SetScreen.Column;
			NewGame();
		}
		BallSpeed = SetScreen.BallSpeed1;
		TheBall.Velocity[0] /= abs(TheBall.Velocity[0]);
		TheBall.Velocity[1] /= abs(TheBall.Velocity[1]);
		TheBall.Velocity[0] *= BallSpeed;
		TheBall.Velocity[1] *= BallSpeed;
		ThePaddle.BlackPaddle = SetScreen.isBlackPaddle;

	}
}


void CMFCArkanoidView::PauseGame() //Event Handler for SpaceBar
{
	PausedState Pause; //Create Paused Dialog
	//Stop the ball where it is
	TheBall.Stop(TheBall.Location);
	if (Pause.DoModal() == IDOK)
	{
		TheBall.Go(BallSpeed); // when Continue is clicked resume the balls motion.
	}

}
