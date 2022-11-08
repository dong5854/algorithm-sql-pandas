"""
1865번
웜홀

https://www.acmicpc.net/problem/1865
"""

# 플로이드 워샬 오답
"""
import sys

INF = int(1e9)

def floyd(graph, N) -> str:
    for m in range(1, N+1):
        for s in range(1, N+1):
            for e in range(1, N+1):
                graph[s][e] = min(graph[s][e], graph[s][m] + graph[m][e])
                if s == e and graph[s][e] < 0:
                    return "YES"
    return "NO"
            

# 테스트케이스의 개수 TC
TC = int(input())

for _ in range(TC):
    # 지점의 수 N, 도로의 개수 M, 웜홀의 개수 W
    N, M, W = map(int, sys.stdin.readline().rstrip().split())

    # 그래프
    graph = [[INF] * (N+1) for _ in range(N+1)]

    for i in range(1, N+1):
        graph[i][i] = 0

    # 도로의 정보
    for _ in range(M):
        # S와 E는 연결된 지점의 번호, T는 이 도로를 통해 이동하는데 걸리는 시간
        S, E, T = map(int, sys.stdin.readline().rstrip().split())
        # 도로는 방향이 없다.
        graph[S][E] = T
        graph[E][S] = T
        
    
    #웜홀의 정보
    for _ in range(W):
        # S와 E는 연결된 지점(시작, 도착)의 번호, T는 줄어드는 시간
        S, E, T = map(int, sys.stdin.readline().rstrip().split())
        # 웜홀은 방향이 있다.
        graph[S][E] = -T
    
    print(floyd(graph, N))
"""
# 다익스트라 오답
"""
import sys
import heapq

INF = int(1e9)

def dijkstra(graph, distance) -> str:
    q = []
    # 출발 지점에 대한 초기화
    distance[1] = 0
    heapq.heappush(q, (0, 1))

    while q:
        dist, now = heapq.heappop(q)

        # 이미 최단 거리가 갱신된 적이 있으면 스킵
        if distance[now] < dist:
            continue

        if distance[now] < 0:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


    if distance[1] < 0:
        return "YES"
    else:
        return "NO"
            

# 테스트케이스의 개수 TC
TC = int(input())

for _ in range(TC):
    # 지점의 수 N, 도로의 개수 M, 웜홀의 개수 W
    N, M, W = map(int, sys.stdin.readline().rstrip().split())

    # 그래프
    graph = [[] for _ in range(N+1)]

    # 최단거리 테이블
    distance = [INF for _ in range(N+1)]

    # 도로의 정보
    for _ in range(M):
        # S와 E는 연결된 지점의 번호, T는 이 도로를 통해 이동하는데 걸리는 시간
        S, E, T = map(int, sys.stdin.readline().rstrip().split())
        # 도로는 방향이 없다.
        graph[S].append((E, T))
        graph[E].append((S, T))
        
    
    #웜홀의 정보
    for _ in range(W):
        # S와 E는 연결된 지점(시작, 도착)의 번호, T는 줄어드는 시간
        S, E, T = map(int, sys.stdin.readline().rstrip().split())
        # 웜홀은 방향이 있다.
        graph[S].append((E, -T))
    
    print(dijkstra(graph, distance))
"""
