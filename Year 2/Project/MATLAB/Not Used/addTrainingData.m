function [OutputModel] = addTrainingData(InputModel, Data);
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
    [OutputModel,~] = trainClassifier(Data);
end

