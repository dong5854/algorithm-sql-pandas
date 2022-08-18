"""
1463번
1로 만들기

https://www.acmicpc.net/problem/1463
"""
import sys

N = int(sys.stdin.readline().rstrip())

d = [0] * (N + 1)

for i in range(2, N + 1): # 0과 1일때는 횟수가 0이므로 2부터 시작
    d[i] = d[i - 1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i//3] + 1)
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2] + 1)
print(d[N])