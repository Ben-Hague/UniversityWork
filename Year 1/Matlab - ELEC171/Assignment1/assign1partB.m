%save the data to current directory
filename=websave('assign1.mat','http://cgi.csc.liv.ac.uk/~ajbrockmeier/assign1.mat');
fprintf('Downloaded assign1.mat to %s\n',filename);
%load the data
load('assign1.mat','date_array','data_vals');
% date_array is a 365 by 3 matrix
% Columns correspond to year, month, day
% data_vals is a 365 by 5 matrix
% The first three columns correspond to:
%MeanTemperatureC, MinTemperatureC, MaxTemperatureC
MeanTemp =  [NaN NaN NaN NaN data_vals(:,1).' NaN  NaN]
MeanTemp = reshape(MeanTemp,7,53).'
WeeklyMean  = mean(MeanTemp,2, 'omitnan')

MinTemp =  [NaN NaN NaN NaN data_vals(:,2).' NaN  NaN]
MinTemp = reshape(MinTemp,7,53).'
WeeklyMin  = mean(MinTemp,2, 'omitnan') 

MaxTemp =  [NaN NaN NaN NaN data_vals(:,3).' NaN  NaN]
MaxTemp = reshape(MaxTemp,7,53).'
WeeklyMax  = mean(MaxTemp,2, 'omitnan')

figure(1),clf %create figure and clear it
h1=plot(1:53,WeeklyMean,'ko','markersize',8);
hold all  %allows you to plot more than one
h2=plot(1:53,WeeklyMin,'bv','markersize',8); % plot the weekly min max and averages 
h3=plot(1:53,WeeklyMax,'rs','markersize',8);
set(gca,'fontsize',12) %change font size
title('Mean weekly temperatures in Liverpool')
xlabel('Week of the Year')
ylabel('Temperature (C)')
legend([h3 h1 h2],'Average Weekly Max','Average Weekly Value','Average Weekly Minimum')

% make a date array
Date = flip(date_array(find(data_vals(:,3) ==  max(data_vals(:,3))),:))
