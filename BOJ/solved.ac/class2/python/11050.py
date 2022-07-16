"""
11050번
이항 계수 1

https://www.acmicpc.net/problem/11050
"""
import sys

def factorial(i:int):
  if i == 0:
    return 1
  return i * factorial(i-1)

n, k = map(int, sys.stdin.readline().rstrip().split())
result = factorial(n) // (factorial(k) * factorial(n-k))

print(result)