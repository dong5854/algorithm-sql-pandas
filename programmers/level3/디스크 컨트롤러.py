"""
디스크 컨트롤러

https://school.programmers.co.kr/learn/courses/30/lessons/42627#
"""
# 오답
import heapq

def solution(jobs):
    
    # 작업 요청시점 순서
    heap = []
    
    ans_time = 0
    cur_time = 0
    for job in jobs:
        # 작업 요청되는 시점, 작업 소요시간
        heapq.heappush(heap, (job[0], job[1]))
    
    # 처음에는 제일 먼저 요청이 들어온 작업
    start, time = heapq.heappop(heap)
    # 처음 작업이 끝났을 때의 시간
    cur_time = start + time
    # 처음에는 그냥 소요시간 그대로 들어감
    ans_time += time
    
    temp = []
    while True:
        if heap:
            start, time = heapq.heappop(heap)
        else:
            if not temp:
                break
        
        # 작업이 끝나기 전에 들어온 요청들
        if start <= cur_time:
            # 걸린 시간
            temp.append((start, time))
        
        #작업이 끝나고 들어온 요청 혹은 heap 비어있는 경우
        if start > cur_time or not heap:
             #작업이 없는 경우
            if not temp:
                # pop한 작업 그대로 진행
                cur_time = start + time
                # 소요시간은 그대로 들어감
                ans_time += time
                
             # 종료시간이 가장 빠른거 빼고 다시 넣기
            else:
                # 수행시간이 가장 짧은 것
                temp.sort(key=lambda x: -x[1])
                start, time = temp.pop()
                # 요청부터 종료까지 소요시간
                ans_time += (cur_time + time) - start
                # 종료시간 갱신
                cur_time = cur_time + time
                while temp:
                    start, time = temp.pop()
                    heapq.heappush(heap, (start, time))
    
    return ans_time // len(jobs)