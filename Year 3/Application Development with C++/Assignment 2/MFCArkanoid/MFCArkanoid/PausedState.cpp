// PausedState.cpp : implementation file
//

#include "stdafx.h"
#include "MFCArkanoid.h"
#include "PausedState.h"
#include "afxdialogex.h"


// PausedState dialog

IMPLEMENT_DYNAMIC(PausedState, CDialogEx)

PausedState::PausedState(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG3, pParent)
{

}

PausedState::~PausedState()
{
}

void PausedState::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(PausedState, CDialogEx)
END_MESSAGE_MAP()


// PausedState message handlers
