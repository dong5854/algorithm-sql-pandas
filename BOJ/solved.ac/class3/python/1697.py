"""
1697번
숨바꼭질

https://www.acmicpc.net/problem/1697
"""
from collections import deque
import sys

def forward(cur):
    return cur + 1

def backward(cur):
    return cur - 1

def teleport(cur):
    return cur * 2

moves = [forward, backward, teleport]

def bfs(graph, N, K):
    queue = deque()
    # 큐에 넣기
    queue.append(N)
    # 현재 위치는 0
    graph[N] = 0
    while queue:
        # 큐에서 빼기
        v = queue.popleft()
        # 현재 움직임 값
        cur = graph[v]
        for i in moves:
            # 다음 위치 값
            nv = i(v)
            # 목표를 잡았을 경우
            if nv == K:
                if graph[nv] == -1: # 첫방문
                    graph[nv] = cur + 1
                elif graph[nv] > cur + 1:   # 첫방문이 아닌 경우
                    graph[nv] = cur + 1
                continue
            # 목표물이 없을 겨우, 범위 안에서
            if nv > 0 and nv <= 100_000:
                if graph[nv] == -1: # 첫방문
                    graph[nv] = cur + 1
                    queue.append(nv)
                elif graph[nv] > cur + 1:   # 첫방문이 아닌 경우
                    graph[nv] = cur + 1
                    queue.append(nv)
        

N, K = map(int, sys.stdin.readline().rstrip().split())

graph = [-1 for _ in range(100_001)]

bfs(graph, N, K)

print(graph[K])
