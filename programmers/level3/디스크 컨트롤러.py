"""
디스크 컨트롤러

https://school.programmers.co.kr/learn/courses/30/lessons/42627#
"""
import heapq

def solution(jobs):
    
    # 전 작업의 종료 시간
    start = -1
    # 현재 시각
    now = 0
    # 정답
    ans = 0
    # 처리한 갯수
    idx = 0
    # 작업 요청시점 순서
    heap = []
    
    # 작업 느린 순서대로 정렬
    jobs.sort(key=lambda x: (x[0], x[1]))

    while idx < len(jobs):
        
        for job in jobs:
            if start < job[0] <= now:
                # 작업 소요시간, 작업 요청시간
                heapq.heappush(heap, (job[1], job[0]))

        if heap:
            current = heapq.heappop(heap)
            start = now
            now += current[0]
            ans += now - current[1]
            idx += 1
        else:
            now += 1
    return ans // len(jobs)


print(solution([[0, 10], [4, 10], [15, 2], [5, 11]]))