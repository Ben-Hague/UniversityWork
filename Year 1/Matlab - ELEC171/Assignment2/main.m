wall_distance = [10,20];
wall_height = [5,3];
%part 3
angles = 0.5:0.5:89; % create a list of angles from 0.5 to 89 with 0.5 spacing
MaxV = 20; % declare maximum velocity at 20
horizontalPosition = arrayfun(@(theta) wallPath(MaxV, theta,wall_distance,wall_height),angles);% run the wallPath function for each angle and store the result as horizontalPosition
%part 4
figure(1); %load figure 1
plot(angles, horizontalPosition,'o'); %plot the angles against the horizontal position
xlabel('angle (degrees)');
ylabel('Final Postion (m)');% add labels to the graph
%part 5
soloution_i = [angles(find(horizontalPosition ==  max(horizontalPosition))), MaxV];%find the maximum distance and its corrisponding angle

%part 6
Distances = NaN(80,89); % create empty array 89 by 80
Angles = repmat((1:89), 80,1); % repeat the angles to the same dimentions 
Speeds = repmat((0.25:0.25:20), 89,1)'; % repeat the speeds to the same dimentions
for i = 1:80 % for each speed from 0-20 in steps of 0.25 calculate the final distance from angles 0-89 and store this in the distances array
    Distances(i,:) = arrayfun(@(theta) wallPath((0.25*i), theta,wall_distance,wall_height),1:89); 
end
%part 7
IsBetween = (Distances >10 & Distances<20);
Location  = find(IsBetween, 1);
soloution_ii = [Angles(Location),Speeds(Location)];
%find the smallest angle which lands between  the two walls
%part 8
IsOver = (Distances'>24);
Location  = find(IsOver, 1);
a = Angles';
s = Speeds';
soloution_iii = [a(Location),s(Location)];
%find the lowest speed which clears both walls

%part 9 
soloutions = [soloution_i;soloution_ii;soloution_iii];
%create an array for the soloutions 
%part 10
final = soloutions; % create the final array
final(:,3) = NaN;
final(:,4) = NaN; % add 2 empty collums 
results = NaN(3,2);
for i = 1:3
    [x_final, t_final] = wallPath(soloutions(i+3),soloutions(i) , wall_distance,wall_height);
    results(i) = x_final;
    results(i+3) = t_final; % create an array called results containing the distance and time for the soloutions
end
final(:,3) = results(:,1); % add each collum of results to the final array
final(:,4) = results(:,2);
%part 11
figure(2); % start figure 2
hold on; % allow multyiple lines to be drawn
plot([0,45],[0,0], 'k', 'LineWidth',3); 
plot([10,10],[0,5],'k','LineWidth',3);
plot([20,20],[0,3],'k','LineWidth',3);%  plot the ground and the 2 walls
C = ['r','g','b']; % set the colours
for i =1:3
    t = 0:0.01:final(i,4);%get the times from 0seconds till landing with 0.01 second intervals 
    v = final(i,2); %get the velocity of the soloution
    theta = final(i,1); % get the angle of the soloution
    place = computeTrajectory(v,theta,t); %calculate the trajectory
    fig1(i) = plot(place(:,1), place(:,2), C(i));% draw the line as fig (i)
end
xlabel('Distance (m)');
ylabel('Height  (m)'); % label the graph
legend([fig1(1), fig1(2), fig1(3)],'Soloution i (Max Distance)','Soloution ii (Minimum angle landing between walls) ','Soloution iii (Minimum speed clearing both walls)')
% produce a legend.