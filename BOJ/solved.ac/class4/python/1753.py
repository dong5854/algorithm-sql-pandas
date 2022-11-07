"""
1753번
최단 경로

https://www.acmicpc.net/problem/1753
"""
import sys
import heapq

INF = int(1e9)

def dijkstra(start: int) -> int:
    # 최단거리 테이블 초기화
    distance = [INF for _ in range(V+1)]
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        # 이미 처리된 적이 있으면 스킵
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance

# 정점의 개수 v, 간선의 개수 e
V, E = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(V+1)]

# 시작 정점의 번호
k = int(input())

# 각 간선의 정보 입력
for i in range(E):
    # u 에서 v 로 가는 가중치 w인 간선이 존재한다는 뜻
    u, v, w = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append((v, w))

distance_table = dijkstra(k)

for i in range(1, V+1):
    if distance_table[i] == INF:
        print("INF")
    else:
        print(distance_table[i])
