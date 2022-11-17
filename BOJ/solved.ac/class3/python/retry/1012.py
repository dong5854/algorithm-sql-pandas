"""
1012번
유기농 배추

https://www.acmicpc.net/problem/1012
"""
import sys
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

T = int(input())

def bfs(startX: int, startY: int) -> bool:
    if visited[startY][startX] == 1 or graph[startY][startX] == 0:
        return False
    # 방문 처리
    visited[startY][startX] = 1
    q = deque()
    q.append((startY, startX))
    while q:
        currentY, currentX = q.popleft()
        for i in range(4):
            nextY = currentY + dy[i]
            nextX = currentX + dx[i]
            if nextY < 0 or nextY >= N or nextX < 0 or nextX >= M:
                continue
            if visited[nextY][nextX] == 0 and graph[nextY][nextX] == 1:
                visited[nextY][nextX] = 1
                q.append((nextY, nextX))
    return True
    

for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    graph = [[0] * M for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        graph[Y][X] = 1

    cnt = 0
    for iy in range(N):
        for ix in range(M):
            if bfs(ix, iy):
                cnt += 1
    print(cnt)

    