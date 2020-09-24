function xy = computeTrajectory( v,theta,t )
%computeTrajectory Calculate the path of a ball given its initial speed (v)
% and its angle (theta) at each time in the vector t
% Inputs:
%   v       (scalar)    initial speed  (meters/second)
%   theta   (scalar)    angle of release (degrees)
%   t       (vector)    times of interest (seconds)
% Output: 
%       xy  (2-column matrix, number of rows matches the number elements of t)
%           xy(:,1)     horizontal position (meters)
%           xy(:,2)     vertical position (meters)
    
    xy = NaN(numel(t),2); %create empty array of the right size
    xy(:,1) = v*cos((theta*pi)/180).*t; %calculate the horisontal distance
    xy(:,2) = (v*sin((theta*pi)/180).*t) + ((-9.8/2).*(t.^2)); % calculate the vertical distance
end

