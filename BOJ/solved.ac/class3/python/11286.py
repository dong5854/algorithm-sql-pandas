"""
11286번
절댓값 힙

https://www.acmicpc.net/problem/11286
"""
import sys
import heapq

n = int(sys.stdin.readline().rstrip())

heap = []
ans = []
for _ in range(n):
    v = int(sys.stdin.readline().rstrip())
    if v == 0:
        try:
            ans.append(heapq.heappop(heap)[1])
        except IndexError:
            ans.append(0)
    else:
        heapq.heappush(heap, (abs(v), v))

for a in ans:
    print(a)