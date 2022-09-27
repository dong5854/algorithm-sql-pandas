"""
이중우선순위큐

https://school.programmers.co.kr/learn/courses/30/lessons/42628
"""
import heapq
def solution(operations):
    
    removed = []
    min_heap = []
    max_heap = []
    answer = []
    idx = 0
    for o in operations:
        oper, data = o.split()
        if oper == "I":
            removed.append([False, int(data)])
            heapq.heappush(min_heap, (int(data), idx))
            heapq.heappush(max_heap, (-int(data), idx))
            idx += 1
        if oper == "D":
            if len(min_heap) == 0 or len(max_heap) == 0:
                continue
            if data == "-1":
                while min_heap:
                    v, i = heapq.heappop(min_heap)
                    if removed[i][0] == False:
                        removed[i][0] = True
                        break
            elif data == "1":
                    while max_heap:
                        v, i = heapq.heappop(max_heap)
                        if removed[i][0] == False:
                            removed[i][0] = True
                            break
    
    candidates = []
    for r in removed:
        if r[0] == False:
            candidates.append(r[1])
    if candidates:
        return [max(candidates), min(candidates)]
    else:
        return [0,0]