# 내 풀이
n, m = map(int, input().split())
candidates = []

for i in range(n):
    line = list(map(int, input().split()))
    candidates.append(min(line))

print(max(candidates))
"""
# 책의 풀이

n, m = map(int, input().split())

result = 0

for i in range(n):
    line = list(map(int, input().split()))
    min_value = min(data)
    result = max(result, min_value)

print(result)
"""