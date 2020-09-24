#pragma once


// GameOverDialoig dialog

class GameOverDialog : public CDialogEx
{
	DECLARE_DYNAMIC(GameOverDialog)

public:
	int score;
	GameOverDialog(CWnd* pParent = nullptr);// standard constructor
	virtual ~GameOverDialog();
	void setScore(int Score);

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG1 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnEnChangeScore();
	afx_msg void OnBnClickedOk();
	afx_msg void OnStnClickedScoretext();
	CStatic TheScore;
	afx_msg void OnBnClickedAppExit();
	CString ScoreString;
};
