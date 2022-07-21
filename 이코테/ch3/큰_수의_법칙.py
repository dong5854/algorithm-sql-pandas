# 내 풀이
n,m,k = map(int, input().split())

data = list(map(int, input().split()))

data.sort(reverse=True)

cnt = 0
sum = 0
for i in range(m):
    if cnt < k:
        sum += data[0]
        cnt += 1
    else:
        sum += data[1]
        cnt = 0

print(sum)

"""
# 책의 풀이

n, m, k = map(int, input().split())

data = list(map(int, input().split()))

data.sort()
first = data[n-1] # 가장 큰 수
second = data[n-2] # 두 번째로 큰 수

count = int(m / (k +1)) * k
count += m % (k + 1)

result = 0 
result += (count) * count # 가장 큰 수 더하기
result += (m - count) * second # 두 번째로 큰 수 더하기

print(result)
"""