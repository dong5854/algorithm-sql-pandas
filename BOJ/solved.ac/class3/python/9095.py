"""
9095번
1, 2, 3 더하기

https://www.acmicpc.net/problem/9095
"""
import sys

t = int(sys.stdin.readline().rstrip())

dp = [0 for _ in range(11)]

# 1
dp[1] = 1
# 1+1, 2
dp[2] = 2
# 1+1+1, 1+2, 2+1, 3
dp[3] = 4

for i in range(4, 11):
    dp[i] = dp[i-3] + dp[i-2] + dp[i-1]

for _ in range(t):
    print(dp[int(sys.stdin.readline().rstrip())])