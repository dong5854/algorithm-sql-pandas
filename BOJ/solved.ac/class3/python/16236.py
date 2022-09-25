"""
16236번
아기 상어

https://www.acmicpc.net/problem/16236
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())

space = []
shark = 2
exp = 0

dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0] 

for _ in range(n):
    space.append(list(map(int, sys.stdin.readline().rstrip().split())))

def get_start():
    global space
    for i in range(n):
        for j in range(n):
            if space[i][j] == 9:
                return (i, j)

def bfs(r, c):
    global space
    global shark, exp
    dq = deque()
    candidate = []
    visited = [[0 for _ in range(n)] for _ in range(n)]
    visited[r][c] = 1
    space[r][c] = 0
    dq.append((r, c))
    while dq:
        cr, cc = dq.popleft()
        
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if nr >= n or nr < 0 or nc >= n or nc < 0:
                continue
            
            if visited[nr][nc] == 0:
                # 비어있는 칸인 경우
                if space[nr][nc] == 0:
                    visited[nr][nc] = visited[cr][cc] + 1
                    dq.append((nr, nc))
                # 비어있지 않은 경우
                else:
                    # 먹을 수 있는 물고기
                    if space[nr][nc] < shark:
                        visited[nr][nc] = visited[cr][cc] + 1
                        candidate.append((nr, nc, visited[nr][nc]))
                    # 지나칠 물고기
                    elif space[nr][nc] == shark:
                        visited[nr][nc] = visited[cr][cc] + 1
                        dq.append((nr, nc))
    # 정렬
    return sorted(candidate, key=lambda x: (-x[2], -x[0], -x[1]))

r, c = get_start()

cnt = 0
while True:
    result = bfs(r, c)
    if len(result) == 0:
        break
    else:
        r, c, dis = result.pop()
        # 먹었을 때 상어의 배가 차고, 물고기는 사라진다.
        space[r][c] = 0
        exp += 1
        if exp == shark:
            shark += 1
            exp = 0
        ################
        cnt += (dis - 1)

print(cnt)