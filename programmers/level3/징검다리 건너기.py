"""
징검다리 건너기

https://school.programmers.co.kr/learn/courses/30/lessons/64062
"""
def walk_through(stones, k):
    left, right = 1, max(stones)
    answer = 0
    while left <= right:
        cnt = 0
        mid = (left+right) // 2 # 중간값
        for stone in stones:
            if stone <= mid:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break
        if cnt < k:
            left = mid + 1
        else:
            answer = mid
            right = mid - 1
    return answer
    
def solution(stones, k):
    answer = walk_through(stones, k)
    return answer


# 효율성에서 틀린 답안
"""
def walk_through(stones, k):
    cnt = 0
    for i in range(len(stones)):
        if stones[i] == 0:
            cnt += 1
        else:
            stones[i] -= 1
            cnt = 0
        if cnt == k:
            return False
    return True

def solution(stones, k):
    answer = 0
    while walk_through(stones, k):
        answer += 1
    return answer
"""