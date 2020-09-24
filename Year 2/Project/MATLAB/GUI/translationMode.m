function varargout = translationMode(varargin)
% TRANSLATIONMODE MATLAB code for translationMode.fig
%      TRANSLATIONMODE, by itself, creates a new TRANSLATIONMODE or raises the existing
%      singleton*.
%
%      H = TRANSLATIONMODE returns the handle to a new TRANSLATIONMODE or the handle to
%      the existing singleton*.
%
%      TRANSLATIONMODE('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in TRANSLATIONMODE.M with the given input arguments.
%
%      TRANSLATIONMODE('Property','Value',...) creates a new TRANSLATIONMODE or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before translationMode_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to translationMode_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help translationMode

% Last Modified by GUIDE v2.5 07-Mar-2018 12:41:01

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @translationMode_OpeningFcn, ...
                   'gui_OutputFcn',  @translationMode_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before translationMode is made visible.
function translationMode_OpeningFcn(hObject, eventdata, handles, varargin)
global vid;
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to translationMode (see VARARGIN)

% Choose default command line output for translationMode
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);
vid = videoinput('kinect',1,'BGR_1920x1080');
axes(handles.axes1);
himage = image(zeros(1920,1080,3),'Parent',handles.axes1)
preview(vid, himage)

% UIWAIT makes translationMode wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = translationMode_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global Model
disp("record")
run(Model)
% Data = RecordGesture(12);
% Gesture = Model.predictFcn(Data);
% Word = findWord(Gesture);
% I = imread(strcat(Word,'.png'));
% axes(handles.axes2);
% imshow(I);
 
 

% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
close('translationMode')
MainWindow;


% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
