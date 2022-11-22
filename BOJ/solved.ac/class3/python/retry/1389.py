"""
1389번
케빈 베이컨의 6단계 법칙

https://www.acmicpc.net/problem/1389
"""
from collections import deque
import sys

def bfs(graph, v, visited):
    queue = deque()
    visited[v] = 0
    queue.append(v)

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            # 방문하지 않은 곳은 방문 처리
            if visited[i] == -1:
                # 현재 노드에서 하나 더 멀게
                visited[i] = visited[v] + 1
                queue.append(i)
    
    return sum(visited)

N, M = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

winner = 0
min = int(1e9)
for i in range(N):
    # 방문하지 않은 곳은 -1
    visited = [-1 for _ in range(N+1)]
    bacon = bfs(graph, i+1, visited)
    if min > bacon:
        min = bacon
        winner = i + 1
print(winner)