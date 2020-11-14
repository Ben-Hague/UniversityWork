def solution(A):
    # write your code in Python 3.6
    rSum=0
    lSum=sum(A)
    ans = 0xFFFFFFFF # MAX 32 bit number in hex
    for i in A[:-1]:
        rSum +=i
        lSum -=i
        cAns = abs(rSum-lSum)
        if cAns<ans:
            ans = cAns
    return ans
