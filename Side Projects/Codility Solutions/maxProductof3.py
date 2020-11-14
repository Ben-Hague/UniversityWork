def solution(A):
    List = sorted(A)
    Low = List[0]*List[1]*List[-1]
    High = List[-1]*List[-2]*List[-3]
    if Low>High:
        return Low
    return High
