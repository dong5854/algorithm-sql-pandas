import sys
from collections import deque

n, m = map(int, sys.stdin.readline().rstrip().rsplit())

graph = []
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

# 이동할 네 방향 정의(상하좌우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        # 현재 위치에서 네 방향 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 공간을 벗어나는 경우
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 벽인 경우 무시
            if graph[nx][ny] == 0:
                continue
            # 해당 노드를 처음 방문하는 경우
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    # 가장 오른쪽 아래의 최단 거리 반환
    return graph[n-1][m-1]

# 결과 출력
print(bfs(0,0))