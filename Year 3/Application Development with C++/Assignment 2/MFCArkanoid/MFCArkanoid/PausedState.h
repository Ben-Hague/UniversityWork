#pragma once


// PausedState dialog

class PausedState : public CDialogEx
{
	DECLARE_DYNAMIC(PausedState)

public:
	PausedState(CWnd* pParent = nullptr);   // standard constructor
	virtual ~PausedState();

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG3 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
};
