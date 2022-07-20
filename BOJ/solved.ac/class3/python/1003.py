"""
1003번
피보나치 함수

https://www.acmicpc.net/problem/1003
"""
# 다시 직접 해보기
import sys
zero = [1, 0, 1]
one = [0, 1, 1]

def solution(n):
    cur_len = len(zero)
    if n >= cur_len:
        for i in range(cur_len, n + 1):
            zero.append(zero[i-1] + zero[i-2])
            one.append(one[i-1] + one[i-2])
    print(zero[n], one[n])

N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    solution(int(sys.stdin.readline().rstrip()))






# # dp를 사용해서 푼다고 한다 해당 내용 공부 후 다시 해보기
# # https://itstory1592.tistory.com/34
# zero = [1, 0, 1]
# one = [0, 1, 1]

# def fibonacci(num):
#     length = len(zero)
#     if num >= length:
#         for i in range(length, num+1):
#             zero.append(zero[i-1] + zero[i-2])
#             one.append(one[i-1] + one[i-2])
#     print('{} {}'.format(zero[num], one[num]))

# T = int(input())
    
# for _ in range(T):
#     fibonacci(int(input()))