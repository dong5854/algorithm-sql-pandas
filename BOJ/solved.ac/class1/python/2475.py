"""
2475번
검증수

https://www.acmicpc.net/problem/2475
"""
input = list(map(int, input().split(" ")))

ans = 0
for i in input:
  ans += i ** 2

print(ans%10)
"""
list comprehension를 사용해 더 코드를 짧게 할 수 있다.
L = [x**2 for x in map(int,input().split())]
print(sum(L)%10)
"""