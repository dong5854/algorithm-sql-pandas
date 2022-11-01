"""
1149번
RGB거리

https://www.acmicpc.net/problem/1149
"""
import sys

n = int(sys.stdin.readline().rstrip())

houses = []
min_cost = [[] for _ in range(n)]

for _ in range(n):
    houses.append(list(map(int, sys.stdin.readline().rstrip().split()))) 

for i in range(1, n):
    houses[i][0] += min(houses[i-1][1], houses[i-1][2])
    houses[i][1] += min(houses[i-1][0], houses[i-1][2])
    houses[i][2] += min(houses[i-1][0], houses[i-1][1])

print(min(houses[n-1]))