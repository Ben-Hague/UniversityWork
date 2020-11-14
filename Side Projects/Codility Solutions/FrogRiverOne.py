def solution(X, A):
    # write your code in Python 3.6
    if X == 0:
        return 0
    check = [0]*(X)
    filled = 0
    for i in range(0,len(A)):
        if check[A[i]-1]==0:
            check[A[i]-1] = 1
            filled+=1
            if filled == X:
                return i
    
    return -1

