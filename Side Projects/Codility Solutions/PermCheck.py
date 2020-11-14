def solution(A):
    cMax = max(A)
    if cMax != len(A):
        return 0
    if sorted(A) == list(range(1,cMax+1)):
        return 1
    else: return 0 
