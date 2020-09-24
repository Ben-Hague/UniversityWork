
// MFCArkanoidView.h : interface of the CMFCArkanoidView class
//

#pragma once


class CMFCArkanoidView : public CView
{
protected: // create from serialization only
	CMFCArkanoidView() noexcept;
	DECLARE_DYNCREATE(CMFCArkanoidView)

// Attributes
public:
	CMFCArkanoidDoc* GetDocument() const;


// Operations
public:
	void NewGame();
// Overrides
public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:

// Implementation
public:
	virtual ~CMFCArkanoidView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnTimer(UINT_PTR nIDEvent);
	afx_msg BOOL OnEraseBkgnd(CDC* pDC);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);
	afx_msg int OnCreate(LPCREATESTRUCT lpCreateStruct);
	afx_msg void OnKeyboardleft();
	afx_msg void OnKeyboardright();
	afx_msg void OnFileSettings();
	afx_msg void PauseGame();
};

#ifndef _DEBUG  // debug version in MFCArkanoidView.cpp
inline CMFCArkanoidDoc* CMFCArkanoidView::GetDocument() const
   { return reinterpret_cast<CMFCArkanoidDoc*>(m_pDocument); }
#endif

