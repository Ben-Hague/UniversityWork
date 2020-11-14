def solution(A, B, K):
    
    minVal = ((A + K -1 ) // K) * K
    
    if minVal>B:
        return 0;
    
    return (B - minVal)//K +1y
