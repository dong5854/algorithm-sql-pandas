"""
11403번
경로 찾기

https://www.acmicpc.net/problem/11403
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))


def bfs(i: int, j: int):
    visited = [0 for _ in range(n)]
    queue = deque()
    for t in range(len(graph[i])):
        if graph[i][t] == 1 and visited[t] == 0:
            visited[t] = 1
            queue.append(t)
    while queue:
        nx = queue.popleft()
        if nx == j:
            return True
        for t in range(len(graph[i])):
            if graph[nx][t] == 1 and visited[t] == 0:
                visited[t] = 1
                queue.append(t)
    return False

ans = [ [] for _ in range(n)]
for i in range(n):
    for j in range(len(graph[i])):
        if bfs(i, j) == True:
            print(1, end=' ')
        else:
            print(0, end=' ')
    print()