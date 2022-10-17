# 숫자 리스트 초기화
d = [0] * 30_001

# 최소 연산들로 초기화
d[1] = 0 # 1은 자기 자신이므로 초기화 할 필요가 없음
d[2] = 1 # 2로 나누었을 때
d[3] = 1 # 3로 나누었을 때
d[4] = 2 # 2로 두번 나누었을 때
d[5] = 1 # 5로 나누었을 때
def solution(n):
    for i in range(5, n+1):
        candidate = []
        # 5로 나누어 떨어지면
        if i % 5 == 0:
            candidate.append(d[i//5])
        if i % 3 == 0:
            candidate.append(d[i//3])
        if i % 2 == 0:
            candidate.append(d[i//2])
        candidate.append(d[i-1])

        d[i] = min(candidate) + 1

    return d[n]

print(solution(26))