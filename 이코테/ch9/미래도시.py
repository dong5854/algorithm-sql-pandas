import sys

# 무한대를 나타내는 값
INF = int(1e9)

# n은 회사(노드)의 개수, m은 경로(간선)의 개수
n, m = map(int, sys.stdin.readline().split())

# 2차원 그래프
graph = [[INF] * (n+1) for _ in range(n+1)]

# 자기 자신에게 가는 비용은 0으로 초기화
for i in range(1, n+1):
    graph[i][i] = 0

# 간선 입력
for _ in range(m):
    # a와 b가 서로에게 가는 값을 길이 1로 설정
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1
    graph[b][a] = 1

# 소개팅 상대의 회사(거쳐갈 노드) k와 판매하러갈 회사(최종 목적 노드) x 입력
x, k = map(int, sys.stdin.readline().split())

# 플로이드 워셜 알고리즘
for i in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][i] + graph[i][b])

# k를 거쳐 x로 가는 최단 거리
distance = graph[1][k] + graph[k][x]

# 도달할 수 없는 경우, -1 출력
if distance >= INF:
    print("-1")
# 도달할 수 있다면, 최단 거리를 출력
else:
    print(distance)