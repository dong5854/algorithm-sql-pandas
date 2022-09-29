import heapq

def solution(n, works):
    heap = []
    for work in works:
        # 최대 힙
        heapq.heappush(heap, (-work, work))
        
    while n > 0:
        work = heapq.heappop(heap)[1] - 1
        heapq.heappush(heap, (-work, work))
        n -= 1
        
    answer = 0
    for h in heap:
        if h[1] > 0:
            answer += h[1] ** 2
        

    return answer