"""
11279번
최대 힙

https://www.acmicpc.net/problem/11279
"""
import heapq
import sys

N = int(sys.stdin.readline().rstrip())

heap = []
for _ in range(N):
    num = int(sys.stdin.readline().rstrip())
    if num != 0:
        heapq.heappush(heap, -num)
    else:
        if len(heap) == 0:
            print(0)
        else:
            popped = heapq.heappop(heap)
            print(-popped)
