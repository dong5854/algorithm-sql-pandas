"""
11726번
2xn 타일링

https://www.acmicpc.net/problem/11726
"""
import sys

n = int(sys.stdin.readline().rstrip())

d =[0 for _ in range(1001)]

d[1] = 1
d[2] = 2
d[3] = 3

for i in range(4, n+1):
    d[i] = (d[i-1] + d[i-2]) % 10007

print(d[n])