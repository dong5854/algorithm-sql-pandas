"""
18111번
마인크래프트

https://www.acmicpc.net/problem/18111
"""
import sys

N, M, B = map(int, sys.stdin.readline().rstrip().split())
answer_time = int(1e9)
answer_height = 256

ground = []

for _ in range(N):
  ground.append(list(map(int, sys.stdin.readline().rstrip().split())))

for height in range(257):
  acquired = 0
  required = 0
  for i in range(N):
    for j in range(M):
      if height < ground[i][j]:
        acquired += ground[i][j] - height
      else:
        required += height - ground[i][j]
  
  # 필요한 만큼의 블럭이 없으면 스킵
  if required > (acquired + B):
    continue

  if answer_time >= acquired * 2 + required:
    answer_time = acquired * 2 + required
    answer_height = height
    

print(answer_time, answer_height)
