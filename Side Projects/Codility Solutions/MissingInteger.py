def solution(A):
    # write your code in Python 3.6
    List = sorted(set(A))
    currentValue=1
    for X in List:
        if X>0:
            if X !=currentValue:
                return currentValue
            else: currentValue+=1
    return currentValue
