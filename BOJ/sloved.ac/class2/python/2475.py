"""
1018번
체스판 다시 칠하기

https://www.acmicpc.net/problem/1018
"""
N,M = map(int, input().split())
chess = []
candidates = []

# 체스판 생성
for _ in range(N):
  chess.append(list(input()))

for i in range(N-7):
  for j in range(M-7):
    w_count = 0 #시작점이 흰색인 경우
    b_count = 0 #시작점이 까만색인 경우
    for a in range(i, i+8):
      for b in range(j, j+8):
        if (a+b)%2 == 0: #왼쪽 위 색과 같은 색으로 시작
          if chess[a][b] != "W": # 왼쪽 위 흰색
            w_count += 1
          if chess[a][b] != "B": # 왼쪽 위 끼민색
            b_count += 1
        else: # 왼쪽 위 색과 다른 색으로 시작
          if chess[a][b] != "B": # 왼쪽 위 흰색
            w_count += 1
          if chess[a][b] != "W": # 왼쪽 위 끼민색
            b_count += 1
    candidates.append(min(w_count, b_count))

print(min(candidates))