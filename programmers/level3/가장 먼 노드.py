"""
가장 먼 노드

https://school.programmers.co.kr/learn/courses/30/lessons/49189
"""
from collections import deque

def bfs(nodes, visited):
    queue = deque()
    visited[1] = 1
    queue.append(1)
    while queue:
        c = queue.popleft()
        for i in nodes[c]:
            if visited[i] != 0:
                continue
            visited[i] = visited[c] + 1
            queue.append(i)

    return visited.count(max(visited))
    
    

def solution(n, edge):
    nodes = [[] for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]
    for e in edge:
        nodes[e[0]].append(e[1])
        nodes[e[1]].append(e[0])
        
    return bfs(nodes, visited)