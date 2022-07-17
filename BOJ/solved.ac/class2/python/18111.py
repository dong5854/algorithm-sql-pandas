"""
18111번
마인크래프트

https://www.acmicpc.net/problem/18111
"""
import sys
n, m, b = map(int, sys.stdin.readline().split())
table = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
ans = 100000000000000000000
height = 0


# 각 높이마다 계산
for i in range(257):
  required = 0
  acquired = 0
  for j in range(n):
    for k in range(m):
      if table[j][k] < i:
        # 필요한 블럭의 양
        required += (i - table[j][k])
      else:
        # 수집할 수 있는 블럭의 양
        acquired += (table[j][k] - i)
  # 수집한 블럭과 가지고 있던 블럭의 합이 총 블럭의 양
  inventory = acquired + b
  # 필요 양보다 가지고 있는 양이 적을 경우
  if inventory < required:
    continue
  time  = 2 * acquired + required
  if time <= ans:
    ans = time
    height = i
print(ans, height)