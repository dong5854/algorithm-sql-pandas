"""
무지의 먹방 라이브

https://school.programmers.co.kr/learn/courses/30/lessons/42891
"""
import heapq

def solution(food_times, k):
    # 전체 음식 시간이 k 보다 크거나 같으면 -1
    if sum(food_times) <= k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        # (먹는데 걸리는 시간, 음식 번호)
        heapq.heappush(q, (food_times[i], i + 1))
    
    # 남은 음식의 개수
    length = len(food_times)
    
    # 직전에 먹은 음식 소요 시간
    prev_food_time = 0
    
    # 음식을 먹는데 소요한 시간
    sum_food_time = 0
    
    # 음식을 다 먹을 수 있는 경우
    while sum_food_time + ((q[0][0] - prev_food_time)) * length <= k:
        now, _ = heapq.heappop(q)
        sum_food_time += (now - prev_food_time) * length
        length -= 1 # 다 먹은 음식 제외
        prev_food_time = now
        
    # 음식을 다 먹지 못하는 경우
    result = sorted(q, key = lambda x: x[1]) # 음식을 번호 기준으로 정렬
    return result[(k - sum_food_time) % length][1]
