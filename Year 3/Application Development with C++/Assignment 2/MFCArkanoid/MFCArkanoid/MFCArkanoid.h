
// MFCArkanoid.h : main header file for the MFCArkanoid application
//
#pragma once

#ifndef __AFXWIN_H__
	#error "include 'stdafx.h' before including this file for PCH"
#endif

#include "resource.h"       // main symbols


// CMFCArkanoidApp:
// See MFCArkanoid.cpp for the implementation of this class
//

class CMFCArkanoidApp : public CWinApp
{
public:
	CMFCArkanoidApp() noexcept;


// Overrides
public:
	virtual BOOL InitInstance();
	virtual int ExitInstance();

// Implementation
	afx_msg void OnAppAbout();
	DECLARE_MESSAGE_MAP()
};

extern CMFCArkanoidApp theApp;
