"""
2579번
계단 오르기

https://www.acmicpc.net/problem/2579
"""
import sys

N = int(sys.stdin.readline().rstrip())

steps = [0 for _ in range(N+1)]
dp = [0 for _ in range(N+1)]
for i in range(1, N+1):
   score = int(sys.stdin.readline().rstrip())
   steps[i] = score

if N >= 1:
    dp[1] = steps[1]
if N >= 2:
    dp[2] = steps[1] + steps[2]

for i in range(3, N+1):
    dp[i] = max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] +steps[i])

print(dp[N])