pause(2)
disp("record")
Data = RecordGesture(NaN);
Gesture = TestModel.predictFcn(Data);
disp(findWord(Gesture))
% inputText = input('right or wrong')
% if inputText == 1
%     Data.Gesture(1) = Gesture;
%     TestModel = addTrainingData(TestModel,Data);
% end