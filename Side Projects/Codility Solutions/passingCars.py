def solution(A):
    totalWest = sum(A)
    cars = 0;
    for i in range(0,len(A)):
        if A[i] == 1:
            totalWest -=1
        if A[i] == 0:
            cars+= totalWest
        if cars>1000000000:
            return -1
    return cars
