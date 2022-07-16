"""
2231번
분해합

https://www.acmicpc.net/problem/2231
"""
import sys

N = sys.stdin.readline().rstrip()
flag = False
digit = 0

for i in N:
  digit += 1

min = int(N) - 9 * digit


if min <= 0:
  for i in range(0, int(N)+1):
    cur = str(i)
    sum = 0
    for c in cur:
      sum += int(c)
    cur_sum = i + sum
    if cur_sum == int(N):
      print(i)
      flag = True
      break
elif min > 0:
  for i in range(min, int(N)+1):
    cur = str(i)
    sum = 0
    for c in cur:
      sum += int(c)
    cur_sum = i + sum
    if cur_sum == int(N):
      print(i)
      flag = True
      break

if flag is False:
  print(0)