def solution(K, A):
    # write your code in Python 3.6
    if len(A)<1:
        return 0
        
    count=0
    cLength=0
    for i in A:
        cLength+=i
        if cLength>=K:
            cLength = 0
            count +=1
            
    return count
