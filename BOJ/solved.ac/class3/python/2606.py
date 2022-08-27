"""
2606번
바이러스

https://www.acmicpc.net/problem/2606
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())


def bfs(graph):
    # 카운터
    cnt = 0
    # 큐
    queue = deque()
    # 첫번째 컴퓨터 방문 처리
    visited[1] = True
    queue.append(1)

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == False:
                cnt += 1
                visited[i] = True
                queue.append(i)
    return cnt


graph = [[]]
visited = [True]
for i in range(n):
    graph.append([])
    visited.append(False)

for i in range(m):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[x].append(y)
    graph[y].append(x)

print(bfs(graph))