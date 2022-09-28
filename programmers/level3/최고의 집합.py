"""
최고의 집합

https://school.programmers.co.kr/learn/courses/30/lessons/12938
"""
def solution(n, s):
    answer = []
    # 없는 경우
    if s < n:
        return [-1]
    
    val = s // n
    leftover = s % n
    
    answer = [val for _ in range(n)]
    
    for i in range(1, leftover+1):
        answer[n-i] += 1
    
    return answer