"""
단속카메라

https://school.programmers.co.kr/learn/courses/30/lessons/42884
"""
import heapq

def solution(routes):
    routes.sort(key=lambda x: x[1])
    camera = []
    print(routes)
    for route in routes:
        if camera:
            if route[0] <= camera[0][1] <= route[1]:
                continue
            else:
                heapq.heappush(camera, (-route[1], route[1]))
        else:       
            heapq.heappush(camera, (-route[1], route[1]))
    return len(camera)