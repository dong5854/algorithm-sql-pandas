"""
2178번
미로탐색

https://www.acmicpc.net/problem/2178
"""
from collections import deque
import sys

# up, down, left, right
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

n, m = map(int, sys.stdin.readline().rstrip().split())

def bfs(graph):
    # 0, 0부터 시작하는 거 유의
    queue = deque()
    x = 0
    y = 0
    visited[y][x] = 0
    graph[y][x] = 1
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 밖인 경우 continue
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            # 방문한 적 없는 곳, 방문 후 방문표시
            if visited[ny][nx] != 0:
                visited[ny][nx] = 0
                graph[ny][nx] = graph[y][x] + 1
                queue.append((nx, ny))


graph = []
visited = []
for _ in range(n):
    t = sys.stdin.readline().rstrip()
    graph.append([int(i) for i in t])
    visited.append([int(i) for i in t])

bfs(graph)
print(graph[n-1][m-1])