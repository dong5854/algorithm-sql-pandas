"""
2609번
최대공약수와 최소공배수

https://www.acmicpc.net/problem/2609
"""
a, b = map(int, input().split())

gcd = 0
lcm = 0

for i in range(1, max(a, b)+1):
  if a % i == 0 and b % i == 0:
    gcd = i

lcm = a * b // gcd
  
print(gcd)
print(lcm)