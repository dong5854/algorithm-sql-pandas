"""
등굣길(dp + 반복문)

https://school.programmers.co.kr/learn/courses/30/lessons/42898
"""
def solution(m, n, puddles):
    
    # 지도 생성
    graph = [[0 for _ in range(m+1)] for _ in range(n+1)]
    dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    # 웅덩이 지정
    for p in puddles:
        tm, tn = p[0], p[1]
        graph[p[1]][p[0]] = -1
    
    dp[1][1] = 1
    for i in range(1, n+1):
        for j in range(1, m+1):
            # 집일 경우 넘어감
            if i == 1 and j == 1:
                continue
            # 웅덩이일 경우 넘어감
            if graph[i][j] == -1:
                continue
            else:
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007
                
                
    
    return dp[n][m]
"""
등굣길(dp + bfs)

https://school.programmers.co.kr/learn/courses/30/lessons/42898
"""
from collections import deque

# 오른쪽, 아래
dm = [1,0]
dn = [0,1]

def bfs(graph, visited, m, n):
    # 집이 있는 위치가 1
    visited[1][1] = 1
    dq = deque()
    dq.append((1,1))
    while dq:
        cm, cn = dq.popleft()
        for i in range(2):
            nm = cm + dm[i]
            nn = cn + dn[i]
            # 지도 범위 밖인 경우 반복문 탈출
            if nm < 1 or nn < 1 or nm > m or nn > n:
                continue
            # 웅덩이인 경우 반복문 탈출
            if graph[nn][nm] == -1:
                continue
            if visited[nn][nm] == 0:
                visited[nn][nm] += visited[cn][cm]
                dq.append((nm,nn))
            else:
                visited[nn][nm] += visited[cn][cm]
            

    return visited[n][m]


def solution(m, n, puddles):
    
    # 지도 생성
    graph = [[0 for _ in range(m+1)] for _ in range(n+1)]
    visited = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    # 웅덩이 지정
    for p in puddles:
        tm, tn = p[0], p[1]
        graph[p[1]][p[0]] = -1
    
    # bfs
    return bfs(graph, visited, m, n) % 1_000_000_007