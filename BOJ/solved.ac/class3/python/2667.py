"""
2667번
단지번호 붙이기

https://www.acmicpc.net/problem/2667
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())

# 위, 아래, 왼, 오
drow = [-1, 1, 0, 0]
dcol = [0, 0, -1, 1]

graph = []


for _ in range(n):
    graph.append([i for i in list(map(int,sys.stdin.readline().rstrip()))])

def bfs(graph, row, col):
    # 단지 수 카운터
    cnt = 0
    # 집이 없는 곳일 경우, 바로 함수 종료 return 0
    if(graph[row][col] == 0):
        return cnt

    # 큐 정의
    queue = deque()
    # 방문처리
    graph[row][col] = 0
    cnt += 1
    # 큐 삽입
    queue.append((row, col))

    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + drow[i]
            nc = c + dcol[i]
            # 범위 밖일 경우 제외
            if nr < 0 or nc < 0 or nr >= n or nc >= n:
                continue
            # 방문하지 않은 곳인 경우
            if(graph[nr][nc] == 1):
                graph[nr][nc] = 0
                cnt += 1
                queue.append((nr, nc))
    
    return cnt


ans = []
for i in range(n):
    for j in range(n):
        ret = bfs(graph, i, j)
        if ret != 0:
            ans.append(ret)

ans.sort()
print(len(ans))
for i in ans:
    print(i)
