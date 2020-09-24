function [Output] = predictGesture(Data,Model1,Model2,Model3,Model4)
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
Models(:,1) = Model1.predictFcn(Data)
Models(:,2) = Model2.predictFcn(Data)
Models(:,3) = Model3.predictFcn(Data)
Models(:,4) = Model4.predictFcn(Data)
Output = mode(Models,2)

end

