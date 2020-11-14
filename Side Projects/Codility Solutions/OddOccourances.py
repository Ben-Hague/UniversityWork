def solution(A):
    missing_int = 0
    for value in A:
        missing_int ^= value
    return missing_int
