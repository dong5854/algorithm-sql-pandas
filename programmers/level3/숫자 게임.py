"""
숫자 게임

https://school.programmers.co.kr/learn/courses/30/lessons/12987
"""
def solution(A, B):
    sorted_A = sorted(A, reverse=True)
    sorted_B = sorted(B, reverse=True)
    score = 0
    for a in sorted_A:
        if sorted_B[0] > a:
            score += 1
            sorted_B.pop(0)
        else:
            sorted_B.pop(-1)
    return score