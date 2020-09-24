function viewCam()
    vid = videoinput('kinect',1,'RGB_640x480');
    preview(vid);
end

function setup(angle)
    NET.addAssembly('System.Speech');
    voice = System.Speech.Synthesis.SpeechSynthesizer;
    Depth = videoinput('kinect',2,'Depth_640x480');
    triggerconfig(Depth, 'manual');
    Depth.FramesPerTrigger = 90;
    src = getselectedsource(Depth);
    src.TrackingMode = 'skeleton';
    src.SkeletonsToTrack = [1];
    src.CameraElevationAngle = angle
end
function [GestName, data] = record(GestName);
    Speak(voice, 'Preparing to trigger')
    pause(1)
    Speak(voice, 'triggering')
    start(Depth);
    trigger(Depth);
    [frame, ts, metaData] = getdata(Depth);
    stop(Depth);
    Speak(voice, 'Frames have been recorded')
    metaDataToExtractFrom = metaData; %Change to other gesture recording
    data = zeros(20,3,90);
    for i = 1:90
        frameData = metaDataToExtractFrom(i).JointWorldCoordinates(:,:,1);
            for y = 1:20
                for x = 1:3
                  data(y,x,i) = frameData(y,x);
                end
            end
    end
end