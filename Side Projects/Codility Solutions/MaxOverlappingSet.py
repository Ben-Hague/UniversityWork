def solution(A, B):
    if len(A) < 1:
        return 0
     
    count = 1
    pend = B[0]
     
    for i in range(1, len(A)):
        if A[i] > pend:
            count += 1
            pend = B[i]
    return count
