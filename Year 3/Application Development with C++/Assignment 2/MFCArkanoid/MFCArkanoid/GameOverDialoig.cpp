// GameOverDialoig.cpp : implementation file
//

#include "stdafx.h"
#include "MFCArkanoid.h"
#include "GameOverDialoig.h"
#include "afxdialogex.h"
#include <string>

// GameOverDialoig dialog

IMPLEMENT_DYNAMIC(GameOverDialog, CDialogEx)

GameOverDialog::GameOverDialog(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG1, pParent)
	, ScoreString(_T(""))
{
	score = 0;
}

GameOverDialog::~GameOverDialog()
{
}

void GameOverDialog::setScore(int Score)
{
	score = Score;
	std::string str ;
	ScoreString = std::to_string(Score).c_str();
}

void GameOverDialog::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, SCORETEXT, TheScore);
	DDX_Text(pDX, SCORETEXT, ScoreString);
}

BEGIN_MESSAGE_MAP(GameOverDialog, CDialogEx)
	//ON_EN_CHANGE(IDC_SCORE, &GameOverDialog::OnEnChangeScore)
	ON_BN_CLICKED(IDOK, &GameOverDialog::OnBnClickedOk)
	ON_STN_CLICKED(SCORETEXT, &GameOverDialog::OnStnClickedScoretext)
	ON_BN_CLICKED(ID_APP_EXIT, &GameOverDialog::OnBnClickedAppExit)
END_MESSAGE_MAP()


// GameOverDialoig message handlers

void GameOverDialog::OnEnChangeScore()
{
	// TODO:  If this is a RICHEDIT control, the control will not
	// send this notification unless you override the CDialogEx::OnInitDialog()
	// function and call CRichEditCtrl().SetEventMask()
	// with the ENM_CHANGE flag ORed into the mask.

	// TODO:  Add your control notification handler code here
}


void GameOverDialog::OnBnClickedOk()
{
	// TODO: Add your control notification handler code here
	CDialogEx::OnOK();
}


void GameOverDialog::OnStnClickedScoretext()
{

	// TODO: Add your control notification handler code here
}


void GameOverDialog::OnBnClickedAppExit()
{
	// TODO: Add your control notification handler code here
}
