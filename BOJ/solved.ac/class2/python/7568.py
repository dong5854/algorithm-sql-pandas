"""
7568번
덩치

https://www.acmicpc.net/problem/7568
"""
import sys

n = int(sys.stdin.readline())
people = []

for i in range(n):
  weight, height = map(int, sys.stdin.readline().rstrip().split())
  p = [weight, height]
  people.append(p)

for i in people:
  rank = 1
  for j in people:
    if i[0] < j[0] and i[1] < j[1]:
      rank += 1
  print(rank, end=" ")