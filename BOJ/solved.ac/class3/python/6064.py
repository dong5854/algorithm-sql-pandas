"""
6064번
카잉 달력

https://www.acmicpc.net/problem/6064
"""
import sys

t = int(sys.stdin.readline().rstrip())

def func(m,n,x,y):
    t = x
    while t <= m*n:
        if (t-x) % m == 0 and (t-y) % n == 0:
            return t
        t += m
    return -1

for _ in range(t):
    m, n, x, y = map(int, sys.stdin.readline().rstrip().split())
    print(func(m,n,x,y))
    
