"""
1504번
특정한 최단 경로

https://www.acmicpc.net/problem/1504
"""
import sys
import heapq

INF = int(1e9)

# N = 정점의 개수, E = 간선의 개수
N, E = map(int, sys.stdin.readline().rstrip().split())

# 그래프 초기화, 방향성 없음
graph = [[] for _ in range(N+1)]

for _ in range(E):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    # a번 정점부터 b 번 정점까지 양방향, 거리는 c
    graph[a].append((b, c))
    graph[b].append((a, c))

# 반드시 거쳐야 하는 두 정점
v1, v2 = map(int, sys.stdin.readline().rstrip().split())

# 임의의 두 정점 사이에 간선은 최대 2개
# 1번정점에서 N 번 정점으로의 최단거리, 단 v1, v2 반드시 통과


# 2 번째 접근 방법
# 1번과 유사하나 최단 거리를 다익스트라로 구한다.
def dijkstra(start: int, destination: int) -> int:
    # 최단 거리 테이블 초기화
    distance = [INF for _ in range(N+1)]
    # 큐
    q = []

    # 자기자신으로의 거리는 0으로 초기화
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        # 이미 처리된 적이 있다면 스킵
        if distance[now] < dist:
            continue

        # 인접 노드들 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐 다른 노드로 이동하는 경우가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance[destination]

        
start_v1 = dijkstra(1, v1)
v1_v2 = dijkstra(v1, v2)
v2_N = dijkstra(v2, N)
start_v2 = dijkstra(1, v2)
v2_v1 = dijkstra(v2, v1)
v1_N = dijkstra(v1, N)
if start_v1 == INF or v1_v2 == INF or v2_N == INF:
    print(-1)
elif start_v2 == INF or v2_v1 == INF or v1_N == INF:
    print(-1)
else:
    print(min(start_v1 + v1_v2 + v2_N, start_v2 + v2_v1 + v1_N))



"""
# 1 번째 접근 방법
# v1으로의 최단 경로를 bfs로 구한 후, v2로의 최단 경로를 다시 bfs로 구하고, N으로의 최단 경로를 구한다. v2 -> v1 -> N 순서도 구해 2개의 거리를 비교해 더 적은 것을 고른다.
# 오답, 이유는 거리를 고려하지 않음
def bfs(start: int, destination: int) -> int:
    visited = [False for _ in range(N+1)]

    visited[start] = True

    q= deque()

    for line in graph[start]:
        node, distance = line[0], line[1]
        if node == destination:
            return distance
        else:
            q.append((node, distance))
    
    while q:
        cur_node, cur_distance = q.popleft()

        for line in graph[cur_node]:
            nxt_node, nxt_distance = line[0], line[1]
            if nxt_node == destination:
                return cur_distance + nxt_distance
            else:
                q.append((nxt_node, cur_distance + nxt_distance))

    return -1

start_v1 = bfs(1, v1)
v1_v2 = bfs(v1, v2)
v2_N = bfs(v2, N)
start_v2 = bfs(1, v2)
v2_v1 = bfs(v2, v1)
v1_N = bfs(v1, N)
if start_v1 == -1 or v1_v2 == -1 or v2_N == -1:
    print(-1)
elif start_v2 == -1 or v2_v1 == -1 or v1_N == -1:
    print(-1)
else:
    print(min(start_v1 + v1_v2 + v2_N, start_v2 + v2_v1 + v1_N))
"""