// Settings.cpp : implementation file
//

#include "stdafx.h"
#include "MFCArkanoid.h"
#include "Settings.h"
#include "afxdialogex.h"


// Settings dialog

IMPLEMENT_DYNAMIC(Settings, CDialogEx)

Settings::Settings(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG2, pParent)
{
}

Settings::~Settings()
{
}

void Settings::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(Settings, CDialogEx)
	ON_BN_CLICKED(IDC_RADIO1, &Settings::BallSpeedSlow)
	ON_BN_CLICKED(IDC_RADIO2, &Settings::BallSpeedFast)
	ON_BN_CLICKED(IDC_RADIO3, &Settings::GridSizeSmall)
	ON_BN_CLICKED(IDC_RADIO4, &Settings::GridSizeBig)
	ON_BN_CLICKED(IDC_RADIO5, &Settings::BlackPaddle)
	ON_BN_CLICKED(IDC_RADIO6, &Settings::GreenPaddle)
END_MESSAGE_MAP()


// Settings message handlers



void Settings::BallSpeedSlow()
{
	BallSpeed1 = 2;
}

void Settings::BallSpeedFast()
{
	BallSpeed1 = 5;
}


void Settings::GridSizeSmall()
{
	Row = 3;
	Column = 10;
}


void Settings::GridSizeBig()
{
	Row = 5;
	Column = 20;
}


void Settings::BlackPaddle()
{
	isBlackPaddle = true;
}


void Settings::GreenPaddle()
{
	isBlackPaddle = false;
}
