"""
기지국 설치

https://school.programmers.co.kr/learn/courses/30/lessons/12979
"""
# 효율성 통과한 코드
def solution(n, stations, w):
    answer = 0
    
    # 전파가 닿지 않는 구간
    segment = []
    if stations[0] - w - 1 >= 1:
        segment.append((1, stations[0] - w - 1))
        
    
    for i in range(len(stations)-1):
        head = stations[i] + w + 1
        tail = stations[i+1] - w - 1
        if head >= 1 and tail <= n:
            segment.append((head, tail))
            
    if stations[len(stations)-1] + w + 1 <= n:
        segment.append((stations[len(stations)-1] + w + 1, n))
        
    answer = 0
    for seg in segment:
        coverage = w * 2 + 1
        amt = seg[1] -seg[0] + 1
        answer += amt // coverage
        if (amt%coverage != 0):
            answer += 1
            
        

    print(segment)
    return answer


# 기존 코드 효율성에서 runtime error
def solution(n, stations, w):
    answer = 0
    
    apartments = [0 for i in range(n+1)]
    
    for station in stations:
        apartments[station] = 1
        for i in range(1, w+1):
            # 앞부분
            if station - i >= 1:
                apartments[station-i] = 1
            # 뒷부분
            if station + i <= n:
                apartments[station+i] = 1
    
    print(apartments)
    
    answer = 0
    # 이미 설치된 첫번째 기지국부터 전진하며 설치 시작
    for i in range(stations[0], n+1):
        if i - w >= 1:
            if apartments[i-w] == 0:
                answer += 1
                apartments[i] = 1
                for j in range(1, w+1):
                    # 앞부분
                    if i - j >= 1 and apartments[i-j] == 0:
                        apartments[i-j] = 1
                    # 뒷부분
                    if i + j <= n and apartments[i+j] == 0:
                        apartments[i+j] = 1
    
     # 이미 설치된 첫번째 기지국부터 후진하며 설치 시작
    for i in range(stations[0], 0, -1):
        if i + w <= n:
            if apartments[i+w] == 0:
                answer += 1
                apartments[i] = 1
                for j in range(1, w+1):
                    # 앞부분
                    if i - j >= 1 and apartments[i-j] == 0:
                        apartments[i-j] = 1
                    # 뒷부분
                    if i + j <= n and apartments[i+j] == 0:
                        apartments[i+j] = 1
                        
    
    # 첫번째 지점에서 설치 확인
    if apartments[1] == 0:
        answer += 1
        apartments[1] = 1
        for j in range(1, w+1):
            # 뒷부분
            if 1 + j <= n and apartments[1+j] == 0:
                apartments[1+j] = 1
    # 마지막 지점에서 설치 확인
    if apartments[n] == 0:
        answer += 1
        apartments[n] = 1
        for j in range(1, w+1):
            # 앞부분
            if n - j >= 1 and apartments[n-j] == 0:
                apartments[i-j] = 1
            
    print(apartments)

    return answer

