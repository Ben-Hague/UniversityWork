function [Output] = AddRecord(Records,Data)
%Simple Function designed to combine multiple tables for the purpose of
%adding to the training data with less lines of code
    Output = [Records;Data];
end

