function setup(angle)
    Depth = videoinput('kinect',2,'Depth_640x480');
    src = getselectedsource(Depth);
    src.CameraElevationAngle = angle
end
