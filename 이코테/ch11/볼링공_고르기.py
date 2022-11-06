import sys

# N = 공의 개수, M = 최대 무게
N, M = map(int, sys.stdin.readline().rstrip().split())

weights = [0 for _ in range(11)]

balls = list(map(int, sys.stdin.readline().rstrip().split()))

# 무게 채우기
for b in balls:
    weights[b] += 1

print(weights)
result = 0
# 1부터 M 까지에 대해서 처리
for i in range(1, M + 1):
    # 한명이 weights[b] 무게의 공을 잡은 경우, 빼는 이유는 이미 계산했던 경우는 제외하기 때문 
    N -= weights[i]
    # 다른 한명이 나머지(N) 개중에 공을 잡는다
    result += weights[i] * N

print(result)