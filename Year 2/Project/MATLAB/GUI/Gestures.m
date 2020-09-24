function varargout = Gestures(varargin)
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @Gestures_OpeningFcn, ...
                   'gui_OutputFcn',  @Gestures_OutputFcn, ...
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


% --- Executes just before Gestures is made visible.
function Gestures_OpeningFcn(hObject, eventdata, handles, varargin)
handles.output = hObject;
guidata(hObject, handles);

% --- Outputs from this function are returned to the command line.
function varargout = Gestures_OutputFcn(hObject, eventdata, handles) 
varargout{1} = handles.output;


% --- Name of gesture to add
function edit1_Callback(hObject, eventdata, handles)


% --- Executes during object creation, after setting all properties.
function edit1_CreateFcn(hObject, eventdata, handles)
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in pushbutton1. (The add button)
function pushbutton1_Callback(hObject, eventdata, handles)
data = get(handles.listbox1,'String');
newGestureName = get(handles.edit1,'String');
data{end+1} = newGestureName;
set(handles.listbox1,'String',data);

% --- Executes on selection change in listbox1.
function listbox1_Callback(hObject, eventdata, handles)


% --- Executes during object creation, after setting all properties.
function listbox1_CreateFcn(hObject, eventdata, handles)
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in pushbutton3. (Train)
function pushbutton3_Callback(hObject, eventdata, handles)
Recording;
gestureNames = get(handles.listbox1,'String');
global ind;
ind = get(handles.listbox1,'value');
close('Gestures');




% --- Executes on button press in pushbutton4. (Remove)
function pushbutton4_Callback(hObject, eventdata, handles)
selected = get(handles.listbox1,'value');
currentData = get(handles.listbox1,'String');
currentData(selected) = [];
disp(currentData)
set(handles.listbox1,'String', currentData);



% --- Executes on button press in pushbutton6.
function pushbutton6_Callback(hObject, eventdata, handles)
MainWindow;
close('Gestures')