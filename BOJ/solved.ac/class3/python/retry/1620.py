"""
1620번
나는야 포켓몬 마스터 이다솜

https://www.acmicpc.net/problem/1620
"""
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

pokedex = {}
for i in range(1, N+1):
    name = sys.stdin.readline().rstrip()
    pokedex[name] = i
    pokedex[str(i)] = name

for _ in range(M):
    search = sys.stdin.readline().rstrip()
    print(pokedex[search])