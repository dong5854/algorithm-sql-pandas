"""
1074번
Z

https://www.acmicpc.net/problem/1074
"""
import sys

N, r, c = map(int, sys.stdin.readline().rstrip().split())

ans = 0

# 쪼개기
while N > 0:
    N -= 1
    # 1번
    if r < 2 ** N and c < 2 ** N:
        ans += (2 ** N) * (2 ** N) * 0
    # 2번
    elif r < 2 ** N and c >= 2 ** N:
        ans += (2 ** N) * (2 ** N) * 1
        c -= (2 ** N)
    # 3번
    elif r >= 2 ** N and c < 2 ** N:
        ans += (2 ** N) * (2 ** N) * 2
        r -= (2 ** N)
    # 4번
    else:
        ans += (2 ** N) * (2 ** N) * 3
        c -= (2 ** N)
        r -= (2 ** N)

print(ans)
