def solution(S, P, Q):
    # write your code in Python 3.6
    Results = [0]*len(P)
    
    for M in range(0,len(P)):
        if P[M]<Q[M]:
            Selection = S[P[M]:Q[M]+1]
        else: 
            Selection = S[P[M]]
        
        if 'A' in Selection:        
            Results[M] = 1
        else: 
            if 'C' in Selection:
                Results[M] = 2
            else:
                if 'G' in Selection:
                    Results[M] = 3
                else: 
                    if 'T' in Selection:
                        Results[M] = 4

    return(Results)
