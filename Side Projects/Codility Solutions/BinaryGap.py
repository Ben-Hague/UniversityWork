def solution(N):
    # write your code in Python 3.6
    longestString=0
    currentString=0
    for digit in bin(N)[2:]:
        if digit=='0':
            currentString+=1
        else:
            if (currentString>longestString):
                longestString=currentString
            currentString = 0
    return longestString
