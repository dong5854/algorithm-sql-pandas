"""
17219번
비밀번호 찾기

https://www.acmicpc.net/problem/17219
"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

dict = {}

for _ in range(n):
    key, val = sys.stdin.readline().rstrip().split()
    dict[key] = val


for _ in range(m):
    target = sys.stdin.readline().rstrip()
    print(dict[target])