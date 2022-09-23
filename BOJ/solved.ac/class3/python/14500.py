"""
14500번
테트로미노

https://www.acmicpc.net/problem/14500
"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

dx = [0, 0, -1 ,1]
dy = [-1, 1, 0, 0]

graph = []

for _ in range(n):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    graph.append(line)

visited = [[False  for _ in range(m)] for _ in range(n)]

ans = 0

def dfs(x, y, idx, sum):
    global graph
    global visited
    global ans

    if idx == 3:
        ans = max(ans, sum)
        return

    #x, y, 합의 값, 네모 수
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= n or nx < 0 or ny >= m or ny < 0:
            continue
        if visited[nx][ny] == True:
            continue
        
        if idx == 1:
            visited[nx][ny] = True
            dfs(x, y, idx + 1, sum + graph[nx][ny])
            visited[nx][ny] = False

        visited[nx][ny] = True
        dfs(nx, ny, idx + 1, sum + graph[nx][ny])
        visited[nx][ny] = False


for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 0, graph[i][j])
        visited[i][j] = False

print(ans)