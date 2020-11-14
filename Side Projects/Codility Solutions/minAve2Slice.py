def solution(A):
    # write your ode in Python 3.6
    CS = 0xffffffff
    L = 0
    for i in range(0,len(A)):
        C2 = 0xffffffff
        C3 = 0xffffffff
        if i+1<len(A):
            C2 = (A[i] + A[i+1])/2
        if i+2<len(A):
            C3 = (A[i]+A[i+1]+A[i+2])/3
        if C2<C3:
            if CS>C2:
                CS=C2
                L=i
        else:
            if CS>C3:
                CS=C3
                L=i
    return L
