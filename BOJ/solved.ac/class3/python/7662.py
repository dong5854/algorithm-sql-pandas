"""
7662번
이중 우선순위 큐

https://www.acmicpc.net/problem/7662
"""
import heapq
import sys


t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    k = int(sys.stdin.readline().rstrip())
    min_heap = []
    max_heap = []
    existing = [False] * 1_000_000

    for key in range(k):
        cmd, num = sys.stdin.readline().rstrip().split()
        num = int(num)

        if cmd == 'I':
            heapq.heappush(min_heap, (num, key))
            heapq.heappush(max_heap, (num * -1, key))
            existing[key] = True
        
        elif cmd == 'D':
            # 최소 값을 빼는 경우
            if num == -1:
                # min_heap이 존재하고 exist가 False 인경우(이미 사라진 경우)
                while min_heap and not existing[min_heap[0][1]]:
                    # max_heap에서 이미 사라진 상태이므로 삭제한다.
                    heapq.heappop(min_heap)
                # 비어있지 않은 경우
                if min_heap:
                    # False 처리하고, 삭제
                    existing[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
                # 최대 값을 빼는 경우, 로직은 최소 값을 빼는 경우와 동일
            else:
                while max_heap and not existing[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    existing[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
    
    while min_heap and not existing[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not existing[max_heap[0][1]]:
        heapq.heappop(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0][0], min_heap[0][0])
    else:
        print("EMPTY")