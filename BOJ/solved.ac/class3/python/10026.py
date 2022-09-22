"""
10026번
적록색약

https://www.acmicpc.net/problem/10026
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())

graph = []
able_visited = [[0 for _ in range(n)] for _ in range(n)]
disable_visited = [[0 for _ in range(n)] for _ in range(n)]

# 위 아래 왼쪽 오른쪽
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def able_bfs(graph, x, y):
    global able_visited, n
    queue = deque()
    # 방문했으면 스킵
    if able_visited[x][y] != 0:
        return 0
    else:
        able_visited[x][y] = 1
        queue.append((x,y))
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            # 범위 체크
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            # 방문하지 않았고 색이 같은지 체크
            if able_visited[nx][ny] == 0 and graph[cx][cy] == graph[nx][ny]:
                able_visited[nx][ny] = 1
                queue.append((nx, ny))
    return 1

def disable_bfs(graph, x, y):
    global disable_visited, n
    queue = deque()
    # 방문했으면 스킵
    if disable_visited[x][y] != 0:
        return 0
    else:
        disable_visited[x][y] = 1
        queue.append((x,y))
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            # 범위 체크
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            # 방문하지 않았고 색이 같은지 체크
            if disable_visited[nx][ny] == 0 and graph[cx][cy] == graph[nx][ny]:
                disable_visited[nx][ny] = 1
                queue.append((nx, ny))
            # G와 R을 구분 못하는 점을 체크
            elif disable_visited[nx][ny] == 0 and ((graph[cx][cy] == 'G' and graph[nx][ny] == 'R') or (graph[cx][cy] == 'R' and graph[nx][ny] == 'G')) :
                disable_visited[nx][ny] = 1
                queue.append((nx, ny))
    return 1
    
    

for _ in range(n):
    line = list(sys.stdin.readline().rstrip())
    graph.append(line)

able_sum = 0
disable_sum = 0
for i in range(n):
    for j in range(n):
        able_sum += able_bfs(graph, i, j)
        disable_sum += disable_bfs(graph, i, j)

print(able_sum, disable_sum)