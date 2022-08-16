"""
1260번
DFS와 BFS

https://www.acmicpc.net/problem/1260
"""
import sys
from collections import deque

def dfs(graph, start):
    # 방문처리
    dfs_visited[start] = 1
    print(start, end=' ')
    for i in graph[start]:
        if dfs_visited[i] == 0:
            dfs(graph, i)

def bfs(graph, start):
    queue = deque()
    # 방문처리
    bfs_visited[start] = 1
    queue.append(start)

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if bfs_visited[i] == 0:
                bfs_visited[i] = 1
                queue.append(i)
                



N, M, V = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(N+1)]
dfs_visited = [0 for _ in range(N+1)]
bfs_visited = [0 for _ in range(N+1)]
for _ in range(M):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[x].append(y)
    graph[y].append(x)

for i in graph:
    i.sort()

dfs(graph, V)
print()
bfs(graph, V)