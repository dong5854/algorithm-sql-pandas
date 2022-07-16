"""
10989번
수 정렬하기 3

https://www.acmicpc.net/problem/10989
"""
import sys

N = int(sys.stdin.readline())
arr = [0] * 10_001

for i in range(N):
  arr[int(sys.stdin.readline())] += 1

for i in range(10_001):
  if arr[i] != 0:
    for j in range(arr[i]):
      print(i)