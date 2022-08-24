"""
1927번
최소힙

https://www.acmicpc.net/problem/1927
"""
import sys
import heapq

N = int(sys.stdin.readline().rstrip())

heap = []

for _ in range(N):
    val = int(sys.stdin.readline().rstrip())
    if val == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, val)
