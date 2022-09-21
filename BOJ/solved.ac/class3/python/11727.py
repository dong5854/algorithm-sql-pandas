"""
11727번
2×n 타일링 2

https://www.acmicpc.net/problem/11727
"""
"""
n / 결과
1 = 1
2 = 3
3 = 5, [2] + [1] * 2
4 = 11, [3] + [2] * 2
5 = 21, [4] + [3] * 2
6 = 43, [5] + [4] * 2
7 = 85,[6] + [5] * 2
8 = 171, [7] + [6] * 2
"""
import sys

n = int(sys.stdin.readline().rstrip())

dp = [0 for _ in range(1001)]

dp[1] = 1
dp[2] = 3
for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2] * 2

print(dp[n]  % 10_007)