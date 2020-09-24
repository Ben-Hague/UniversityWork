function Output =  RecordGesture(Gesture)
    global Depth 
    %setting the ammount of frames per gesture,
    %this is more logical then
    %using a set period of time
    frames = 30;
    %Create placeholder elements for each of the joint coordinates
    Spine = NaN(frames,3);
    Shoulder_Center = NaN(frames,3);
    Head = NaN(frames,3);
    Shoulder_Left = NaN(frames,3);
    Elbow_Left = NaN(frames,3);
    Wrist_Left = NaN(frames,3);
    Hand_Left = NaN(frames,3);
    Shoulder_Right = NaN(frames,3);
    Elbow_Right = NaN(frames,3);
    Wrist_Right = NaN(frames,3);
    Hand_Right =NaN(frames,3);
    SpineShoulder =NaN(frames,3);
    HandTipLeft =NaN(frames,3);
    ThumbLeft =NaN(frames,3);
    HandTipRight =NaN(frames,3);
    ThumbRight =NaN(frames,3);
    %Create input device from Depth camera
    Depth = videoinput('kinect',2,'Depth_512x424');
    %Configure the trigger settings
    triggerconfig(Depth, 'manual');
    Depth.FramesPerTrigger = 30;
    %set up the camera to allow us to acess the body tracking data  
    src = getselectedsource(Depth);
    src.EnableBodyTracking = 'on';
    %Start the depth camera
    start(Depth);
    %Trigger the camera to the buffer
    trigger(Depth);
    %Read the data from the buffer and stop the camera 
    [frame, ts, metaData] = getdata(Depth);
    stop(Depth);
    %Cleanup, make the code run smoother
    clearvars frame ts Depth src 
    %Find the location of the first body, Needs to be changed to closest.
    Location = find(metaData(1).IsBodyTracked);
    % for each of the frames
    for i = (1:frames);
        %extract the relevant data
        all = metaData(i).JointPositions;
        Data = all(:,:,Location(1));
        %Store the data in its appropriate matrix
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
        SpineShoulder(i,:) = Data(21,:);
        HandTipLeft(i,:) = Data(22,:);
        ThumbLeft(i,:) = Data(23,:);
        HandTipRight(i,:) = Data(24,:);
        ThumbRight(i,:) = Data(25,:);
    end;
    %create a matrix with all the data in the correct order
    Dataset = [Spine(:,1),Spine(:,2),Spine(:,3),Shoulder_Center(:,1),Shoulder_Center(:,2),Shoulder_Center(:,3),Head(:,1),Head(:,2),Head(:,3),Shoulder_Left(:,1),Shoulder_Left(:,2),Shoulder_Left(:,3),Elbow_Left(:,1),Elbow_Left(:,2),Elbow_Left(:,3),Wrist_Left(:,1),Wrist_Left(:,2),Wrist_Left(:,3),Hand_Left(:,1),Hand_Left(:,2),Hand_Left(:,3),Shoulder_Right(:,1),Shoulder_Right(:,2),Shoulder_Right(:,3),Elbow_Right(:,1),Elbow_Right(:,2),Elbow_Right(:,3),Wrist_Right(:,1),Wrist_Right(:,2),Wrist_Right(:,3),Hand_Right(:,1),Hand_Right(:,2),Hand_Right(:,3),SpineShoulder(:,1),SpineShoulder(:,2),SpineShoulder(:,3),HandTipLeft(:,1),HandTipLeft(:,2),HandTipLeft(:,3),ThumbLeft(:,1),ThumbLeft(:,2),ThumbLeft(:,3),HandTipRight(:,1),HandTipRight(:,2),HandTipRight(:,3),ThumbRight(:,1),ThumbRight(:,2),ThumbRight(:,3)];
    %clear the workspace, Increases speed
    clearvars -except Dataset Gesture
    %calculate Mean, Standard Deviation and Principal Component Analasis
    Mean = mean(Dataset,1);
    Sdev = std(Dataset,[],1);
    [~,Pca] = pca(Dataset','NumComponents',1);
    %Construct the output
    MOutput = NaN(1,145);
    MOutput(145) = Gesture;
    MOutput(1:48) = Mean;
    MOutput(49:96) = Sdev;
    MOutput(97:144) = Pca';
    Output = array2table(MOutput,'VariableNames',{'SpinexMean','SpineyMean','SpinezMean','Shoulder_CenterxMean','Shoulder_CenteryMean','Shoulder_CenterzMean','HeadxMean','HeadyMean','HeadzMean','Shoulder_LeftxMean','Shoulder_LeftyMean','Shoulder_LeftzMean','Elbow_LeftxMean','Elbow_LeftyMean','Elbow_LeftzMean','Wrist_LeftxMean','Wrist_LeftyMean','Wrist_LeftzMean','Hand_LeftxMean','Hand_LeftyMean','Hand_LeftzMean','Shoulder_RightxMean','Shoulder_RightyMean','Shoulder_RightzMean','Elbow_RightxMean','Elbow_RightyMean','Elbow_RightzMean','Wrist_RightxMean','Wrist_RightyMean','Wrist_RightzMean','Hand_RightxMean','Hand_RightyMean','Hand_RightzMean','SpineShoulderxMean','SpineShoulderyMean','SpineShoulderzMean','HandTipLeftxMean','HandTipLeftyMean','HandTipLeftzMean','ThumbLeftxMean','ThumbLeftyMean','ThumbLeftzMean','HandTipRightxMean','HandTipRightyMean','HandTipRightzMean','ThumbRightxMean','ThumbRightyMean','ThumbRightzMean','SpinexStd','SpineyStd','SpinezStd','Shoulder_CenterxStd','Shoulder_CenteryStd','Shoulder_CenterzStd','HeadxStd','HeadyStd','HeadzStd','Shoulder_LeftxStd','Shoulder_LeftyStd','Shoulder_LeftzStd','Elbow_LeftxStd','Elbow_LeftyStd','Elbow_LeftzStd','Wrist_LeftxStd','Wrist_LeftyStd','Wrist_LeftzStd','Hand_LeftxStd','Hand_LeftyStd','Hand_LeftzStd','Shoulder_RightxStd','Shoulder_RightyStd','Shoulder_RightzStd','Elbow_RightxStd','Elbow_RightyStd','Elbow_RightzStd','Wrist_RightxStd','Wrist_RightyStd','Wrist_RightzStd','Hand_RightxStd','Hand_RightyStd','Hand_RightzStd','SpineShoulderxStd','SpineShoulderyStd','SpineShoulderzStd','HandTipLeftxStd','HandTipLeftyStd','HandTipLeftzStd','ThumbLeftxStd','ThumbLeftyStd','ThumbLeftzStd','HandTipRightxStd','HandTipRightyStd','HandTipRightzStd','ThumbRightxStd','ThumbRightyStd','ThumbRightzStd','SpinexPca','SpineyPca','SpinezPca','Shoulder_CenterxPca','Shoulder_CenteryPca','Shoulder_CenterzPca','HeadxPca','HeadyPca','HeadzPca','Shoulder_LeftxPca','Shoulder_LeftyPca','Shoulder_LeftzPca','Elbow_LeftxPca','Elbow_LeftyPca','Elbow_LeftzPca','Wrist_LeftxPca','Wrist_LeftyPca','Wrist_LeftzPca','Hand_LeftxPca','Hand_LeftyPca','Hand_LeftzPca','Shoulder_RightxPca','Shoulder_RightyPca','Shoulder_RightzPca','Elbow_RightxPca','Elbow_RightyPca','Elbow_RightzPca','Wrist_RightxPca','Wrist_RightyPca','Wrist_RightzPca','Hand_RightxPca','Hand_RightyPca','Hand_RightzPca','SpineShoulderxPca','SpineShoulderyPca','SpineShoulderzPca','HandTipLeftxPca','HandTipLeftyPca','HandTipLeftzPca','ThumbLeftxPca','ThumbLeftyPca','ThumbLeftzPca','HandTipRightxPca','HandTipRightyPca','HandTipRightzPca','ThumbRightxPca','ThumbRightyPca','ThumbRightzPca','Gesture'});
    clearvars -except Output
    
  end
