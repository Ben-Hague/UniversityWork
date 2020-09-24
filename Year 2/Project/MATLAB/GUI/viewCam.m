function viewCam()
%function allowing viewing of  colour camera useful for framing
    vid = videoinput('kinect',1,'BGR_1920x1080');
    preview(vid);
end
