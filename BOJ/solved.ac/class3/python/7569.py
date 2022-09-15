"""
7569번
토마토

https://www.acmicpc.net/problem/7569
"""
from collections import deque
import sys

m, n, h = map(int, sys.stdin.readline().rstrip().split())

# 높이가 만큼 초기화
graph = [[] for _ in range(h)]

for i in range(h):
    for j in range(n):
        graph[i].append(list(map(int, sys.stdin.readline().rstrip().split())))


# 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
dm = [0, 0, -1, 1, 0, 0]
dn = [0, 0, 0, 0, 1, -1]
dh = [1, -1, 0, 0, 0, 0]

def bfs(graph, queue):
    global dm, dn, dh
    global m, n, h    
    while queue:
        pm,pn,ph = queue.popleft()
        # print(m, n, h)
        # 6방향 체크
        for i in range(6):
            nm = pm + dm[i]
            nn = pn + dn[i]
            nh = ph + dh[i]
            # index out of range 방지
            if nm >= m or nm < 0 or nn >= n or nn < 0 or nh >= h or nh < 0:
                continue
            # 익지 않은 토마토인 경우
            if graph[nh][nn][nm] == 0:
                graph[nh][nn][nm] = graph[ph][pn][pm] + 1
                queue.append((nm,nn,nh))

# 탐색
queue = deque()
for i in range(m):
    for j in range(n):
        for p in range(h):
            # 익은 토마토의 경우
            if graph[p][j][i] == 1:
                queue.append((i,j,p))
            
bfs(graph, queue)

# 최대값 찾기
result = 0
for i in range(m):
    for j in range(n):
        for p in range(h):
            # 익지 않은 토마토가 있을 경우 프로그램 종료
            if graph[p][j][i] == 0:
                print(-1)
                exit()
            elif graph[p][j][i] > result:
                result = graph[p][j][i]

# 일수는 0부터 시작인데 그래프의 값은 1부터 시작해서 구한 값이므로 1을 빼준다.
print(result - 1)