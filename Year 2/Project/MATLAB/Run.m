 function [Word] = Run(Model)
%Record the Gesture, Process it and feed it into a specified model,
%Outputs the word relating to the gesture
%Reset Image Aquisition Toolbox
imaqreset
disp("record")
% Record the Gesture and reference it to an unused Gesture Number, Store
% this data in the variable Data
Data = RecordGesture(12);
% Predict the gesture from the Data input
Gesture = Model.predictFcn(Data);
% Find the word which relates to the gesture
Word = findWord(Gesture);
% print the word to the console and display its corresponding image showing the gesture. 
disp(Word);
pic = imread(strcat(Word,'.png'));
image(pic);
 end