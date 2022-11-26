"""
1697번
숨바꼭질

https://www.acmicpc.net/problem/1697
"""
import sys
from collections import deque

def walk_forward(v):
    return v + 1

def walk_backward(v):
    return v - 1

def teleport(v):
    return 2 * v
    
moves = [walk_forward, walk_backward, teleport]

def bfs(graph, start, target):
    graph[start] = 0
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        cur_time = graph[v]
        for i in moves:
            nv = i(v)
            if nv < 0 or nv > 100_000:
                continue
            if graph[nv] == INF:
                graph[nv] = min(graph[nv], cur_time + 1)
                if nv != target:
                    q.append(nv)

N, K = map(int, sys.stdin.readline().split())

INF = int(1e9)
graph = [INF for _ in range(100_001)]

bfs(graph, N, K)

print(graph[K])
