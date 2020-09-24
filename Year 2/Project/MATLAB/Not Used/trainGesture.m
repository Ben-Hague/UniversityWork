function [Model] = trainGesture(Gesture)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
    global TrainingData
    TrainingData = [TrainingData;RecordGesture(Gesture)]
    Model = trainClassifier(TrainingData);
end

