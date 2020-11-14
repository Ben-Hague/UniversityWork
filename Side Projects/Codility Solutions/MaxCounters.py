def solution(N, A):
    # write your code in Python 3.6
    Counters =[0]*N
    cMax = 0
    lMax = 0
    if len(A) ==0:
        return Counters
    for M in A:
        if M==N+1:
            lMax = cMax
        else:
            if Counters[M-1] < lMax:
                Counters[M-1] = lMax+1
            else:
                Counters[M-1]+=1
                
            if Counters[M-1]>cMax: cMax=Counters[M-1]
    for i in range(0,N):
        if Counters[i]<lMax:
            Counters[i] = lMax
        
    return Counters
