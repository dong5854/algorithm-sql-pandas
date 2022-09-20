"""
9461번
파도반 수열

https://www.acmicpc.net/problem/9461
"""
"""
패턴 찾기
1번째 1
2번째 1 <= 1번째
3번째 1 <= 2번째
4번째 2 <= 1번째 + 3번째
5번째 2 <= 4번째
6번째 3 <= 1번째 + 5번째
7번째 4 <= 2번째 + 6번째
8번째 5 <= 3번째 + 7번째
9번째 7 <= 4번째 + 8번째
10번째 9 <= 5번째 + 9번째
11번째 12 <= 6번째 + 10번째
.
.
.
"""
import sys

t = int(sys.stdin.readline().rstrip())

dp =[0 for _ in range(101)]
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

def solve(n: int):
    global dp
    for i in range(6, n+1):
        if dp[i] == 0:
            dp[i] = dp[i-5] + dp[i-1]

    return dp[n]
    

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    print(solve(n))