"""
1676번
팩토리얼 0의 개수

https://www.acmicpc.net/problem/1676
"""
import sys

def fact(n: int):
    if n == 1 or n == 0:
        return n
    else:
        return n * fact(n-1)

N = int(sys.stdin.readline().rstrip())

num = fact(N)

cnt = 0

while True:
    if num == 0:
        break
    if num % 10 == 0:
        num = num//10
        cnt += 1
    else:
        break

print(cnt)