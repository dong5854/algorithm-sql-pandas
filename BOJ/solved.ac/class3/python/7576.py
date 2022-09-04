"""
7576번
토마토

https://www.acmicpc.net/problem/7576
"""
from collections import deque
import queue
import sys

m,n = map(int, sys.stdin.readline().rstrip().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

# 위, 아래, 왼쪽, 오른쪽
drow = [-1, 1, 0, 0]
dcol = [0, 0, -1, 1]

queue = deque()

def bfs():
    global queue
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + drow[i]
            nc = c + dcol[i]
            # 범위 밖일 경우 continue
            if nr < 0 or nr >= n or nc < 0 or nc >= m:
                continue
            if graph[nr][nc] == 0:
                graph[nr][nc] = graph[r][c] + 1
                queue.append((nr, nc))
        

for r in range(n):
    for c in range(m):
        if graph[r][c] == 1:
            queue.append((r, c))

bfs()

result = 1
for i in graph:
    if 0 in i:
        result = 0
        break
    max_val = max(i)
    if max_val > result:
        result = max_val

print(result-1)