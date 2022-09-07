"""
11724번
연결요소의 개수

https://www.acmicpc.net/problem/11724
"""
import sys
sys.setrecursionlimit(10 ** 6)

n, m = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for _ in range(m):
    v, e = map(int, sys.stdin.readline().rstrip().split())
    graph[v].append(e)
    graph[e].append(v)

def dfs(graph, v):
    if visited[v] == False:
        visited[v] = True
        for i in graph[v]:
            if visited[i] == False:
                dfs(graph, i)
        return 1
    else:
        return 0

cnt = 0
for i in range(1, n+1):
    if dfs(graph, i) == 1:
        cnt += 1

print(cnt)