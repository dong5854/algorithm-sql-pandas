"""
1012번
유기농 배추

https://www.acmicpc.net/problem/1012
"""
import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(graph, x, y):
    queue = deque()
    graph[x][y] = 0
    queue.append((x,y))
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
    return

T = int(input())

for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().rstrip().split())
    farm = [[0] * M for _ in range(N)]
    for _ in range(K):
        cnt = 0
        x,y = map(int, sys.stdin.readline().rstrip().split())
        farm[y][x] = 1
    for i in range(N):
        for j in range(M):
            if farm[i][j] == 1:
                dfs(farm, i, j)
                cnt += 1
    print(cnt)