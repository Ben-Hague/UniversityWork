stack = []  # declare the vairables at the start 
passes = 6
fails = 0

for i in range(1,7): #for each of the 6 values
    stack.append(input('Enter the mark for module '+str(i)+':')) # add the mark to the array
for i in stack: # for each mark in the array increment fails by one if <40
    if i<40:
        fails+=1
passes += - fails # passes = 6-fails
print 'Number of passes = ' +str(passes) # print number of passes
print 'Number of fails = ' +str(fails) # print number of fails
