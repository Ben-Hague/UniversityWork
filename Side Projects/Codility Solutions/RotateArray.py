def solution(A, K):
    # write your code in Python 3.6
    for i in range(0,K):
        Result = [A[-1]] + A[0:-1] #maintain list datatype
        A = Result
    return A
