"""
1167번
트리의 지름

https://www.acmicpc.net/problem/1167
"""
from collections import deque
import sys

def bfs(start):
    visited = [0]  * (v+1)

    visited[start] = True
    q = deque()
    q.append((start, 0))

    farthest_node, farthest_dist = 0, 0
    while q:
        now, dist = q.popleft()
        for info in graph[now]:
            if not visited[info[0]]:
                visited[info[0]] = True
                q.append((info[0], dist + info[1]))
            else:
                if farthest_dist < dist:
                    farthest_node = now
                    farthest_dist = dist
    
    return farthest_node, farthest_dist

def bfs_target(start, end):
    visited = [0]  * (v+1)

    visited[start] = True
    q = deque()
    q.append((start, 0))

    while q:
        now, dist = q.popleft()
        for info in graph[now]:
            if not visited[info[0]]:
                if info[0] == end:
                    return dist + info[1]
                visited[info[0]] = True
                q.append((info[0], dist + info[1]))
    
    return 0


# 노드의 개수
v = int(sys.stdin.readline().rstrip())

# 각 노드에 있는 노드의 정보에 대한 리스트
graph = [[] for _ in range(v+1)]

for i in range(1, v+1):
    input_line = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(1, len(input_line) -1, 2):
        # i 노드는 (a,b) a 정점과 거리가 b 인 간선으로 연결되어있다.
        graph[input_line[0]].append((input_line[j], input_line[j+1]))

i, dist = bfs(1)

result = bfs(i)

print(result[1])