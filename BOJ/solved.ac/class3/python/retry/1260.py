"""
1260번
DFS와 BFS

https://www.acmicpc.net/problem/1260
"""
import sys
from collections import deque

def dfs(graph: list, visited: list, start: int):
    print(start, end=" ")
    visited[start] = True
    
    for v in graph[start]:
        if visited[v] is False:
            dfs(graph, visited, v)

def bfs(graph: list, visited: list, start: int):
    visited[start] = True
    q = deque()
    q.append(start)

    while q:
        current_vertex = q.popleft()
        print(current_vertex, end= " ")
        for v in graph[current_vertex]:
            if visited[v] is False:
                visited[v] = True
                q.append(v)


N, M, V = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(N+1)]
dfs_visited = [False for _ in range(N+1)]
bfs_visited = [False for _ in range(N+1)]

for _ in range(M):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    # 양방향이므로 두번
    graph[s].append(e)
    graph[e].append(s)

for i in graph:
    i.sort()

dfs(graph, dfs_visited, V)
print()
bfs(graph, bfs_visited, V)