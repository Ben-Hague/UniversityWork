%Part 1
rng(171172);
X = randn(2,1000); % generate a matrix of random numbers based on the seed
figure(1);
plot(X(1,:),X(2,:), 'o') % plot the graph on fig 1


%Part 2
p = sum((X(2,:)>=0).*(X(1,:)>= 0))*100/numel(X(2,:));  % calculate percentage of points in positive quadrant

%Part 3
c =(cumsum((X(2,:)>=0).*(X(1,:)>= 0))./cumsum(ones(size(X)),2));
f =  c(1,:) % create a cumulative chance of the next didgit being in the positive quadrant

%Part 4
figure(2);
plot(f,'ob');
hold on ; 
plot(1:1000, ones(1000)*1/4, 'Color', 'k');
% create a figure and plot the points on it then a line at y = 1/4
title('Points within positive quadrant');
xlabel('Number of points');
ylabel('Running average');
hold off ;

%Part 5
N1 = 100*(f-0.25)/0.25
errs = [mean(N1(1:10)),mean(N1(1:50)),mean(N1(1:100)),mean(N1(1:500)),mean(N1(1:1000))]
% create a list of normalised percentages at certain points

%Part 6

figure(3);
matrix = ((X(2,1:500)>=0).*(X(1,1:500)>= 0));
invertedMatrix = ((matrix-1).*-1);
%matrixswith the positive values as true
%set the values of the each unwanted values to zero
L1 = (X(1,1:500).* matrix);
L2 = (X(2,1:500).* matrix);
L3 = (X(1,1:500).* invertedMatrix);
L4 = (X(2,1:500).* invertedMatrix);

% remove zero vales from array
L1(L1==0) = [];
L2(L2==0) = [];
L3(L3==0) = [];
L4(L4==0) = [];
hold on;

plot(L1,L2, '+r'); % plot positives
plot(L3,L4, 'sb'); % plot negatives


