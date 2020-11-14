import math
def solution(X, Y, D):
    # write your code in Python 3.6
    xy = Y-X;
    if xy == 0: return 0
    jumps = math.ceil(xy/D)
    return jumps
