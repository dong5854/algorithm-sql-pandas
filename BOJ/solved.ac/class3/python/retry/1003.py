"""
1003번
피보나치 함수

https://www.acmicpc.net/problem/1003
"""
import sys

# [0 출력, 1 출력]
dp = [[0, 0] for _ in range(41)]

dp[0] = [1,0]
dp[1] = [0,1]
dp[2] = [1,1]
dp[3] = [1,2]

T = int(sys.stdin.readline().rstrip())

def fibonacci(n: int):
    global dp
    if n < 4:
        return
    for i in range(4, n+1):
        zeros = dp[i-1][0] + dp[i-2][0]
        ones =  dp[i-1][1] + dp[i-2][1]
        dp[i] = [zeros, ones]

for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    fibonacci(N)
    print(dp[N][0], dp[N][1])
    