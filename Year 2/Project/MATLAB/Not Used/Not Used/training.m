setup(10);
viewCam();
results = zeros(10,20,3,90)

for i = 1:10;
    results(i,:,:,:)= record(i);
    
end