import sys
from collections import deque


N, M = map(int, sys.stdin.readline().rstrip().split())

graph = []

for i in range(N):
    graph.append([int(i) for i in sys.stdin.readline().rstrip()])

# 특정 노드를 방문한 뒤 연결된 모든 노드들도 방문
def dfs(x, y):
    # 범위를 나가면 즉시 종료
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    # 해당 노드를 방문하지 않았다면
    if graph[x][y] == 0:
        # 방문처리
        graph[x][y] = 1
        # 모든 노드 탐색 후 True 반환
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    # 방문한 노드라면 False
    return False

result = 0
for i in range(N):
    for j in range(M):
        if dfs(i,j) == True:
            result += 1

print(result)