"""
11651번
좌표 정렬하기2

https://www.acmicpc.net/problem/11651
"""
import sys

N = int(sys.stdin.readline().rstrip())
points = []

for i in range(N):
  [a, b] = (map(int, sys.stdin.readline().rstrip().split()))
  points.append([a, b])

points.sort(key= lambda x: x[0])
points.sort(key= lambda x: x[1])

for i in points:
  print(i[0], i[1])