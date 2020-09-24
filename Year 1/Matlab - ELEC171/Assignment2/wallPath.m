
function [x_final,t_final ] = wallPath(v,theta,wall_distance,wall_height)
%wallPath Computes where a ball’s trajectory ends given its initial speed (v)
% and angle (theta). There are walls in the path, the distance away and height
% of each wall are given by the third and fourth inputs
% Inputs:
%   v                   (scalar)    initial speed  (meters/second)
%   theta               (scalar)    angle of release (degrees)
%   wall_distance       (vector)    horizontal location of each wall (meters)
%   wall_height         (vector)    height of each wall (meters)
% Outputs:
%       x_final     (scalar)     final horizontal position (meters)
%       t_final     (scalar)     final time, at wall or landing, (seconds)

assert(isequal(size(wall_distance),size(wall_height)),...;
    'Wall specifications do not match dimensions.');
assert(isequal(numel(wall_distance),2),'There should be two walls.')


%Height at wall
Htime = v*sin((theta*pi)/180)/(0.5*9.8);
WallTime = wall_distance.*(1/(v*cos((theta*pi)/180)));
Height = computeTrajectory(v, theta, WallTime);
Height = Height(:,2)';
HV = v*cos((theta*pi)/180);

if all(Height > wall_height | Height < [0,0])
    x = Htime*HV;
    t = Htime;
elseif Height(1)<wall_height(1)
    x = wall_distance(1);
    t = WallTime(1);
elseif Height(2)<wall_height(2)
    x = wall_distance(2);
    t = WallTime(2);
end
x_final = x;
t_final = t;

end