"""
1238번
파티

https://www.acmicpc.net/problem/1238
"""
import sys
import heapq

INF = int(1e9)

def dijkstra(start, destination): 
    # 최단 거리 테이블 초기화
    distance = [INF] * (N+1)
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정해 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        # 거리, 현재 노드 = 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 이미 처리된 노드면 스킵
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in towns[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance[destination]

# N = 학생 수, X 번 마을, M 개의 단방향 도로, i 번째 길, Ti의 시간 소요
N, M, X = map(int, sys.stdin.readline().rstrip().split())

# 마을의 수
towns = [[] for _ in range(N+1)]

# towns[시작점] 에 (끝점, 소요시간)
for _ in range(M):
    start, end, time = map(int, sys.stdin.readline().rstrip().split())
    towns[start].append((end, time))

max_student = 0
for student in range(1, N+1):
    minimal_distance = dijkstra(student, X) + dijkstra(X, student)
    if minimal_distance > max_student:
        max_student = minimal_distance

print(max_student)