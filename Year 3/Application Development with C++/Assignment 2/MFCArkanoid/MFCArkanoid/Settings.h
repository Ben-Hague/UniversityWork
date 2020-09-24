#pragma once


// Settings dialog

class Settings : public CDialogEx
{
	DECLARE_DYNAMIC(Settings)

public:
	Settings(CWnd* pParent = nullptr);   // standard constructor
	virtual ~Settings();

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG2 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
public:
	int BallSpeed1;
	int Column;
	int Row;
	bool isBlackPaddle;
	afx_msg void BallSpeedSlow();
	afx_msg void BallSpeedFast();
	afx_msg void GridSizeSmall();
	afx_msg void GridSizeBig();
	afx_msg void BlackPaddle();
	afx_msg void GreenPaddle();
};
