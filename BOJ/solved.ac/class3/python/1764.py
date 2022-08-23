"""
1764번
듣보잡

https://www.acmicpc.net/problem/1764
"""
import sys

N, K = map(int, sys.stdin.readline().rstrip().split())
listen = []
ans = []


for _ in range(N):
    listen.append(sys.stdin.readline().rstrip())

map_listen = set(listen)

for _ in range(K):
    i = sys.stdin.readline().rstrip()
    if i in map_listen:
        ans.append(i)

ans.sort()
print(len(ans))
for a in ans:
    print(a)