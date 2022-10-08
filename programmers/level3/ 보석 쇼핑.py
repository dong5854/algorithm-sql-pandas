"""
보석 쇼핑

https://school.programmers.co.kr/learn/courses/30/lessons/67258
"""
from collections import defaultdict

def solution(gems):
    answer = [0, 0]
    start, end = 0, 0
    market_len = len(gems)
    gems_kind_len = len(set(gems))
    candidates = []
    gems_dict = defaultdict(lambda: 0)
    
    while True:
        # 모은 보석의 개수
        collected_kind = len(gems_dict)
        
        # 탐색 끝나면 탈출(index out of range)
        if start == market_len:
            break
            
        # 모든 종류의 보석을 다 모음
        if collected_kind == gems_kind_len:
            # 후보에 추가
            candidates.append((start, end))
            # 첫번째 보석 지우고 인덱스 다음으로 올리기
            gems_dict[gems[start]] -= 1
            if gems_dict[gems[start]] == 0:
                del gems_dict[gems[start]]
            start += 1
            continue
        
        # 탐색 끝나면 탈출(index out of range)
        if end == market_len:
            break
            
        # 마지막 인덱스 늘려서 보석 추가하기
        if collected_kind != gems_kind_len:
            gems_dict[gems[end]] += 1
            end += 1
    
    min_len = 100_001
    for s, e in candidates:
        if min_len > e - s:
            min_len = e- s
            answer[0] = s + 1
            answer[1] = e
    
    return answer