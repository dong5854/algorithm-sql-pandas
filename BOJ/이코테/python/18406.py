"""
18406번
럭키 스트레이트

https://www.acmicpc.net/problem/18406
"""
import sys

N = sys.stdin.readline().rstrip()

half = len(N) // 2

left_sum = 0
right_sum = 0
for i in range(len(N)):
    if i < half:
        left_sum += int(N[i])
    else:
        right_sum += int(N[i])

if left_sum == right_sum:
    print("LUCKY")
else:
    print("READY")