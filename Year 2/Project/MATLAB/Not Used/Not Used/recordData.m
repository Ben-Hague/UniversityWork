function Output = RecordData() 
    Spine = NaN(90,3);
    Shoulder_Center = NaN(90,3);
    Head = NaN(90,3);
    Shoulder_Left = NaN(90,3);
    Elbow_Left = NaN(90,3);
    Wrist_Left = NaN(90,3);
    Hand_Left = NaN(90,3);
    Shoulder_Right = NaN(90,3);
    Elbow_Right = NaN(90,3);
    Wrist_Right = NaN(90,3);
    Hand_Right =NaN(90,3);
    SpineShoulder =NaN(90,3);
    HandTipLeft =NaN(90,3);
    ThumbLeft =NaN(90,3);
    HandTipRight =NaN(90,3);
    ThumbRight =NaN(90,3);
    Gesture = 1;
    for i = (1:90);

        all = metaData(i).JointWorldCoordinates;
        Data = all(:,:,1)
        Spine(i,:) = Data(2,:);
        Shoulder_Center(i,:) = Data(3,:);
        Head(i,:) = Data(4,:);
        Shoulder_Left(i,:) = Data(5,:);
        Elbow_Left(i,:) = Data(6,:);
        Wrist_Left(i,:) = Data(7,:);
        Hand_Left(i,:) = Data(8,:);
        Shoulder_Right(i,:) = Data(9,:);
        Elbow_Right(i,:) = Data(10,:);
        Wrist_Right(i,:) = Data(11,:);
        Hand_Right(i,:) = Data(12,:);
%         SpineShoulder(i,:) = Data(21,:);
%         HandTipLeft(i,:) = Data(22,:);
%         ThumbLeft(i,:) = Data(23,:);
%         HandTipRight(i,:) = Data(24,:);
%         ThumbRight(i,:) = Data(25,:);


    end;
    Dataset = [Spine(:,1),Spine(:,2),Spine(:,3),Shoulder_Center(:,1),Shoulder_Center(:,2),Shoulder_Center(:,3),Head(:,1),Head(:,2),Head(:,3),Shoulder_Left(:,1),Shoulder_Left(:,2),Shoulder_Left(:,3),Elbow_Left(:,1),Elbow_Left(:,2),Elbow_Left(:,3),Wrist_Left(:,1),Wrist_Left(:,2),Wrist_Left(:,3),Hand_Left(:,1),Hand_Left(:,2),Hand_Left(:,3),Shoulder_Right(:,1),Shoulder_Right(:,2),Shoulder_Right(:,3),Elbow_Right(:,1),Elbow_Right(:,2),Elbow_Right(:,3),Wrist_Right(:,1),Wrist_Right(:,2),Wrist_Right(:,3),Hand_Right(:,1),Hand_Right(:,2),Hand_Right(:,3)]
    Mean = mean(Dataset,1);
    Sdev = std(Dataset,[],1);
    [~,Pca] = pca(Dataset','NumComponents',1);
    Output = NaN(1,100);
    Output(1) = Gesture;
    Output(2:34) = Mean;
    Output(35:67) = Sdev;
    Output(68:100) = Pca';
    %clearvars -except Output Depth src voice vid
end
