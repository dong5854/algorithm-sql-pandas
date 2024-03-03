"""
최댓값과 최솟값

https://school.programmers.co.kr/learn/courses/30/lessons/12939
"""
import heapq

def solution(s):
    min_heap = []
    max_heap = []
    input_data = s.split(" ")
    
    for d in input_data:
        heapq.heappush(min_heap, int(d))
        heapq.heappush(max_heap, -int(d))
    
    answer = str(heapq.heappop(min_heap)) + " " +  str(-heapq.heappop(max_heap))
    return answer